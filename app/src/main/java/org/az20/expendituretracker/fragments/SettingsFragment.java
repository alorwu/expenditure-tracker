package org.az20.expendituretracker.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.az20.expendituretracker.LoginActivity;
import org.az20.expendituretracker.R;

public class SettingsFragment extends Fragment {

    FragmentListener listener;

    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_settings, container, false);

        Button logoutBtn = mView.findViewById(R.id.logout_btn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.send(false);

            }
        });
        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (FragmentListener) context;
        }catch (ClassCastException e){
            Log.e("Attach", "ClassCastException: " + e.getMessage());
        }
    }

    public interface FragmentListener{
        void send(boolean log);
    }
}
