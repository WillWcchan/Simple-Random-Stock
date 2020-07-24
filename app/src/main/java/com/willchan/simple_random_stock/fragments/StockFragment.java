package com.willchan.simple_random_stock.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.willchan.simple_random_stock.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StockFragment extends Fragment {
    public static final String stockNameBundle = "STOCK_NAME";
    public static final String stockTickerBundle = "STOCK_TICKER";
    private TextView stockNameTextView, congratulationsTitleTextView;
    private ImageView congratulationsImageView;

    public StockFragment() {
        // Required empty public constructor
    }

    // Congratulation Photo by Ankush Minda on Unsplash (https://unsplash.com/photos/VcD5OD2jDGA)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stock, container, false);
        congratulationsImageView = view.findViewById(R.id.congratulationsImageView);
        congratulationsTitleTextView = view.findViewById(R.id.congratulationsTitle);
        stockNameTextView = view.findViewById(R.id.stock_name_created);

        Bundle bundle = getArguments();
        // if IndexStockFragment calls StockFragment and passes in data via a bundle
        if (bundle != null) {

            // Have the UI background pause a bit for the background thread to load
            // both the stock and delete

            String stockName = bundle.getString(StockFragment.stockNameBundle);
            String stockTicker = bundle.getString(StockFragment.stockTickerBundle);
            String placeHolder = stockName + " (" + stockTicker + ")";

            congratulationsImageView.setVisibility(View.VISIBLE);
            congratulationsTitleTextView.setVisibility(View.VISIBLE);
            stockNameTextView.setText(placeHolder);
        } else {
            // Set the default message when a bundle is not provided
            congratulationsImageView.setVisibility(View.INVISIBLE);
            congratulationsTitleTextView.setVisibility(View.INVISIBLE);
            stockNameTextView.setText(R.string.no_random_stock_selected_yet);
        }
        return view;
    }
}
