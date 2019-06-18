package com.example.twtprojectpart2;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager view_pager;
    TabLayout tab_layout;
    ViewPagerAdapter viewPagerAdapter;
    LinearLayout linear_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view_pager = (ViewPager)findViewById(R.id.viewPager);
        tab_layout = (TabLayout)findViewById(R.id.tabLayout);

        setupViewPager(view_pager);
        tab_layout.setupWithViewPager(view_pager);

        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // The first tab is the default tab, and therefore it is already displayed, and when you
                // click the second tab then only this method is called
                // in this case, it executes for the first time when Tab Two is clicked

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    // method to set up the viewPager so that the addFragment method can be used to add the fragments
    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FirstFragment(), "TAB ONE");
        viewPagerAdapter.addFragment(new SecondFragment(), "TAB TWO");
        viewPager.setAdapter(viewPagerAdapter);
    }
}
