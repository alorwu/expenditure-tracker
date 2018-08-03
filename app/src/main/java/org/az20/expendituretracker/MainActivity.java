package org.az20.expendituretracker;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Toast;


import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import org.az20.expendituretracker.database.Income;
import org.az20.expendituretracker.fragments.BillsFragment;
import org.az20.expendituretracker.fragments.CategoriesFragment;
import org.az20.expendituretracker.fragments.HomeFragment;
import org.az20.expendituretracker.fragments.IncomeDialogFragment;
import org.az20.expendituretracker.fragments.SettingsFragment;
import org.az20.expendituretracker.helpers.BottomNavigationViewHelper;
import org.az20.expendituretracker.helpers.IncomeListAdapter;
import org.az20.expendituretracker.viewmodel.IncomeViewModel;

import java.util.List;

import io.reactivex.internal.operators.observable.ObservableWindow;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener, IncomeDialogFragment.DialogListener{

    private IncomeViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());

        FloatingActionButton fabIncome = findViewById(R.id.fab_action_menu_income);
        FloatingActionButton fabCategory = findViewById(R.id.fab_action_menu_category);
        FloatingActionButton fabExp = findViewById(R.id.fab_action_menu_expenses);

        fabIncome.setOnClickListener(this);
        fabCategory.setOnClickListener(this);
        fabExp.setOnClickListener(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final IncomeListAdapter adapter = new IncomeListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mViewModel = ViewModelProviders.of(this).get(IncomeViewModel.class);
        mViewModel.getAllIncome().observe(this, new Observer<List<Income>>() {
            @Override
            public void onChanged(@Nullable List<Income> incomes) {
                adapter.setIncome(incomes);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;

        switch (item.getItemId()) {
            case R.id.home:
                fragment = new HomeFragment();
                break;
            case R.id.bills:
                fragment = new BillsFragment();
                break;
            case R.id.categories:
                fragment = new CategoriesFragment();
                break;
            case R.id.settings:
                fragment = new SettingsFragment();
                break;
            default:
                fragment = new HomeFragment();
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commitAllowingStateLoss();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {

        DialogFragment mDialogFragment;

        int id = v.getId();

        switch (id)
        {
            case R.id.fab_action_menu_income:
                Toast.makeText(getApplicationContext(), "Income menu item", Toast.LENGTH_SHORT).show();
                mDialogFragment = new IncomeDialogFragment();
                showDialog(mDialogFragment, "Income dialog");
                break;
            case R.id.fab_action_menu_category:
                Toast.makeText(getApplicationContext(), "Category menu item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab_action_menu_expenses:
                Toast.makeText(getApplicationContext(), "Expenses menu item", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void showDialog(DialogFragment dialogFragment, String tag){

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null) {
            dialogFragment.show(fragmentManager, tag);
        }
    }

    @Override
    public void sendData(String title, int amount) {

        Income income = new Income(title, amount);
        mViewModel.addIncome(income);
    }
}
