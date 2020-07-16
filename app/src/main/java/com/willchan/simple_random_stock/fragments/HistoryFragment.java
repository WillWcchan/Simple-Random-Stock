package com.willchan.simple_random_stock.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.willchan.simple_random_stock.R;
import com.willchan.simple_random_stock.adapters.HistoryListAdapter;
import com.willchan.simple_random_stock.roomdatabase.entities.Stock;
import com.willchan.simple_random_stock.viewmodels.StockViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {
    private StockViewModel stockViewModel;

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        // Load all the stock history in the History Tab Fragment
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        final HistoryListAdapter historyListAdapter = new HistoryListAdapter(getActivity());
        recyclerView.setAdapter(historyListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        stockViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(StockViewModel.class);
        stockViewModel.getAllStock().observe(this, new Observer<List<Stock>>() {
            // When the observed data changes while the activity is in the foreground
            // onChanged is invoked and updates the data cached in the adapter
            @Override
            public void onChanged(List<Stock> stocks) {
                historyListAdapter.setStocks(stocks);
            }
        });
        return view;
    }
}
