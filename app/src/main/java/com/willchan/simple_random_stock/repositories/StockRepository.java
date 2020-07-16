package com.willchan.simple_random_stock.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.willchan.simple_random_stock.roomdatabase.RoomDB;
import com.willchan.simple_random_stock.roomdatabase.daos.StockDao;
import com.willchan.simple_random_stock.roomdatabase.entities.Stock;

import java.util.List;

public class StockRepository {
    private StockDao stockDAO;
    private LiveData<List<Stock>> allStock;

    // Constructor that gets a handle to the database and initialize the member variables
    public StockRepository(Application app) {
        RoomDB db = RoomDB.getInstance(app);
        stockDAO = db.stockDAO();
        allStock = stockDAO.getAll();
    }

    // Add a wrapper method that returns the cached words as LiveData. Room executes
    // all queries on a separate thread. Observed LiveData notifies the observer when data is changed
    public LiveData<List<Stock>> getAllStock() {
        return allStock;
    }

    // Add a wrapper for insert method. Use an AsyncTask to call insert on a non-UI thread or
    // your app will crash.
    public void insert(Stock stock) {
        new InsertAsyncTask(stockDAO).execute(stock);
    }

    // Add a wrapper for delete method. Use an AsyncTask to call delete on a non-UI thread or
    // your app will crash.
    public void delete(Stock stock) {
        new DeleteAsyncTask(stockDAO).execute(stock);
    }

    private static class InsertAsyncTask extends AsyncTask<Stock, Void, Void> {
        private StockDao stockDAO;

        InsertAsyncTask(StockDao stockDAO) {
            this.stockDAO = stockDAO;
        }

        @Override
        protected Void doInBackground(Stock... stocks) {
            stockDAO.insert(stocks[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<Stock, Void, Void> {
        private StockDao stockDAO;

        DeleteAsyncTask(StockDao stockDAO) {
            this.stockDAO = stockDAO;
        }

        @Override
        protected Void doInBackground(Stock... stocks) {
            stockDAO.delete(stocks[0]);
            return null;
        }
    }
}
