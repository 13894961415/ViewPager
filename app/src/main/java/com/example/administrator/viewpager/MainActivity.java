package com.example.administrator.viewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements TabLayout.OnTabSelectedListener{
    private TabLayout tabLayout;
    private ViewPager  viewPager;
    private  List<String> datas = new ArrayList<>();
    private List<Fragment>  fragments = new ArrayList<>();
    private  MypagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        initData();
        initView();
    }

    private void initView() {
        for (int i=0; i<7;i++){
            fragments.add(new NewFragment());
        }
     tabLayout.addOnTabSelectedListener(this);
        adapter = new MypagerAdapter(getSupportFragmentManager(),datas,fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initData() {
        datas.add("最新");
        datas.add("热门");
        datas.add("关注");
        datas.add("潮搭攻略");
        datas.add("美妆心得");
        datas.add("美食美味");
        datas.add("春秋");

    }

    private void findView() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);


    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
