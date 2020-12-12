package com.example.kingledshipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CacCongTy extends AppCompatActivity {

    BottomNavigationView bottomNavigationView_116;
    RecyclerView recyclerView_116;
    ArrayList<Congty> list_116;
    DatabaseReference dataCongty_116;
    CongtyAdapter congtyAdapter_116;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cac_cong_ty);
        bottomNavigationView_116 = (BottomNavigationView)findViewById(R.id.bottomnavigation_caccongty);
        recyclerView_116 = (RecyclerView) findViewById(R.id.recycler_view_caccongty);
        recyclerView_116.setLayoutManager(new GridLayoutManager(CacCongTy.this,2));
        list_116 = new ArrayList<>();
        dataCongty_116 = FirebaseDatabase.getInstance().getReference().child("Congty");
        dataCongty_116.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Congty congty = dataSnapshot.getValue(Congty.class);
                    list_116.add(congty);
                }
                congtyAdapter_116 = new CongtyAdapter(list_116,CacCongTy.this);
                recyclerView_116.setAdapter(congtyAdapter_116);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(CacCongTy.this,"something wrong", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView_116.addOnItemTouchListener(
                new CongtyAdapter(CacCongTy.this, recyclerView_116 ,new CongtyAdapter.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        Intent intent = new Intent(CacCongTy.this,trangchu.class);
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        Toast.makeText(CacCongTy.this,"Bạn đã longClick",Toast.LENGTH_SHORT).show();
                    }
                })
        );
        EventMenuBottom();
    }
    private void EventMenuBottom() {
        bottomNavigationView_116.setSelectedItemId(R.id.congty);
        bottomNavigationView_116.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.trangchu:
                        startActivity(new Intent(getApplicationContext(),trangchu.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),Dashboard.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.congty:
                        return true;
                }
                return false;
            }
        });
    }
}