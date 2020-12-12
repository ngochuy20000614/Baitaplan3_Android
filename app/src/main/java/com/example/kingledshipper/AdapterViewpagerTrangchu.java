package com.example.kingledshipper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class AdapterViewpagerTrangchu extends FragmentStatePagerAdapter {
    Fragment1 fragment1_116;
    Fragment2 fragment2_116;
    Fragment3 fragment3_116;
    Fragment4 fragment4_116;
    public AdapterViewpagerTrangchu(@NonNull FragmentManager fm) {
        super(fm);
        fragment1_116 = new Fragment1();
        fragment2_116 = new Fragment2();
        fragment3_116 = new Fragment3();
        fragment4_116 = new Fragment4();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return fragment1_116;
            case 1:
                return fragment2_116;
            case 2:
                return fragment3_116;
            case 3:
                return fragment4_116;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
