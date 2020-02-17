package com.sehrishsheikh.virtualcook.Login_Via_accountt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sehrishsheikh.virtualcook.Available_Food.AvailableFood;
import com.sehrishsheikh.virtualcook.Login_As_Guest.Home.HomeClass;
import com.sehrishsheikh.virtualcook.Login_Via_accountt.FirstFragment.ViewImageGallery;
import com.sehrishsheikh.virtualcook.Login_Via_accountt.SecondFragment.SecondFragment;
import com.sehrishsheikh.virtualcook.Login_Via_accountt.ThirdFragment.SettingClass;
import com.sehrishsheikh.virtualcook.Login_Via_accountt.W_All_Recipe_fvrt_share_Download.Fragment.FavouritesFragmen;
import com.sehrishsheikh.virtualcook.Login_Via_accountt.W_All_Recipe_fvrt_share_Download.Fragment.HomeFragment;
import com.sehrishsheikh.virtualcook.Login_Via_accountt.W_All_Recipe_fvrt_share_Download.Fragment.SettingsFragment;
import com.sehrishsheikh.virtualcook.R;

public class BNV extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chef_side_bnv);


        ActionBar actionBar = getActionBar();
        getSupportActionBar().hide();
        //OR getSupportActionBar();
//        actionBar.hide();

        getSupportActionBar().hide();

        //getActionBar().hide();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeClass()).commit();
        }


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId())
                    {
                        case R.id.nav_all_recipes:
                            selectedFragment = new HomeClass();
                            break;


                        case R.id.nav_dish_post:
                            selectedFragment = new ViewImageGallery();
                            break;

                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;

                        case R.id.nav_favorites:
                            selectedFragment = new FavouritesFragmen();
                            break;

                        case R.id.nav_search:
                            selectedFragment = new SettingsFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}