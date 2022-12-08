package com.example.fragmentviewmodel2022.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fragmentviewmodel2022.model.RepoClass;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {

    @Inject
    RepoClass mRepoClass;

    @Inject
    public MainViewModel() {}

    private static final String TAG = MainViewModel.class.getSimpleName();

    public void work() {
        // foo work with RepoClass
        Log.d(TAG, "work: " + mRepoClass.getLiveData().getValue());
    };

}