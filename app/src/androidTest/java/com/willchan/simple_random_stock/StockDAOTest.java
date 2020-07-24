package com.willchan.simple_random_stock;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import com.willchan.simple_random_stock.roomdatabase.RoomDB;
import com.willchan.simple_random_stock.roomdatabase.daos.StockDao;
import com.willchan.simple_random_stock.roomdatabase.entities.Stock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertTrue;

// Test and debug your database, source: https://developer.android.com/training/data-storage/room/testing-db
@SmallTest
@RunWith(AndroidJUnit4.class)
public class StockDAOTest {
    private static final String FAKE_STOCK_NAME = "FakeStockName";
    private static final String FAKE_STOCK_TICKER = "FakeStockName";
    private StockDao stockDAO;
    private RoomDB db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, RoomDB.class).build();
        stockDAO = db.stockDAO();
    }

    @After
    public void closeDb() {
        db.close();
    }

    @Test
    public void writeStockDAOAndReadInList() {
        boolean foundStock = false;
        Stock newStock = new Stock(FAKE_STOCK_NAME, FAKE_STOCK_TICKER);
        Objects.requireNonNull(stockDAO);
        stockDAO.insert(newStock);
        List<Stock> getStocks = stockDAO.getAllStocks();
        for (Stock stock : getStocks)
            if (stock.getName().equalsIgnoreCase(FAKE_STOCK_NAME)) {
                foundStock = true;
                break;
            }
        assertTrue(foundStock);
    }

    @Test
    public void clearStockDAOList() {
        Objects.requireNonNull(stockDAO);
        stockDAO.deleteAllStocks();
        List<Stock> stocks = stockDAO.getAllStocks();
        assertTrue(stocks.isEmpty());
    }

}
