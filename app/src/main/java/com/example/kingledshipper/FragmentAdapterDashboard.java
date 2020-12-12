package com.example.kingledshipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentAdapterDashboard extends FragmentStatePagerAdapter {
    String[] list_116 = {"Chất lượng cao","Giảm giá","Nổi bật"};
    Fragment_ChatLuongCao fragment_chatLuongCao_116;
    Fragment_NoiBat fragment_noiBat_116;
    Fragment_GiamGia fragment_giamGia_116;
    public FragmentAdapterDashboard(@NonNull FragmentManager fm) {
        super(fm);
        fragment_chatLuongCao_116 = new Fragment_ChatLuongCao();
        fragment_giamGia_116 = new Fragment_GiamGia();
        fragment_noiBat_116 = new Fragment_NoiBat();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return fragment_chatLuongCao_116;
            case 1:
                return fragment_giamGia_116;
            case 2:
                return fragment_noiBat_116;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return 3;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list_116[position];
    }
}
