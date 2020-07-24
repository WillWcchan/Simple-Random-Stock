package com.willchan.simple_random_stock.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.willchan.simple_random_stock.BuildConfig;
import com.willchan.simple_random_stock.MainActivity;
import com.willchan.simple_random_stock.R;
import com.willchan.simple_random_stock.roomdatabase.entities.Stock;
import com.willchan.simple_random_stock.util.RandomStock;
import com.willchan.simple_random_stock.viewmodels.StockViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class IndexFragment extends Fragment {
    private StockViewModel stockViewModel;
    private View indexView;
    private CardView dow_index, spy_index, nasdaq_index;
    private String name = null, ticker = null;
    private int position = 0;

    public IndexFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        indexView = inflater.inflate(R.layout.fragment_index, container, false);
        dow_index = indexView.findViewById(R.id.card_dow_jones);
        spy_index = indexView.findViewById(R.id.card_spy500);
        nasdaq_index = indexView.findViewById(R.id.card_nasdaq);

        // Set click listeners to the CardView so when they are clicked, they'll invoke the StockIndexSelectedCallBack inner class below
        dow_index.setOnClickListener(new StockIndexSelectedCallBack());
        spy_index.setOnClickListener(new StockIndexSelectedCallBack());
        nasdaq_index.setOnClickListener(new StockIndexSelectedCallBack());

        try {
            stockViewModel = new StockViewModel(getActivity().getApplication());
        } catch (NullPointerException e) {
            Log.e(IndexFragment.class.toString(), "NullPointerException possibly came from trying to set an application");
        }
        return indexView;
    }

    void showDialog() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.random_stock_dialog, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(getContext()).setView(view).create();
        alertDialog.setCancelable(true);
        alertDialog.show();
        // after a second, dismiss the dialog
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                alertDialog.dismiss();
            }
        }, 2000);
    }


    public class StockIndexSelectedCallBack implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.card_dow_jones) {
                dow_index.setEnabled(false); // prevent double clicks
                position = RandomStock.getRandomStockPosition(RandomStock.StockIndex.DOW);
                if (position > 0) {
                    name = RandomStock.getDow30StockName()[position];
                    ticker = RandomStock.getDow30StockTicker()[position];
                }
            } else if (v.getId() == R.id.card_spy500) {
                spy_index.setEnabled(false);  // prevent double clicks
                position = RandomStock.getRandomStockPosition(RandomStock.StockIndex.SPY);
                if (position > 0) {
                    name = RandomStock.getSpy500StockName()[position];
                    ticker = RandomStock.getSpy500StockTicker()[position];
                }
            } else if (v.getId() == R.id.card_nasdaq) {
                nasdaq_index.setEnabled(false);  // prevent double clicks
                position = RandomStock.getRandomStockPosition(RandomStock.StockIndex.NASDAQ);
                if (position > 0) {
                    name = RandomStock.getNasdaq100StockName()[position];
                    ticker = RandomStock.getNasdaq100StockTicker()[position];
                }
            }

            // Imitate getting a random stock
            // Source: https://stackoverflow.com/questions/23844667/how-do-i-detect-if-i-am-in-release-or-debug-mode
            if (!BuildConfig.DEBUG)
                showDialog();

            // Insert the newly random stock
            if (name != null && ticker != null) {
                Stock stock = new Stock(name, ticker);
                stockViewModel.insert(stock);

                // Sent the newly created stock to the StockFragment to be shown
                // Pass data from fragment to fragment via bundle
                StockFragment stockFragment = new StockFragment();
                Bundle args = new Bundle();
                args.putString(StockFragment.stockNameBundle, name);
                args.putString(StockFragment.stockTickerBundle, ticker);
                stockFragment.setArguments(args);

                // This will call the StockFragment's onCreateView method
                try {
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.card, stockFragment).commit();

                    // Change the current tab to show the new random stock
                    ((MainActivity) getActivity()).selectCurrentTabToView(MainActivity.Tabs.STOCK);
                } catch (NullPointerException e) {
                    Log.e(IndexFragment.class.toString(), "NullPointerException possibly from beginTrasaction or selectCurrentTabToView");
                }
            }
        }
    }

}
