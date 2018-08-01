package org.az20.expendituretracker.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import org.az20.expendituretracker.R;

public class HomeFragment extends Fragment implements View.OnClickListener{

    FloatingActionButton fabIncome, fabCategory, fabExp;
    View view;


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = getLayoutInflater().inflate(R.layout.fab_menu, null);
        fabIncome = view.findViewById(R.id.fab_action_menu_income);
        fabCategory = view.findViewById(R.id.fab_action_menu_category);
        fabExp = view.findViewById(R.id.fab_action_menu_expenses);

        fabIncome.setOnClickListener(this);
        fabCategory.setOnClickListener(this);
        fabExp.setOnClickListener(this);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onClick(View v) {

        DialogFragment mDialogFragment;

        int id = v.getId();

        switch (id)
        {
            case R.id.fab_action_menu_income:

                mDialogFragment = new IncomeDialogFragment();
                Toast.makeText(getActivity(), "Income menu item", Toast.LENGTH_LONG).show();
                showDialog(mDialogFragment);
                break;
            case R.id.fab_action_menu_category:
                Toast.makeText(getActivity(), "Category menu item", Toast.LENGTH_LONG).show();
                break;
            case R.id.fab_action_menu_expenses:
                Toast.makeText(getActivity(), "Expenses menu item", Toast.LENGTH_LONG).show();
                break;
        }
    }

    public void showDialog(DialogFragment dialogFragment){

        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            dialogFragment.show(fragmentManager, "dialog_fragment");
        }
    }
}
