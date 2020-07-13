package com.willchan.simple_random_stock.activities;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.willchan.simple_random_stock.R;

public class AboutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Source: https://developer.android.com/training/appbar/up-action
        Toolbar toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

        // Get a support Actionbar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up Button
        ab.setDisplayHomeAsUpEnabled(true);
    }


}
