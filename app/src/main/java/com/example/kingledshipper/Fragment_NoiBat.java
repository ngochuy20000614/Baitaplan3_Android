package com.example.kingledshipper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Fragment_NoiBat extends Fragment {
    ListView listView_116;
    ArrayList<Chitietsanpham> list_116;
    ListViewAdapter adapter_116;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view_116 = inflater.inflate(R.layout.fragment_noibat,container,false);
        return view_116;
    }
}
