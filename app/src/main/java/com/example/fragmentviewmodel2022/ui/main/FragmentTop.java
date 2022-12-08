package com.example.fragmentviewmodel2022.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentviewmodel2022.R;
import com.example.fragmentviewmodel2022.databinding.FragmentTopBinding;
import com.example.fragmentviewmodel2022.model.RepoClass;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FragmentTop extends Fragment {

    private static final String TAG = FragmentTop.class.getSimpleName();
    private MainViewModel mViewModel;

    @Inject
    RepoClass mRepoClass;

    public static FragmentTop newInstance() {
        return new FragmentTop();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentTopBinding binding = FragmentTopBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.setRepoClass(mRepoClass);
        binding.setLifecycleOwner(this);

        // repo data observer
        mRepoClass.getLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(final String value) {
                Log.d(TAG, "liveData changed onChanged: " + value);
            }
        });

        return view;
    }

}