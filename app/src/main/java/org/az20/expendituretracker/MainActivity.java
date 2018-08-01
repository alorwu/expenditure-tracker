package org.az20.expendituretracker;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


import org.az20.expendituretracker.fragments.BillsFragment;
import org.az20.expendituretracker.fragments.CategoriesFragment;
import org.az20.expendituretracker.fragments.HomeFragment;
import org.az20.expendituretracker.fragments.SettingsFragment;
import org.az20.expendituretracker.helpers.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());

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

}
