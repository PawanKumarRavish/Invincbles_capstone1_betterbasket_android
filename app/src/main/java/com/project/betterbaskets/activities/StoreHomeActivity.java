package com.project.betterbaskets.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.project.betterbaskets.R;
import com.project.betterbaskets.databinding.ActivityCustomerHomeBinding;
import com.project.betterbaskets.databinding.ActivityStoreHomeBinding;
import com.project.betterbaskets.storeFragments.ProductsFrg;
import com.project.betterbaskets.storeFragments.StoreHomeFrg;
import com.project.betterbaskets.userfragments.UserHomeFrg;
import com.project.betterbaskets.utilities.SharedPreference;
import com.project.betterbaskets.utilities.Utils;

public class StoreHomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    ActivityStoreHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStoreHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.navView.setNavigationItemSelectedListener(this);

        setUpHomeFrg();

        binding.mMenuImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                    binding.drawerLayout.closeDrawer(Gravity.LEFT);
                } else {
                    binding.drawerLayout.openDrawer(Gravity.LEFT);
                }

            }
        });
    }


    private void setUpHomeFrg() {
        Utils.doFragmentTransition(R.id.mFrameLl,new StoreHomeFrg(),getSupportFragmentManager(),true);
    }

    @Override
    public void onBackPressed() {

        int stackcount = getSupportFragmentManager().getBackStackEntryCount();
        Log.e("StackCount",stackcount+"");

        if (stackcount == 0) {
            Utils.showDialog(StoreHomeActivity.this, "Alert", "Are yu sure you want to exit the application?", new Utils.iPostiveBtnListener() {
                @Override
                public void onPositiveBtnClicked() {
                    finishAffinity();

                }
            });
        }

        if (stackcount == 1) {
            Utils.showDialog(StoreHomeActivity.this, "Alert", "Are yu sure you want to exit the application?", new Utils.iPostiveBtnListener() {
                @Override
                public void onPositiveBtnClicked() {
                    finishAffinity();

                }
            });
        }
        else{
            FragmentManager fragmentManager = getSupportFragmentManager();
            int index = fragmentManager.getBackStackEntryCount() - 1;
            String currentFragmentName=fragmentManager.getBackStackEntryAt(index).getName();
            fragmentManager.popBackStackImmediate();
        }




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.nav_home) {
            this.recreate();
        } else if (id == R.id.nav_logout) {
            SharedPreference.removeAllData();
            Intent intent = new Intent(StoreHomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finishAffinity();
        }else if (id == R.id.nav_products) {
            Utils.doFragmentTransition(R.id.mFrameLl,new ProductsFrg(),getSupportFragmentManager(),true);

        }else if (id == R.id.nav_sales) {

        }
        binding.drawerLayout.closeDrawer(Gravity.LEFT);
        return true;
    }
}