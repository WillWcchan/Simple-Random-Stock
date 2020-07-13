package com.willchan.simple_random_stock.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.willchan.simple_random_stock.fragments.HistoryFragment;
import com.willchan.simple_random_stock.fragments.IndexFragment;
import com.willchan.simple_random_stock.fragments.StockFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    private int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position of the Tab item that was clicked in the TabLayout
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new IndexFragment();
            case 1:
                return new StockFragment();
            case 2:
                return new HistoryFragment();
            default:
                return null;
        }
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return this.mNumOfTabs;
    }
}
