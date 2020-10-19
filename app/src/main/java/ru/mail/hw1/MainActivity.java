package ru.mail.hw1;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.mail.hw1.Fragment.RecyclerViewFragment.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportFragmentManager().findFragmentById(R.id.container) == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new RecyclerViewFragment(), "MAIN FRAGMENT")
                    .addToBackStack(null)
                    .commitAllowingStateLoss();
        }
        Log.d(getLogTag(), "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(getLogTag(), "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(getLogTag(), "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(getLogTag(), "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(getLogTag(), "onSaveInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(getLogTag(), "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(getLogTag(), "onResume");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(getLogTag(), "onRestoreInstanceState");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(getLogTag(), "onRestart");
    }

    private String getLogTag() {
        return getClass().getSimpleName() + " Lifecycle";
    }
}