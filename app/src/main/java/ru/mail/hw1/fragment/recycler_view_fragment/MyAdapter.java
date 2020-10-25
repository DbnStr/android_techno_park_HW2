package ru.mail.hw1.fragment.recycler_view_fragment;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ru.mail.hw1.R;


public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<Integer> mData;
    private NumberClickListener listener;

    public MyAdapter(int count) {
        mData = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            mData.add(i);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final int id = mData.get(position);
        holder.number.setText(String.valueOf(id + 1));

        final int color = id % 2 == 0 ? Color.RED : Color.BLUE;
        holder.number.setTextColor(color);
        holder.number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onNumberClicked(id + 1, color);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public void addItem() {
        mData.add(mData.size());
        this.notifyItemInserted(mData.size() - 1);
    }

    void setOnClickListener(NumberClickListener listener) {
        this.listener = listener;
    }

    void clearClickListener() {
        this.listener = null;
    }
}