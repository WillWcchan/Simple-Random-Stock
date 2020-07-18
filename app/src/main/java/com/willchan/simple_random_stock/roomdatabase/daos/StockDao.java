package com.willchan.simple_random_stock.roomdatabase.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.willchan.simple_random_stock.roomdatabase.entities.Stock;

import java.util.List;

// Identify the class as a DAO class for Room
@Dao
public interface StockDao {
    // Room takes care of thread management for you
    @Insert
    void insert(Stock stock);

    // Room takes care of thread management for you
    @Delete
    void delete(Stock stock);

    // Must execute on a thread other than main thread
    @Query("DELETE FROM stock_table")
    void deleteAllStocks();

    @Query("SELECT * FROM stock_table")
    List<Stock> getAllStocks();

}
