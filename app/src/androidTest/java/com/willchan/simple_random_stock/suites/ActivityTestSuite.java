package com.willchan.simple_random_stock.suites;

import com.willchan.simple_random_stock.IndexFragmentTest;
import com.willchan.simple_random_stock.StockDAOTest;
import com.willchan.simple_random_stock.StockFragmentTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        IndexFragmentTest.class,
        StockDAOTest.class,
        StockFragmentTest.class
})
public class ActivityTestSuite {
}
