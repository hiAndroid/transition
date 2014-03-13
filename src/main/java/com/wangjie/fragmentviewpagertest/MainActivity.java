package com.wangjie.fragmentviewpagertest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import com.wuzhong.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private ViewPager viewPager;
    public List<Fragment> fragments = new ArrayList<Fragment>();
    public String hello = "hello ";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        fragments.add(new TabAFm());
        fragments.add(new TabBFm());
        fragments.add(new TabCFm());
        fragments.add(new TabDFm());
        fragments.add(new TabEFm());

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(this.getSupportFragmentManager(), viewPager,fragments);
        adapter.setOnExtraPageChangeListener(new FragmentViewPagerAdapter.OnExtraPageChangeListener(){
            @Override
            public void onExtraPageSelected(int i) {
                System.out.println("Extra...i: " + i);
            }
        });

    }








}
