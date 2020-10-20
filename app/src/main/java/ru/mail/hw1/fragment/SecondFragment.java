package ru.mail.hw1.fragment;

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

import ru.mail.hw1.R;

public class SecondFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);
        TextView number = view.findViewById(R.id.bigNumberView);
        Bundle bundle = getArguments();
        if (bundle != null) {
            number.setText(String.valueOf(bundle.getInt(getString(R.string.bundle_text))));
            number.setTextColor(bundle.getInt(getString(R.string.bundle_color)));
        }
        else log("BUNDLE IS EMPTY");

        Button button = view.findViewById(R.id.backButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log("on click BACK");
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentManager
                            .beginTransaction()
                            .replace(R.id.container, fragmentManager.findFragmentByTag("MAIN FRAGMENT"))
                            .commitAllowingStateLoss();
            }
        });

        return view;
    }

    public void log(String message) {
        Log.d("RecyclerSecondFragment", message);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        log("OnSaveInstanceState");
    }
}
