package com.willchan.simple_random_stock.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.willchan.simple_random_stock.R;
import com.willchan.simple_random_stock.interfaces.ItemClickListener;
import com.willchan.simple_random_stock.roomdatabase.entities.Stock;

import java.util.List;

// The adapter caches data and populates the RecycleView
public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.StockViewHolder> {
    private ItemClickListener clickListener;
    private LayoutInflater inflater;
    private List<Stock> stocks; // Cached copy of stocks
    private Context context;

    public HistoryListAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    // Load the list_row_main for RecyclerView in order to set the stock name, ticker, and date
    @NonNull
    @Override
    public HistoryListAdapter.StockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_main, parent, false);
        return new StockViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final HistoryListAdapter.StockViewHolder holder, int position) {
        if (stocks != null) {
            Stock stock = stocks.get(position);
            holder.stockNameItemView.setText(stock.getName());
            holder.stockTickerItemView.setText(stock.getTicker());
            holder.stockTimeItemView.setText(stock.getDate_picked().toString());
        } else {
            // Covers the case of data not being ready yet
            holder.stockNameItemView.setText(R.string.no_stick_name_yet);
            holder.stockTickerItemView.setText(R.string.no_stock_ticker_yet);
            holder.stockTimeItemView.setText(R.string.no_stock_date_picked_yet);
        }
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
        notifyDataSetChanged();
    }

    // Called many times and when it is first called
    // stocks has not been updated (means initially it's null)
    @Override
    public int getItemCount() {
        return (stocks == null ? 0 : stocks.size());
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public void removeAt(int position) {
        stocks.remove(position);
        notifyItemRemoved(position); // tell Recycler we've removed a stock
        notifyItemRangeChanged(position, stocks.size()); // allow all views below item to adjust accordingly
    }

    // Inner class holds and manages a view for one list item
    public class StockViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView stockNameItemView, stockTickerItemView, stockTimeItemView;
        private ImageView btDelete;

        public StockViewHolder(@NonNull View itemView) {
            super(itemView);
            stockNameItemView = itemView.findViewById(R.id.stock_name_history);
            stockTickerItemView = itemView.findViewById(R.id.stock_ticker_history);
            stockTimeItemView = itemView.findViewById(R.id.stock_date_history);
            btDelete = itemView.findViewById(R.id.delete_stock_history);
            btDelete.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // checks to verify that the button delete has been clicked
            if (v.equals(btDelete) && clickListener != null) {
                int position = getAdapterPosition();
                clickListener.onClick(v, position);
                removeAt(position); // getPosition is deprecated
            }

        }
    }
}
