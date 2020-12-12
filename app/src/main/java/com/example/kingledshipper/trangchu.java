package com.example.kingledshipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class trangchu extends AppCompatActivity implements ViewPager.OnPageChangeListener, ItemClickListener {

    BottomNavigationView bottom_116;
    DatabaseReference dataSanPham_116;
    RecyclerView recyclerView_116;
    RadioButton rb1_116, rb2_116, rb3_116, rb4_116;
    ViewPager viewPager_116;
    Toolbar toolbar_trangchu_116;
    public static ArrayList<Giohang> listgiohang_116;
    GridViewBeanAdapter gridViewBeanAdapter_116;
    public static ArrayList<Sanpham> list_116;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        Start();
        AdapterViewpagerTrangchu adapterViewpagerTrangchu = new AdapterViewpagerTrangchu(getSupportFragmentManager());
        viewPager_116.setAdapter(adapterViewpagerTrangchu);
        viewPager_116.addOnPageChangeListener(this);
        Start();
        ActionToolbar();
        LoadData();
        EventMenuBottom();
    }

    public void Start(){
        viewPager_116 = (ViewPager)findViewById(R.id.viewpager_trangchu);
        rb1_116 = (RadioButton)findViewById(R.id.rb1);
        rb2_116 = (RadioButton)findViewById(R.id.rb2);
        rb3_116 = (RadioButton)findViewById(R.id.rb3);
        rb4_116 = (RadioButton)findViewById(R.id.rb4);
        toolbar_trangchu_116 = (Toolbar)findViewById(R.id.toolbar_trangchu);
        bottom_116 = (BottomNavigationView)findViewById(R.id.bottomnavigation);
        recyclerView_116 = (RecyclerView) findViewById(R.id.recycler_view);
        if(listgiohang_116 != null){

        }else{
            listgiohang_116 = new ArrayList<>();
        }
    }

    private void EventMenuBottom() {
        bottom_116.setSelectedItemId(R.id.trangchu);
        bottom_116.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.trangchu:
                        return true;
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),Dashboard.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.congty:
                        startActivity(new Intent(getApplicationContext(),CacCongTy.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    private void LoadData() {
        recyclerView_116.setLayoutManager(new GridLayoutManager(trangchu.this,2));
        list_116 = new ArrayList<>();
        dataSanPham_116= FirebaseDatabase.getInstance().getReference().child("sanpham");
        dataSanPham_116.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Sanpham gridViewBean_116 = dataSnapshot.getValue(Sanpham.class);
                    list_116.add(gridViewBean_116);
                }
                gridViewBeanAdapter_116 = new GridViewBeanAdapter(list_116,trangchu.this);
                recyclerView_116.setAdapter(gridViewBeanAdapter_116);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(trangchu.this,"something wrong", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView_116.addOnItemTouchListener(
                new GridViewBeanAdapter(trangchu.this, recyclerView_116 ,new GridViewBeanAdapter.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent_116 = new Intent(getApplicationContext(),Thongtinsanpham.class);
                        intent_116.putExtra("thongtinsanpham",list_116.get(position));
                        startActivity(intent_116);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        Toast.makeText(trangchu.this,"Bạn đã longClick",Toast.LENGTH_SHORT).show();
                    }
                })
        );
    }
    private void ActionToolbar() {
        setSupportActionBar(toolbar_trangchu_116);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_trangchu_116.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menugiohang:
                Intent intent_116 = new Intent(trangchu.this,GiohangActivity.class);
                overridePendingTransition(0,0);
                startActivity(intent_116);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        switch (position){
            case 0:
                rb1_116.setChecked(true);break;
            case 1:
                rb2_116.setChecked(true);break;
            case 2:
                rb3_116.setChecked(true);break;
            case 3:
                rb4_116.setChecked(true);break;
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    @Override
    public void onClick(View view, int position, boolean isLongClick) {
        Toast.makeText(trangchu.this,"hell",Toast.LENGTH_SHORT).show();
    }
}