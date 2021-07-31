package com.example.navigationcomponenttutorial;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.widget.Button;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WelcomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView username_text_view = getView().findViewById(R.id.username_text_view);
        TextView password_text_view = getView().findViewById(R.id.password_text_view);

        username_text_view.setText(WelcomeFragmentArgs.fromBundle(getArguments()).getUsername());
        password_text_view.setText(WelcomeFragmentArgs.fromBundle(getArguments()).getPassword());

        getView().findViewById(R.id.ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                        .navigate(R.id.action_welcomeFragment_to_homeFragment);
            }
        });

    }
}