package com.rpsolution.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.rpsolution.R;
import com.rpsolution.fragment.ApplyLeaveFragment;
import com.rpsolution.fragment.LeaveCalFragment;
import com.rpsolution.fragment.LeaveManageFragment;
import com.rpsolution.fragment.ProfileFragment;
import com.rpsolution.utils.ConstantVal;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;
    @BindView(R.id.tvToolbar)
    protected TextView mToolbarTitle;
    @BindView(R.id.nav_view)
    protected NavigationView navigationView;
     int defaultValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);



        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        String phoneNumber = getIntent().getStringExtra(ConstantVal.PHONE);
        String userPass = getIntent().getStringExtra(ConstantVal.PASS);
        int userType = getIntent().getIntExtra(ConstantVal.USER, defaultValue);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_main, ProfileFragment.newInstance(phoneNumber, userPass, userType)).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void getValue(){

    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        String phoneNumber = getIntent().getStringExtra(ConstantVal.PHONE);
        String userPass = getIntent().getStringExtra(ConstantVal.PASS);
        int userType = getIntent().getIntExtra(ConstantVal.USER, defaultValue);
        int id = item.getItemId();
        if (id == R.id.nav_profile) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container_main, ProfileFragment.newInstance(phoneNumber, userPass, userType)).commit();

        }
        else if (id == R.id.nav_leave_summary) {
        } else if (id == R.id.nav_apply_leave) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_main, ApplyLeaveFragment.newInstance(phoneNumber, userPass, userType)).commit();
        }  else if (id == R.id.nav_manage) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new LeaveManageFragment()).commit();

        } else if (id == R.id.nav_leave) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container_main, new LeaveCalFragment()).commit();
        }

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setToolbarTitle(String title){
        mToolbarTitle.setText(title);
    }

}
