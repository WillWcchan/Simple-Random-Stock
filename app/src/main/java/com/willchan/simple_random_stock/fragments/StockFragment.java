package com.willchan.simple_random_stock.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.willchan.simple_random_stock.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StockFragment extends Fragment {
    private TextView textView;

    public StockFragment() {
        // Required empty public constructor
    }

    // Congratulation Photo by Ankush Minda on Unsplash (https://unsplash.com/photos/VcD5OD2jDGA)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stock, container, false);
        textView = view.findViewById(R.id.stock_name);
        return view;
    }





}
