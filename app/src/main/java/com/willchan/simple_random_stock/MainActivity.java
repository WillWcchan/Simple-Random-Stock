package com.willchan.simple_random_stock;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.willchan.simple_random_stock.activities.AboutActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Source: https://developer.android.com/training/appbar/actions
        // This sets the toolbar as the app bar for the activity
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    // Source: https://www.studytonight.com/android/menu-in-android#:~:text=This%20is%20done%20by%20right%20clicking%20on%20res,in%20the%20Resource%20type.%20Then%2C%20click%20on%20OK.
    // When user selects one of the app bar items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Source: https://www.studytonight.com/android/menu-in-android#:~:text=This%20is%20done%20by%20right%20clicking%20on%20res,in%20the%20Resource%20type.%20Then%2C%20click%20on%20OK.
    // To make an option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_file, menu);
        return true;
    }

}
