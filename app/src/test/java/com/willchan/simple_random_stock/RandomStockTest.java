package com.willchan.simple_random_stock;

import android.util.Log;

import com.willchan.simple_random_stock.util.RandomStock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

// Source: https://stackoverflow.com/questions/4671923/what-is-the-purpose-of-smalltest-mediumtest-and-largetest-annotations-in-an
@RunWith(JUnit4.class)
public class RandomStockTest {

    @Before
    public void setup() {
        mock(Log.class);
    }

    //    @SmallTest
    @Test
    public void getDow30StockTickerLengthEqualTo30() {
        assertEquals(RandomStock.getDow30StockTicker().length, 30);
    }

    //    @SmallTest
    @Test
    public void getDow30StockNameLengthEqualTo30() {
        assertEquals(RandomStock.getDow30StockName().length, 30);
    }

    //    @SmallTest
    @Test
    public void getSPY500StockTickerLengthGreaterThanOrEqualTo500() {
        assertTrue(RandomStock.getSpy500StockTicker().length >= 500);
    }

    //    @SmallTest
    @Test
    public void getSPY500StockNameLengthGreaterThanOrEqualTo500() {
        assertTrue(RandomStock.getSpy500StockName().length >= 500);
    }

    //    @SmallTest
    @Test
    public void getNASDAQ100StockTickerLengthGreaterThanOrEqualTo100() {
        assertTrue(RandomStock.getNasdaq100StockTicker().length >= 100);
    }

    //    @SmallTest
    @Test
    public void getNASDAQ100StockNameLengthGreaterThanOrEqualTo100() {
        assertTrue(RandomStock.getNasdaq100StockName().length >= 100);
    }

    //    @SmallTest
    @Test
    public void getDow30StockTickerMMM() {
        boolean foundMMM = false;
        String[] tickers = RandomStock.getDow30StockTicker();
        for (String ticker : tickers) {
            if (ticker.equalsIgnoreCase("MMM")) {
                foundMMM = true;
                break;
            }
        }
        assertTrue(foundMMM);
    }

    //    @SmallTest
    @Test
    public void matchDow30StockTickerAndStockName() {
        String ticker = RandomStock.getDow30StockTicker()[18];
        String stockName = RandomStock.getDow30StockName()[18];
        assertTrue(ticker.equalsIgnoreCase("HD") &&
                stockName.equalsIgnoreCase("Home Depot Inc"));
    }

    //    @SmallTest
    @Test
    public void getSPY500StockTickerCostco() {
        boolean foundCostco = false;
        String[] tickers = RandomStock.getSpy500StockTicker();
        for (String ticker : tickers) {
            if (ticker.equalsIgnoreCase("COST")) {
                foundCostco = true;
                break;
            }
        }
        assertTrue(foundCostco);
    }

    //    @SmallTest
    @Test
    public void matchSPY500StockTickerAndStockName() {
        String ticker = RandomStock.getSpy500StockTicker()[91];
        String stockName = RandomStock.getSpy500StockName()[91];
        assertTrue(ticker.equalsIgnoreCase("CTLT") &
                stockName.equalsIgnoreCase("Catalent"));
    }

    //    @SmallTest
    @Test
    public void getNASDAQ100StockTickerTesla() {
        boolean foundTelsa = false;
        String[] tickers = RandomStock.getNasdaq100StockTicker();
        for (String ticker : tickers) {
            if (ticker.equalsIgnoreCase("TSLA")) {
                foundTelsa = true;
                break;
            }
        }
        assertTrue(foundTelsa);
    }

    //    @SmallTest
    @Test
    public void matchNASDAQ100StockTickerAndStockName() {
        String ticker = RandomStock.getNasdaq100StockTicker()[79];
        String stockName = RandomStock.getNasdaq100StockName()[79];
        assertTrue(ticker.equalsIgnoreCase("PYPL") &
                stockName.equalsIgnoreCase("Paypal holdings"));
    }

    //    @SmallTest
    @Test
    public void getRandomStockPositionForDow() {
        assertTrue(RandomStock.getRandomStockPosition(RandomStock.StockIndex.DOW) > 0);
    }

    //    @SmallTest
    @Test
    public void getRandomStockPositionForSPY() {
        assertTrue(RandomStock.getRandomStockPosition(RandomStock.StockIndex.SPY) > 0);
    }

    //    @SmallTest
    @Test
    public void getRandomStockPositionForNASDAQ() {
        assertTrue(RandomStock.getRandomStockPosition(RandomStock.StockIndex.NASDAQ) > 0);
    }

    //    @SmallTest
    @Test
    public void getRandomStockPositionForBadValue() {
        boolean badValue;
        int position = RandomStock.getRandomStockPosition(null);
        badValue = position == -1;
        assertTrue(badValue);
    }
}
