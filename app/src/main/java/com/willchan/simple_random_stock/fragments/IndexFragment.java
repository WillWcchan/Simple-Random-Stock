package com.willchan.simple_random_stock.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.willchan.simple_random_stock.MainActivity;
import com.willchan.simple_random_stock.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IndexFragment extends Fragment implements View.OnClickListener {

    private View indexView;
    private CardView dow_index, spy_index, nasdaq_index;

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

        // Set click listeners to the CardView so when they are clicked, they'll invoke the onClick method below
        dow_index.setOnClickListener(this);
        spy_index.setOnClickListener(this);
        nasdaq_index.setOnClickListener(this);

        return indexView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card_dow_jones:
                break;
            case R.id.card_spy500:
                break;
            case R.id.card_nasdaq:
                break;
            default:
                Toast.makeText(this.getContext(), "Nothing happened", Toast.LENGTH_SHORT).show();
                break;
        }

        // Imitate getting a random stock
        showDialog();

        // Change the tab to display the stock fragment
        ((MainActivity) getActivity()).selectCurrentTabToView(MainActivity.Tabs.STOCK);
    }

    void showDialog() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.random_stock_dialog, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(getContext()).setView(view).create();
        alertDialog.setCancelable(true);
        alertDialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                alertDialog.dismiss();
            }
        }, 1000);
    }

}
