package com.example.fragmentviewmodel2022.model;

import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RepoClass {

    private final MutableLiveData<String> mLiveData = new MutableLiveData<>("init");

    @Inject
    public RepoClass() {
    }


    public MutableLiveData<String> getLiveData() {
        return mLiveData;
    }

    public void setLiveData(String value) {
        this.mLiveData.postValue(value);
    }
}
