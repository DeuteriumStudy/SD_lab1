package com.example.lab1;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lab1.utils.NumToText;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemHolder> {
    private final int itemCount;
    private NumToText converter;


    public ListAdapter(int itemCount) {
        this.itemCount = itemCount;

        converter = new NumToText();
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View view = inflater.inflate(R.layout.line_layout, viewGroup, false);

        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        int i = position + 1;

        holder.textView.setText(converter.convertNumber(i));

        int colorId;
        if (i % 2 == 0)
            colorId=R.color.darkTint;
        else colorId=R.color.lightTint;
        holder.linearLayout.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), colorId));
    }



    public class ItemHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final LinearLayout linearLayout;

        ItemHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            linearLayout = itemView.findViewById(R.id.line);
        }
    }
}
