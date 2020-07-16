package com.willchan.simple_random_stock.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.willchan.simple_random_stock.repositories.StockRepository;
import com.willchan.simple_random_stock.roomdatabase.entities.Stock;

import java.util.List;

// Never pass context into ViewModel instances
// Do not store Activity, Fragment, or View instances or their context in the ViewModel
public class StockViewModel extends AndroidViewModel {
    // Add a private member variable to hold a reference to the Repository
    private StockRepository stockRepository;
    // Add a private LiveData member variable to cache the list of words
    private LiveData<List<Stock>> allStock;

    // Add a constructor that gets a reference to StockRepository and gets all the list of words from StockRepository
    public StockViewModel(Application application) {
        super(application);
        stockRepository = new StockRepository(application);
        allStock = stockRepository.getAllStock();
    }

    // Add a getter method to get all the stocks. Completely hides the implementation from the UI
    public LiveData<List<Stock>> getAllStock() {
        return this.allStock;
    }

    // Create a wrapper insert method that calls the Repository's insert(). In this way,
    // the implementations of insert() is completely hidden from the UI.
    public void insert(@NonNull Stock stock) {
        stockRepository.insert(stock);
    }

    // Create a wrapper delete method that calls the Repository's insert(). In this way,
    // the implementations of delete() is completely hidden from the UI.
    public void delete(@NonNull Stock stock) {
        stockRepository.delete(stock);
    }
}
