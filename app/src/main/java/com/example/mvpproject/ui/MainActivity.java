package com.example.mvpproject.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.mvpproject.R;
import com.example.mvpproject.ui.base.BaseActivity;
import com.example.mvpproject.ui.cart.CartFragment;
import com.example.mvpproject.ui.home.HomeFragment;
import com.example.mvpproject.ui.mine.MineFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment[] fragments;
    private int lastFragmentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        BottomNavigationView bottomNavigationView = find(R.id.main_buttom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        fragments = new Fragment[]{
                new HomeFragment(),
                new CartFragment(),
                new MineFragment()};
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_frame, fragments[0])
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.bottom_home:
                switchFragment(0);
                break;
            case R.id.bottom_cart:
                switchFragment(1);
                break;
            case R.id.bottom_mine:
                switchFragment(2);
                break;
        }
        return false;
    }

    private void switchFragment(int to) {
        if (lastFragmentIndex == to) {
            return;
        }

        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        if (!fragments[to].isAdded()) {
            fragmentTransaction.add(R.id.main_frame, fragments[to]);
        } else {
            fragmentTransaction.show(fragments[to]);
        }
        fragmentTransaction.hide(fragments[lastFragmentIndex])
                .commitAllowingStateLoss();

        lastFragmentIndex = to;
    }
}