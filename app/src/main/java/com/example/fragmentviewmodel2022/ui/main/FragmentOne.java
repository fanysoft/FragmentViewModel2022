package com.example.fragmentviewmodel2022.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fragmentviewmodel2022.R;
import com.example.fragmentviewmodel2022.model.RepoClass;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FragmentOne extends Fragment {

    private MainViewModel mViewModel;
    @Inject
    RepoClass mRepoClass;

    @Inject
    public FragmentOne() {
        // Required empty public constructor
    }

    public static FragmentOne newInstance() {
        return new FragmentOne();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mViewModel.work();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(v -> {
            //mViewModel.setMutableLiveData("Moved to FragmentTwo");
            mRepoClass.setLiveData("Moved to FragmentTwo");
            // move to Fragment via navigation
            navController.navigate(R.id.action_FragmentOne_to_FragmentTwo);
        });
    }

}