package ru.mail.hw1.fragment.recycler_view_fragment;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ru.mail.hw1.fragment.SecondFragment;
import ru.mail.hw1.R;


public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<Integer> mData;
    private FragmentManager fragmentManager;

    public MyAdapter(int count, FragmentManager fragmentManager) {
        mData = new ArrayList<>();
        this.fragmentManager = fragmentManager;

        for(int i = 0; i < count; i++) {
            mData.add(i);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Log.d("MyAdapter", "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
//        Log.d("MyAdapter", "onBindViewHolder with position: " + position);
        int id = mData.get(position);
        holder.number.setText(String.valueOf(id + 1));

        final int color = id % 2 == 0 ? Color.RED : Color.BLUE;
        holder.number.setTextColor(color);
        holder.number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("text", position + 1);
                bundle.putInt("color", color);
                SecondFragment fr = new SecondFragment();
                fr.setArguments(bundle);
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.container, fr)
                        .addToBackStack(null)
                        .commitAllowingStateLoss();
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
}