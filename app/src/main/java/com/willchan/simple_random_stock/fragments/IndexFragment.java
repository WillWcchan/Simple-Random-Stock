package com.willchan.simple_random_stock.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

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
                Toast.makeText(this.getContext(), "Dow", Toast.LENGTH_SHORT).show();
                break;
            case R.id.card_spy500:
                Toast.makeText(this.getContext(), "SPY", Toast.LENGTH_SHORT).show();
                break;
            case R.id.card_nasdaq:
                Toast.makeText(this.getContext(), "Nasdaq", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this.getContext(), "Nothing happened", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
