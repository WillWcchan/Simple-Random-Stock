package com.willchan.simple_random_stock.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.willchan.simple_random_stock.roomdatabase.daos.StockDao;
import com.willchan.simple_random_stock.roomdatabase.entities.Stock;

// Usually, you only need one instance of the RoomDatabase for the whole app
@Database(entities = {Stock.class}, version = 5, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    private static RoomDB INSTANCE;     // Create the RoomDB as a singleton to prevent having multiple instances of the DB opened at the same time
    private static String DATABASE_NAME = "database";

    public synchronized static RoomDB getInstance(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext()
                    , RoomDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()  // Wipes & rebuilds instead of migrating
                    .build();
        }
        return INSTANCE;
    }

    // Define the DAOs that work with the database. Provide an abstract getter method for each @DAO
    public abstract StockDao stockDAO();


}
