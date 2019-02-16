package com.example.majdbaniodeh.yamsafertask.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.majdbaniodeh.yamsafertask.R;
import com.example.majdbaniodeh.yamsafertask.model.Rate;

import java.util.ArrayList;

public class RateAdapter extends RecyclerView.Adapter<RateAdapter.RateViewHolder> {

    Context context;
    private ArrayList<Rate> rates;

    public RateAdapter(ArrayList<Rate> rates, Context context) {
        this.rates = rates;
        this.context = context;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    @NonNull
    @Override
    public RateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RateViewHolder(LayoutInflater.from(context).inflate(R.layout.rate_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RateViewHolder rateViewHolder, int i) {
        if(i==getItemCount()-1){
            rateViewHolder.view.setVisibility(View.GONE);

        }
        rateViewHolder.priceTextView.setText("₪ " + round(rates.get(i).getBaseRate(), 1));

    }

    @Override
    public int getItemCount() {
        if (rates == null) return 0;
        else return rates.size();
    }

    public class RateViewHolder extends RecyclerView.ViewHolder {
        TextView priceTextView;
        View view;

        public RateViewHolder(@NonNull View itemView) {
            super(itemView);
            priceTextView = itemView.findViewById(R.id.textViewChildPrice);
            view=itemView.findViewById(R.id.view);
        }
    }
}
