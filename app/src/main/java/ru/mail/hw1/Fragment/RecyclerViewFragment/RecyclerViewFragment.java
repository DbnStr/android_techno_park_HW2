package ru.mail.hw1.Fragment.RecyclerViewFragment;

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
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.mail.hw1.R;

public class RecyclerViewFragment extends Fragment {

    private MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("RecyclerViewFragment", "onCreateView");
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        final RecyclerView recyclerView = view.findViewById(R.id.recycler);
        int spanCount = checkOrientation() ? 3 : 4;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), spanCount));

        int count = savedInstanceState == null ? 100 : savedInstanceState.getInt("count");
        adapter = new MyAdapter(count, getActivity().getSupportFragmentManager());
        recyclerView.setAdapter(adapter);

        Button button = view.findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addItem();
            }
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("count", adapter.getItemCount());
        super.onSaveInstanceState(outState);
        Log.d("RecyclerViewFragment", String.valueOf(outState == null));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("RecyclerViewFragment", "destroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("RecyclerViewFragment", "onDetach");
    }

    @Override
    public void onPause() {
        super.onPause();
        onSaveInstanceState(new Bundle());
        Log.d("RecyclerViewFragment", "onPause");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("RecyclerViewFragment", "onDestroyView");
    }

    public boolean checkOrientation() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }
}
