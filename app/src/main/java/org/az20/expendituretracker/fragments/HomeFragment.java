package org.az20.expendituretracker.fragments;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.az20.expendituretracker.R;
import org.az20.expendituretracker.database.Income;
import org.az20.expendituretracker.helpers.IncomeListAdapter;
import org.az20.expendituretracker.viewmodel.IncomeViewModel;

import java.util.List;

public class HomeFragment extends Fragment{

    private IncomeViewModel mViewModel;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View mLayout = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = mLayout.findViewById(R.id.recyclerview);
        final IncomeListAdapter adapter = new IncomeListAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mViewModel = ViewModelProviders.of(this).get(IncomeViewModel.class);
        mViewModel.getAllIncome().observe(this, new Observer<List<Income>>() {
            @Override
            public void onChanged(@Nullable List<Income> incomes) {
                adapter.setIncome(incomes);
            }
        });

        String title = this.getArguments().getString("title");
        int amount = this.getArguments().getInt("amount");
        Income income = new Income(title, amount);
        mViewModel.addIncome(income);

        // Inflate the layout for this fragment
        return mLayout;

    }
}
