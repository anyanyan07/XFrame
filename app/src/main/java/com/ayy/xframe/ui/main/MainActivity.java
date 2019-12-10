package com.ayy.xframe.ui.main;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        initFragments();
        binding.navigation.setOnNavigationItemSelectedListener(this);
        setCurrentFragment(0);
    }

    private void initFragments() {
        fragmentList = new ArrayList<>();
        fragmentList.add(HomeFragment.getInstance());
        fragmentList.add(MeFragment.getInstance());
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
}
