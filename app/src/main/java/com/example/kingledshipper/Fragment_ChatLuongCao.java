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

public class Fragment_ChatLuongCao extends Fragment {
    ListView listView_116;
    ArrayList<Chitietsanpham> list_116;
    ListViewAdapter adapter_116;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view_116 = inflater.inflate(R.layout.fragment_chatluongcao,container,false);
        listView_116 = (ListView)view_116.findViewById(R.id.lv_chatluongcao);
        list_116 = new ArrayList<>();
        list_116.add(new Chitietsanpham(R.drawable.denled1));
        list_116.add(new Chitietsanpham(R.drawable.denroiray));
        list_116.add(new Chitietsanpham(R.drawable.densanvuon));
        list_116.add(new Chitietsanpham(R.drawable.densoi));
        list_116.add(new Chitietsanpham(R.drawable.denspotlight));
        list_116.add(new Chitietsanpham(R.drawable.dentuyp));
        list_116.add(new Chitietsanpham(R.drawable.phaled));
        list_116.add(new Chitietsanpham(R.drawable.ledday));
        list_116.add(new Chitietsanpham(R.drawable.denled1));
        adapter_116 = new ListViewAdapter(list_116,getContext());
        listView_116.setAdapter(adapter_116);
        return view_116;
    }
}
