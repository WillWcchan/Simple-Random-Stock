package com.willchan.simple_random_stock.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.willchan.simple_random_stock.repositories.StockRepository;
import com.willchan.simple_random_stock.roomdatabase.entities.Stock;

import java.util.List;


public class StockViewModel extends AndroidViewModel {
    private StockRepository stockRepository;
    private List<Stock> allStock;

    // Never pass context into ViewModel instances
    // Do not store Activity, Fragment, or View instances or their context in the ViewModel
    // Add a constructor that gets a reference to StockRepository and gets all the list of words from StockRepository
    public StockViewModel(Application application) {
        super(application);
        stockRepository = new StockRepository(application);
        allStock = stockRepository.getAllStock();
    }

    // Add a getter method to get all the stocks. Completely hides the implementation from the UI
    public List<Stock> getAllStock() {
        return this.allStock;
    }

    public void deleteAllStocks() {
        stockRepository.deleteAllStocks();
    }

    public void insert(@NonNull Stock stock) {
        stockRepository.insert(stock);
    }

    public void delete(@NonNull Stock stock) {
        stockRepository.delete(stock);
    }

}
