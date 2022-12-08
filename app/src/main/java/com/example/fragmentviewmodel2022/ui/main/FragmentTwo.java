package com.example.fragmentviewmodel2022.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.fragmentviewmodel2022.R;
import com.example.fragmentviewmodel2022.databinding.FragmentTopBinding;
import com.example.fragmentviewmodel2022.model.RepoClass;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FragmentTwo extends Fragment {

    private MainViewModel mViewModel;
    @Inject
    RepoClass mRepoClass;

    @Inject
    public FragmentTwo() {
        // Required empty public constructor
    }

    public static FragmentTwo newInstance() {
        return new FragmentTwo();
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
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(v -> {
            //mViewModel.setMutableLiveData("Moved to FragmentOne");
            mRepoClass.setLiveData("Moved to FragmentOne");
            // move to Fragment via navigation
            navController.navigate(R.id.action_FragmentTwo_to_FragmentOne);
        });
    }
}