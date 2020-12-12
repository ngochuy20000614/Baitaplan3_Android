package com.example.kingledshipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Thongtinsanpham extends AppCompatActivity implements RecyclerViewBaseAdapter.ItemClickListener {

    Toolbar toolbar_116;
    ArrayList<Integer> list_spinner_116;
    ArrayAdapter arrayList_116;
    Spinner spinner_116;
    Button bt_themvao_116;
    ImageView imageView_thongtin_116;
    TextView tensp_116, gia_116;
    RecyclerView recyclerView_116;
    RecyclerViewBaseAdapter recyclerViewBaseAdapter_116;
    List<RecyclerViewBeans> list_116;

    GiohangAdapter giohangAdapter_116;
    int id_116 = 0;
    String tenchitiet_116 = "";
    long giachitiet_116;
    String hinhanhchitiet_116 = "";
    int idsp_116 = 0;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinsanpham);
        Start();
        LoadDataSpinner();
        EventButton();
        ActionToolbar();
        GetInformation();
        list_116 = new ArrayList<>();
        list_116.add(new RecyclerViewBeans(R.drawable.phaled,"Pha led"));
        list_116.add(new RecyclerViewBeans(R.drawable.densanvuon,"Đèn sân vườn"));
        list_116.add(new RecyclerViewBeans(R.drawable.densoi,"Đèn soi"));
        list_116.add(new RecyclerViewBeans(R.drawable.dentuyp,"Đèn tuyp"));
        list_116.add(new RecyclerViewBeans(R.drawable.denled1,"Đèn led"));
        list_116.add(new RecyclerViewBeans(R.drawable.denspotlight,"Đèn spotlight"));
        list_116.add(new RecyclerViewBeans(R.drawable.denroiray,"Đèn roi ray"));
        list_116.add(new RecyclerViewBeans(R.drawable.phaled,"Pha led"));
        recyclerView_116.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new
                LinearLayoutManager(Thongtinsanpham.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView_116.setLayoutManager(linearLayoutManager);
        recyclerViewBaseAdapter_116 = new RecyclerViewBaseAdapter(Thongtinsanpham.this, list_116);
        recyclerView_116.setAdapter(recyclerViewBaseAdapter_116);

        Intent intent_116 = this.getIntent();

        Sanpham sanpham_116 = (Sanpham) intent_116.getSerializableExtra("thongtinsanpham");
        hinhanhchitiet_116 = sanpham_116.getHinhanh();
        tenchitiet_116 = sanpham_116.getTensp();
        giachitiet_116 = sanpham_116.getGiasp();

    }

    private void LoadDataSpinner() {
        list_spinner_116 = new ArrayList<>();
        list_spinner_116.add(1);
        list_spinner_116.add(2);
        list_spinner_116.add(3);
        list_spinner_116.add(4);
        list_spinner_116.add(5);
        list_spinner_116.add(6);
        list_spinner_116.add(7);
        list_spinner_116.add(8);
        list_spinner_116.add(9);
        list_spinner_116.add(10);
        arrayList_116 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,list_spinner_116);
        spinner_116.setAdapter(arrayList_116);
    }
    private void GetInformation(){
        Sanpham sanpham_116 = (Sanpham)getIntent().getSerializableExtra("thongtinsanpham");
        id_116 = sanpham_116.getIdsp();
        tenchitiet_116 = sanpham_116.getTensp();
        hinhanhchitiet_116 = sanpham_116.getHinhanh();
        giachitiet_116 = sanpham_116.getGiasp();
        DecimalFormat decimalFormat_116 = new DecimalFormat("###,###,###");
        Picasso.with(getApplicationContext()).load(hinhanhchitiet_116).into(imageView_thongtin_116);
        tensp_116.setText(tenchitiet_116);
        gia_116.setText(decimalFormat_116.format(giachitiet_116)+".000đ  ");
    }
    public void EventButton(){
        bt_themvao_116.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(trangchu.listgiohang_116.size() > 0){
                    int sl_116 = Integer.parseInt(spinner_116.getSelectedItem().toString());
                    boolean exit = false;
                    for (int i = 0; i < trangchu.listgiohang_116.size();i++){
                        if(trangchu.listgiohang_116.get(i).getIdsp() == id_116){
                            trangchu.listgiohang_116.get(i).setSoluongsp(trangchu.listgiohang_116.get(i).getSoluongsp() + sl_116);
                            if(trangchu.listgiohang_116.get(i).getSoluongsp()>=10){
                               trangchu.listgiohang_116.get(i).setSoluongsp(10);
                            }
                            trangchu.listgiohang_116.get(i).setGiasp(giachitiet_116 * trangchu.listgiohang_116.get(i).getSoluongsp());
                            exit = true;
                        }
                    }
                    if(exit == false){
                        int soluong_116 = Integer.parseInt(spinner_116.getSelectedItem().toString());
                        long giamoi_116= soluong_116 * giachitiet_116;
                        boolean b = true;
                        trangchu.listgiohang_116.add(new Giohang(id_116,tenchitiet_116,giamoi_116,hinhanhchitiet_116,soluong_116));
                    }
                }else{
                    int soluong_116 = Integer.parseInt(spinner_116.getSelectedItem().toString());
                    long giamoi_116= soluong_116 * giachitiet_116;
                    boolean b_116 = true;
                    trangchu.listgiohang_116.add(new Giohang(id_116,tenchitiet_116,giamoi_116,hinhanhchitiet_116,soluong_116));
                }
                Intent intent_116 = new Intent(Thongtinsanpham.this,GiohangActivity.class);
                startActivity(intent_116);
            }
        });
    }
    public void Start(){
        recyclerView_116 = (RecyclerView)findViewById(R.id.recycler_view);
        tensp_116 = (TextView)findViewById(R.id.tv_thongtin_tensp);
        gia_116 = (TextView)findViewById(R.id.tv_thongtin_gia);
        imageView_thongtin_116 = (ImageView)findViewById(R.id.img_thongtin);
        bt_themvao_116 = (Button)findViewById(R.id.button_themvao);
        spinner_116 = (Spinner)findViewById(R.id.spinner_soluong);
        toolbar_116 = (Toolbar)findViewById(R.id.toolbar_thongtin);
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
                Intent intent = new Intent(Thongtinsanpham.this,GiohangActivity.class);
                overridePendingTransition(0,0);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    private void ActionToolbar() {
        setSupportActionBar(toolbar_116);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_116.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}