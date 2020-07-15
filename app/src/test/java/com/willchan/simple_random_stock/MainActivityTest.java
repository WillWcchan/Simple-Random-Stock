package com.willchan.simple_random_stock;

import com.willchan.simple_random_stock.util.RandomStock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MainActivityTest {

    @Test
    public void test() {
        for (int i = 0; i <= 30; i++) {
            RandomStock.getRandomStock(RandomStock.StockIndex.DOW);
        }
        for (int i = 0; i <= 100; i++) {
            RandomStock.getRandomStock(RandomStock.StockIndex.SPY);
        }
        for (int i = 0; i <= 100; i++) {
            RandomStock.getRandomStock(RandomStock.StockIndex.NASDAQ);
        }
    }
}
