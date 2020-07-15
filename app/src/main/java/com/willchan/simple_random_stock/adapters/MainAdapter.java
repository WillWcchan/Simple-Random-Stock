package com.willchan.simple_random_stock.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.willchan.simple_random_stock.R;
import com.willchan.simple_random_stock.database.RoomDB;
import com.willchan.simple_random_stock.entities.StockEntity;

import java.util.Date;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<StockEntity> stockEntityList;
    private Activity context;
    private RoomDB database;

    public MainAdapter(Activity context, List<StockEntity> stockEntityList) {
        this.context = context;
        this.stockEntityList = stockEntityList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Initialize view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.ViewHolder holder, int position) {
        StockEntity stockEntity = stockEntityList.get(position);
        database = RoomDB.getInstance(context);
        holder.stock_name.setText(stockEntity.getName());
        holder.stock_ticker.setText(stockEntity.getTicker());
        holder.stock_time.setText(stockEntity.getDate_picked() == null ? stockEntity.getDate_picked().toString() : new Date().toString());

        holder.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StockEntity stockEntity = stockEntityList.get(holder.getAdapterPosition());
                database.stockDAO().delete(stockEntity);
                int position = holder.getAdapterPosition();
                stockEntityList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, stockEntityList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return stockEntityList.size();
    }

    // Holds all the data needed for the UI
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView stock_name, stock_ticker, stock_time;
        private ImageView btDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            stock_name = itemView.findViewById(R.id.stock_name);
//            stock_ticker = itemView.findViewById(R.id.stock_ticker);
            stock_time = itemView.findViewById(R.id.stock_time);
            btDelete = itemView.findViewById(R.id.delete_stock);
        }
    }
}
