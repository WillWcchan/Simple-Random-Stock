package com.willchan.simple_random_stock.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.willchan.simple_random_stock.R;
import com.willchan.simple_random_stock.adapters.HistoryListAdapter;
import com.willchan.simple_random_stock.interfaces.ItemClickListener;
import com.willchan.simple_random_stock.roomdatabase.entities.Stock;
import com.willchan.simple_random_stock.viewmodels.StockViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment implements ItemClickListener {
    private StockViewModel stockViewModel;
    private View view;
    private RecyclerView recyclerView;
    private Button deleteAllStocksButton;

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_history);
        deleteAllStocksButton = view.findViewById(R.id.delete_all_stocks_button);
        final HistoryListAdapter historyListAdapter = new HistoryListAdapter(getActivity());
        recyclerView.setAdapter(historyListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        try {
            stockViewModel = new StockViewModel(getActivity().getApplication());
            historyListAdapter.setStocks(stockViewModel.getAllStock());

            // Set click listeners
            historyListAdapter.setClickListener(this);
            deleteAllStocksButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (stockViewModel.getAllStock().size() > 0) {
                        stockViewModel.deleteAllStocks();
                        historyListAdapter.setStocks(null);
                    }
                }
            });
        } catch (NullPointerException e) {
            Log.e(HistoryFragment.class.toString(), e.getLocalizedMessage());
        }

        return view;
    }


    @Override
    public void onClick(View view, int position) {
        Stock stock = stockViewModel.getAllStock().get(position);
        stockViewModel.delete(stock);
    }


}
