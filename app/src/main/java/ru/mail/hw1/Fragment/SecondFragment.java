package ru.mail.hw1.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.mail.hw1.Fragment.RecyclerViewFragment.RecyclerViewFragment;
import ru.mail.hw1.R;

public class SecondFragment extends Fragment {

    private TextView number;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);
        number = view.findViewById(R.id.bigNumberView);
        Bundle bundle = getArguments();
        number.setText(String.valueOf(bundle.getInt("text")));
        number.setTextColor(bundle.getInt("color"));

        Button button = view.findViewById(R.id.backButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BACK", "on click BACK");
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.container, fragmentManager.findFragmentByTag("MAIN FRAGMENT"))
                        .commitAllowingStateLoss();
            }
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("RecyclerSecondFragment", "OnSaveInstanceState");
    }
}
