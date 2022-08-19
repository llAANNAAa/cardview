package com.example.kctcardview;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.RowId;
import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<CardViewitemDTO> cardViewitemDTOS = new ArrayList<>();
    public MyRecyclerViewAdapter() {

        cardViewitemDTOS.add(new CardViewitemDTO(R.drawable.image_1,"첫번째", "풍경1"));
        cardViewitemDTOS.add(new CardViewitemDTO(R.drawable.image_2,"두번째", "풍경2"));
        cardViewitemDTOS.add(new CardViewitemDTO(R.drawable.image_3,"세번째", "풍경3"));
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item,parent,false);
        return new RowCell(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((RowCell)holder).imageView.setImageResource(cardViewitemDTOS.get(position).imageview);
        ((RowCell)holder).title.setText(cardViewitemDTOS.get(position).title);
        ((RowCell)holder).subtitle.setText(cardViewitemDTOS.get(position).subtitle);
    }

    @Override
    public int getItemCount() {
        return cardViewitemDTOS.size();
    }

    private static class RowCell extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView title;
        public TextView subtitle;

        public RowCell(View view) {
            super(view);
            imageView = (ImageView)view.findViewById(R.id.cardview_imageview);
            title = (TextView)view.findViewById(R.id.cardview_title);
            subtitle = (TextView)view.findViewById(R.id.cardview_subtilte);
        }
    }
}
