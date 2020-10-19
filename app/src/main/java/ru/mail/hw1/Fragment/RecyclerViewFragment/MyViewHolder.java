package ru.mail.hw1.Fragment.RecyclerViewFragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.mail.hw1.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public final TextView number;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        number = itemView.findViewById(R.id.number);
    }
}