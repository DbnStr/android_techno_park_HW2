package ru.mail.hw1.fragment.recycler_view_fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.mail.hw1.ClickHandler;
import ru.mail.hw1.R;

public class RecyclerViewFragment extends Fragment {

    private MyAdapter adapter;
    private Integer count;
    ClickHandler clickHandler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count");
        }
        else {
            count = 100;
        }
        clickHandler = new ClickHandler(getActivity().getSupportFragmentManager());
        log("onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        log("onCreateView");
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        final RecyclerView recyclerView = view.findViewById(R.id.recycler);
        int spanCount = checkOrientation() ? 3 : 4;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), spanCount));

        adapter = new MyAdapter(count);
        recyclerView.setAdapter(adapter);

        Button button = view.findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addItem();
                ++count;
            }
        });

        return view;
    }

    public boolean checkOrientation() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }

    public void log(String message) {
      Log.d("RecyclerViewFragment", message);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        if (count != null) {
            outState.putInt("count", count);
        }
        log("onSaveInstanceState");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        log("destroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        log("onDetach");
    }

    @Override
    public void onPause() {
        super.onPause();
        log("onPause");
        onSaveInstanceState(new Bundle());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
       log("onDestroyView");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        log("onAttach");
    }
}
