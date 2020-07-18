package com.willchan.simple_random_stock.roomdatabase.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.willchan.simple_random_stock.util.DateConverter;

import java.util.Date;

@Entity(tableName = "stock_table")
public class Stock {

    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "ticker")
    private String ticker;

    @ColumnInfo(name = "date")
    @TypeConverters(DateConverter.class)
    private Date date_picked;

    public Stock(@NonNull String name, @NonNull String ticker) {
        this.name = name;
        this.ticker = ticker;
        this.date_picked = new Date();
    }

    public Stock(@NonNull String name, @NonNull String ticker, @NonNull Date date) {
        this.name = name;
        this.ticker = ticker;
        this.date_picked = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Date getDate_picked() {
        return date_picked;
    }

    public void setDate_picked(Date date_picked) {
        this.date_picked = date_picked;
    }
}
