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
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import ru.mail.hw1.R;

public class SecondFragment extends Fragment {

    final static String bundle_text = "text";
    final static String bundle_color = "color";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);
        TextView number = view.findViewById(R.id.bigNumberView);
        Bundle bundle = getArguments();
        if (bundle != null) {
            number.setText(String.valueOf(bundle.getInt(bundle_text)));
            number.setTextColor(bundle.getInt(bundle_color));
        } else log("BUNDLE IS EMPTY");

        Button button = view.findViewById(R.id.backButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log("on click BACK");
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    Fragment fragment = fragmentManager.findFragmentByTag("MAIN FRAGMENT");
                    if (fragment != null) {
                        fragmentManager
                                .beginTransaction()
                                .replace(R.id.container, fragment)
                                .commitAllowingStateLoss();
                    } else log("MAIN FRAGMENT IS NOT FIND");
                } else log("ACTIVITY NULL");
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
