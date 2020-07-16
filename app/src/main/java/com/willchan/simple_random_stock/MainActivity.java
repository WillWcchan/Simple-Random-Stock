package com.willchan.simple_random_stock;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.willchan.simple_random_stock.activities.AboutActivity;
import com.willchan.simple_random_stock.adapters.TabLayoutAdapter;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private TabLayoutAdapter tabLayoutAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Source: https://developer.android.com/training/appbar/actions
        // This sets the toolbar as the app bar for the activity
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Source: https://material.io/develop/android/components/tab-layout/
        // Set up the TabLayout to show the following tabs: Index, Stock, History
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tabLayoutAdapter = new TabLayoutAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabLayoutAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    public void selectCurrentTabToView(Tabs specifiedTab) {
        TabLayout.Tab tab = tabLayout.getTabAt(specifiedTab.ordinal());
        tab.select();
    }

    // Source: https://www.studytonight.com/android/menu-in-android#:~:text=This%20is%20done%20by%20right%20clicking%20on%20res,in%20the%20Resource%20type.%20Then%2C%20click%20on%20OK.
    // When user selects one of the app bar items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

    // Source: https://www.studytonight.com/android/menu-in-android#:~:text=This%20is%20done%20by%20right%20clicking%20on%20res,in%20the%20Resource%20type.%20Then%2C%20click%20on%20OK.
    // To make an option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_file, menu);
        return true;
    }

    public enum Tabs {
        INDEX, STOCK, HISTORY
    }
}
