package com.example.navigationcomponenttutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class LoginFragment extends Fragment {

    LoginFragmentArgs args;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Button button = getView().findViewById(R.id.confirm_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = ((EditText) getView().findViewById(R.id.username_edit_text)).getText().toString();
                String password = ((EditText) getView().findViewById(R.id.password_edit_text)).getText().toString();
                LoginFragmentDirections.ActionLoginFragmentToWelcomeFragment action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(username, password);
//                action.setUsername(username);
//                action.setPassword(password);

                Navigation.findNavController(getActivity(), R.id.nav_host_fragment)
                        .navigate(action);
            }
        });

        EditText username = getView().findViewById(R.id.username_edit_text);
        if (args != null)
            username.setText(args.getUsername());

    }
}