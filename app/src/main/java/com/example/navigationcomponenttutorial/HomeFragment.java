package com.example.navigationcomponenttutorial;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.widget.Button;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = getView().findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.action_homeFragment_to_loginFragment);
            }
        });

    }
}