package com.example.fragmentviewmodel2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragmentviewmodel2022.ui.main.FragmentOne;
import com.example.fragmentviewmodel2022.ui.main.FragmentTop;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            // container one
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_one, FragmentTop.newInstance())
                    .commitNow();

            // container two
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_two, FragmentOne.newInstance())
                    .commitNow();
        }
    }
}