package com.willchan.simple_random_stock.roomdatabase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.willchan.simple_random_stock.roomdatabase.daos.StockDao;
import com.willchan.simple_random_stock.roomdatabase.entities.Stock;
import com.willchan.simple_random_stock.util.RandomStock;

import org.jetbrains.annotations.NotNull;

// Usually, you only need one instance of the RoomDatabase for the whole app
@Database(entities = {Stock.class}, version = 3, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    // Create the ROOMDB as a singleton to prevent having multiple instances of the DB opened at the same time
    private static RoomDB INSTANCE;
    private static String DATABASE_NAME = "database";
    // Delete all content and repopulate the database whenever the app is started
    private static RoomDB.Callback roomDBcallBack = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDBAsync(INSTANCE).execute();
        }
    };

    public synchronized static RoomDB getInstance(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext()
                    , RoomDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    // Wipes & rebuilds instead of migrating
                    .fallbackToDestructiveMigration()
                    .addCallback(roomDBcallBack)
                    .build();
        }
        return INSTANCE;
    }

    // Define the DAOs that work with the database. Provide an abstract getter method for each @DAO
    public abstract StockDao stockDAO();

    // Delete all the stocks and populate new ones
    private static class PopulateDBAsync extends AsyncTask<Void, Void, Void> {
        private StockDao stockDao;

        PopulateDBAsync(@NotNull RoomDB db) {
            stockDao = db.stockDAO();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            stockDao.deleteAll();
            for (int i = 0; i < 5; i++) {
                int position = RandomStock.getRandomStock(RandomStock.StockIndex.DOW);
                String stockName = RandomStock.getDow30StockName()[position];
                String stockTicker = RandomStock.getDow30StockTicker()[position];
                Stock stock = new Stock(stockName, stockTicker);
                stockDao.insert(stock);
            }
            return null;
        }
    }
}
