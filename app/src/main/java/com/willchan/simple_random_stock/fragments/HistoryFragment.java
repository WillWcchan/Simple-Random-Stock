package com.willchan.simple_random_stock.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.willchan.simple_random_stock.R;
import com.willchan.simple_random_stock.adapters.MainAdapter;
import com.willchan.simple_random_stock.database.RoomDB;
import com.willchan.simple_random_stock.entities.StockEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    private RoomDB database;
    private MainAdapter adapter;
    private RecyclerView.LayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private List<StockEntity> dataList = new ArrayList<>();

    public HistoryFragment() {
        // Required empty public constructor
    }

    public void addStock(StockEntity stockEntity) {
        database.stockDAO().insert(stockEntity);
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        database = RoomDB.getInstance(getContext());
        dataList = database.stockDAO().getAll();
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MainAdapter(getActivity(), dataList);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
