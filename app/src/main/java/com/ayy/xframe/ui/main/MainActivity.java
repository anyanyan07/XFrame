package com.ayy.xframe.ui.main;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ayy.xframe.R;
import com.ayy.xframe.base.BaseActivity;
import com.ayy.xframe.config.Constant;
import com.ayy.xframe.databinding.ActivityMainBinding;
import com.ayy.xframe.ui.HomeFragment;
import com.ayy.xframe.ui.MeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

@Route(path = Constant.MAIN)
public class MainActivity extends BaseActivity<ActivityMainBinding> implements BottomNavigationView.OnNavigationItemSelectedListener {

    private List<Fragment> fragmentList;
    private int currentIndex = -1;
    public static final String CURRENT_INDEX = "CURRENT_INDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragments(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        binding.navigation.setOnNavigationItemSelectedListener(this);

    }

    private void initFragments(Bundle savedInstanceState) {
        fragmentList = new ArrayList<>();
        int index = 0;
        if (savedInstanceState != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment homeFragment = fragmentManager.getFragment(savedInstanceState, "0");
            if (homeFragment == null) {
                homeFragment = HomeFragment.getInstance();
            }
            Fragment meFragment = fragmentManager.getFragment(savedInstanceState, "1");
            if (meFragment == null) {
                meFragment = MeFragment.getInstance();
            }
            fragmentList.add(homeFragment);
            fragmentList.add(meFragment);
            index = savedInstanceState.getInt(CURRENT_INDEX);
        } else {
            fragmentList.add(HomeFragment.getInstance());
            fragmentList.add(MeFragment.getInstance());
        }
        setCurrentFragment(index);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.tab_home:
                setCurrentFragment(0);
                break;
            case R.id.tab_me:
                setCurrentFragment(1);
                break;
            default:
                break;
        }
        return true;
    }

    private void setCurrentFragment(int index) {
        if (currentIndex == index) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = fragmentList.get(index);
        if (!fragment.isAdded()) {
            transaction.add(R.id.frame, fragment);
        }
        transaction.show(fragment);
        if (currentIndex != -1) {
            Fragment lastFragment = fragmentList.get(currentIndex);
            if (lastFragment.isAdded()) {
                transaction.hide(lastFragment);
            }
        }
        transaction.commit();
        currentIndex = index;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        //保存fragment
        outState.putInt(CURRENT_INDEX, currentIndex);
        if (fragmentList != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            for (int i = 0; i < fragmentList.size(); i++) {
                Fragment fragment = fragmentList.get(i);
                if (fragment != null && fragment.isAdded()) {
                    fragmentManager.putFragment(outState, String.valueOf(i), fragment);
                }
            }
        }
        super.onSaveInstanceState(outState);
    }
}
