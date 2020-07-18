package com.willchan.simple_random_stock.repositories;

import android.app.Application;
import android.os.AsyncTask;

import com.willchan.simple_random_stock.roomdatabase.RoomDB;
import com.willchan.simple_random_stock.roomdatabase.daos.StockDao;
import com.willchan.simple_random_stock.roomdatabase.entities.Stock;

import java.util.List;

public class StockRepository {
    private StockDao stockDAO;
    private List<Stock> allStock;

    public StockRepository(Application app) {
        RoomDB db = RoomDB.getInstance(app);
        stockDAO = db.stockDAO();
        allStock = stockDAO.getAllStocks();
    }

    public List<Stock> getAllStock() {
        return this.allStock;
    }

    public void deleteAllStocks() {
        new DeleteAllAsyncTask(stockDAO).execute();
    }

    public void insert(Stock stock) {
        new InsertAsyncTask(stockDAO).execute(stock);
    }

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

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private StockDao stockDAO;

        DeleteAllAsyncTask(StockDao stockDAO) {
            this.stockDAO = stockDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            stockDAO.deleteAllStocks();
            return null;
        }
    }
}
