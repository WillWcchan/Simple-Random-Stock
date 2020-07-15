package com.willchan.simple_random_stock.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.willchan.simple_random_stock.entities.StockEntity;

import java.util.List;

@Dao
public interface StockDao {
    @Insert
    void insert(StockEntity stockEntity);

    @Delete
    void delete(StockEntity stockEntity);

    @Query("DELETE FROM stock_table")
    void deleteAll();

    @Query("SELECT * FROM stock_table")
    List<StockEntity> getAll();
}
