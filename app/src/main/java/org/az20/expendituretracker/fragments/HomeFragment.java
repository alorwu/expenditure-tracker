package org.az20.expendituretracker.fragments;


import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.az20.expendituretracker.R;
import org.az20.expendituretracker.database.Category;
import org.az20.expendituretracker.database.Income;
import org.az20.expendituretracker.adapters.CategoryAdapter;
import org.az20.expendituretracker.adapters.IncomeAdapter;
import org.az20.expendituretracker.viewmodels.CategoryViewModel;
import org.az20.expendituretracker.viewmodels.IncomeViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class HomeFragment extends Fragment {

    TextView incomeTotalAmount, totalAmount, expensesAmount, incomeAmount;
    IncomeAdapter incomeAdapter;
    CategoryAdapter categoryAdapter;
    RecyclerView incomeRecyclerView, categoryRecyclerView;
    private IncomeViewModel incomeViewModel;
    private CategoryViewModel categoryViewModel;

    RecyclerView.LayoutManager mLayoutManager;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        incomeAmount = view.findViewById(R.id.income_amount);
        expensesAmount = view.findViewById(R.id.expenses_amount);
        totalAmount = view.findViewById(R.id.total_amount);
        incomeTotalAmount = view.findViewById(R.id.income_total_amount);
        incomeRecyclerView = view.findViewById(R.id.income_recycler_view);
        categoryRecyclerView = view.findViewById(R.id.category_recycler_view);

        incomeViewModel = new IncomeViewModel(Objects.requireNonNull(getActivity()).getApplication());
        categoryViewModel = new CategoryViewModel(Objects.requireNonNull(getActivity().getApplication()));

        incomeAdapter = new IncomeAdapter(getContext());
        incomeViewModel.getAllIncome().observe(this, new Observer<List<Income>>() {
            @Override
            public void onChanged(@Nullable List<Income> incomes) {
                incomeAdapter.setIncomeList(incomes);
            }
        });

//        incomeAdapter.setIncomeStubList(getAllIncome());

        categoryAdapter = new CategoryAdapter(getContext());
        categoryViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(@Nullable List<Category> categories) {
                categoryAdapter.setCategories(categories);
            }
        });

//        categoryAdapter.setCategories(getAllCategories());

        mLayoutManager = new LinearLayoutManager(getContext());
        incomeRecyclerView.setLayoutManager(mLayoutManager);
        incomeRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        if(getContext() != null) {
//            incomeRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
//        }
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        categoryRecyclerView.setItemAnimator(new DefaultItemAnimator());

        incomeRecyclerView.setAdapter(incomeAdapter);
        categoryRecyclerView.setAdapter(categoryAdapter);
        return view;
    }


    private List<IncomeStub> getAllIncome() {
        List<IncomeStub> newList = new ArrayList<>();
        newList.add(new IncomeStub("Salary", "$200.00"));
        newList.add(new IncomeStub("Mobile money", "$55.00"));
        newList.add(new IncomeStub("Dad", "$90.00"));
//        newList.add(new IncomeStub("Eric reimbursement", "$20.00"));
//        newList.add(new IncomeStub("Crypto benefit", "$300.00"));
//        newList.add(new IncomeStub("Salary", "$200.00"));
//        newList.add(new IncomeStub("Mobile money", "$55.00"));
//        newList.add(new IncomeStub("Dad", "$90.00"));
//        newList.add(new IncomeStub("Eric reimbursement", "$20.00"));
//        newList.add(new IncomeStub("Crypto benefit", "$300.00"));
        return newList;
    }

    private List<CategoryStub> getAllCategories() {
        List<CategoryStub> newList = new ArrayList<>();
        newList.add(new CategoryStub("Transport", "330", "120"));
        newList.add(new CategoryStub("Food", "450", "250"));
        newList.add(new CategoryStub("Books", "150", "50"));
        newList.add(new CategoryStub("Mobile credit", "50", "43"));
        newList.add(new CategoryStub("miscellaneous", "200", "120"));
        return newList;
    }

}

