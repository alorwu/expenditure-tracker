package org.az20.expendituretracker;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import org.az20.expendituretracker.fragments.BillsFragment;
import org.az20.expendituretracker.fragments.CategoriesFragment;
import org.az20.expendituretracker.fragments.CategoryDialogFragment;
import org.az20.expendituretracker.fragments.ExpensesDialogFragment;
import org.az20.expendituretracker.fragments.HomeFragment;
import org.az20.expendituretracker.fragments.IncomeDialogFragment;
import org.az20.expendituretracker.fragments.SettingsFragment;
import org.az20.expendituretracker.helpers.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    FloatingActionMenu floatingActionMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());

        floatingActionMenu = findViewById(R.id.fab_action_menu);
        FloatingActionButton fabIncome = findViewById(R.id.fab_action_menu_income);
        FloatingActionButton fabCategory = findViewById(R.id.fab_action_menu_category);
        FloatingActionButton fabExp = findViewById(R.id.fab_action_menu_expenses);

        fabIncome.setOnClickListener(this);
        fabCategory.setOnClickListener(this);
        fabExp.setOnClickListener(this);

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
        String tag;

        int id = v.getId();

        switch (id)
        {
            case R.id.fab_action_menu_income:
                mDialogFragment = new IncomeDialogFragment();
                tag = "Income dialog";
                break;
            case R.id.fab_action_menu_category:
                mDialogFragment = new CategoryDialogFragment();
                tag = "Category dialog";
                break;
            case R.id.fab_action_menu_expenses:
                mDialogFragment = new ExpensesDialogFragment();
                tag = "Category dialog";
                break;
            default:
                return;
        }

        showDialog(mDialogFragment, tag);
    }

    public void showDialog(DialogFragment dialogFragment, String tag){

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null) {
            dialogFragment.show(fragmentManager, tag);
        }
    }
}
