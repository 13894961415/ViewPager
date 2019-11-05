package com.example.administrator.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/11/4.
 */

public class MypagerAdapter  extends FragmentPagerAdapter {
    List<String> list;
    List<Fragment> fragments = new ArrayList<>();


    public MypagerAdapter (FragmentManager fm, List<String> list, List<Fragment>frag){
        super(fm);
        this.list = list;
        this.fragments = frag;
    }


    public  Fragment getItem(int postion)
    {return  fragments.get(postion);}
    public  CharSequence getPageTitle (int postion )
    {return list.get(postion);}
    @Override
    public int getCount() {
        return fragments !=null ? fragments.size() :0;
    }
}
