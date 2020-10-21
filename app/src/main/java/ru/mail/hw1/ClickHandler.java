package ru.mail.hw1;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import ru.mail.hw1.fragment.SecondFragment;

public class ClickHandler {
    static private FragmentManager fragmentManager;
    public ClickHandler(@NonNull FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    static public View.OnClickListener onClick(final int id,final int color) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("text", id);
                bundle.putInt("color", color);
                SecondFragment fr = new SecondFragment();
                fr.setArguments(bundle);
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.container, fr)
                        .addToBackStack(null)
                        .commitAllowingStateLoss();
            }
        };
    }
}
