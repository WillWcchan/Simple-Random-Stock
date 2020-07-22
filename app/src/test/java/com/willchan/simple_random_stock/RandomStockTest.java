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

@RunWith(JUnit4.class)
public class RandomStockTest {

    @Before
    public void setup() {
        mock(Log.class);
    }

    // @SmallTest
    @Test
    public void getDow30StockTickerLengthEqualTo30() {
        assertEquals(RandomStock.getDow30StockTicker().length, 30);
    }

    @Test
    public void getDow30StockNameLengthEqualTo30() {
        assertEquals(RandomStock.getDow30StockName().length, 30);
    }

    @Test
    public void getSPY500StockTickerLengthGreaterThanOrEqualTo500() {
        assertTrue(RandomStock.getSpy500StockTicker().length >= 500);
    }

    @Test
    public void getSPY500StockNameLengthGreaterThanOrEqualTo500() {
        assertTrue(RandomStock.getSpy500StockName().length >= 500);
    }

    @Test
    public void getNASDAQ100StockTickerLengthGreaterThanOrEqualTo100() {
        assertTrue(RandomStock.getNasdaq100StockTicker().length >= 100);
    }

    @Test
    public void getNASDAQ100StockNameLengthGreaterThanOrEqualTo100() {
        assertTrue(RandomStock.getNasdaq100StockName().length >= 100);
    }

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

    @Test
    public void matchDow30StockTickerAndStockName() {
        String ticker = RandomStock.getDow30StockTicker()[18];
        String stockName = RandomStock.getDow30StockName()[18];
        assertTrue(ticker.equalsIgnoreCase("MSFT") &&
                stockName.equalsIgnoreCase("Microsoft Corp"));
    }

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

    @Test
    public void matchSPY500StockTickerAndStockName() {
        String ticker = RandomStock.getSpy500StockTicker()[91];
        String stockName = RandomStock.getSpy500StockName()[91];
        assertTrue(ticker.equalsIgnoreCase("CCL") &
                stockName.equalsIgnoreCase("Carnival Corp."));
    }

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

    @Test
    public void matchNASDAQ100StockTickerAndStockName() {
        String ticker = RandomStock.getNasdaq100StockTicker()[79];
        String stockName = RandomStock.getNasdaq100StockName()[79];
        assertTrue(ticker.equalsIgnoreCase("NVDA") &
                stockName.equalsIgnoreCase("NVIDIA Corp"));
    }

    @Test
    public void getRandomStockPositionForDow() {
        assertTrue(RandomStock.getRandomStockPosition(RandomStock.StockIndex.DOW) > 0);
    }

    @Test
    public void getRandomStockPositionForSPY() {
        assertTrue(RandomStock.getRandomStockPosition(RandomStock.StockIndex.SPY) > 0);
    }

    @Test
    public void getRandomStockPositionForNASDAQ() {
        assertTrue(RandomStock.getRandomStockPosition(RandomStock.StockIndex.NASDAQ) > 0);
    }

    @Test
    public void getRandomStockPositionForNullValue() {
        boolean gotNull = false;
        try {
            RandomStock.getRandomStockPosition(null);
        } catch (NullPointerException e) {
            gotNull = true;
        }
        assertTrue(gotNull);
    }
}
