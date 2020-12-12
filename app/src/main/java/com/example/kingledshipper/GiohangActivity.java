package com.example.kingledshipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.text.DecimalFormat;

public class GiohangActivity extends AppCompatActivity {

    ImageView img_arrow_116;
    ListView listView_116;
    TextView tvthongbao_116;
    static TextView tvtongtien_116;
    Button btthanhtoan_116, bttieptucmua_116;
    androidx.appcompat.widget.Toolbar giohang_116;
    GiohangAdapter adapter_116;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);
        Anhxa();
        CheckData();
        EventUltil();
        XoaSanPhamTrongGioHang();
        EventButton();
    }


    private void EventButton() {
        bttieptucmua_116.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_116 = new Intent(GiohangActivity.this,trangchu.class);
                startActivity(intent_116);
            }
        });
        btthanhtoan_116.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(trangchu.listgiohang_116.size()>0){
                    Intent intent_116 = new Intent(getApplicationContext(),TrangCaNhan.class);
                    startActivity(intent_116);
                }else{
                    Toast.makeText(getApplicationContext(),"Giỏ hàng của bạn chưa có sản phẩm để thanh toán",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void XoaSanPhamTrongGioHang() {
       listView_116.setOnItemLongClickListener(new android.widget.AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
               AlertDialog.Builder alertDialog_116 = new AlertDialog.Builder(GiohangActivity.this);
               alertDialog_116.setTitle("Xác nhận xóa sản phẩm");
               alertDialog_116.setMessage("Bạn có chắc muốn xóa sản phẩm này ?");
               alertDialog_116.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                        if(trangchu.listgiohang_116.size() <= 0){
                            tvthongbao_116.setVisibility(View.VISIBLE);
                        }else{
                            trangchu.listgiohang_116.remove(position);
                            adapter_116.notifyDataSetChanged();
                            EventUltil();
                            if(trangchu.listgiohang_116.size() <= 0){
                                tvthongbao_116.setVisibility(View.VISIBLE);
                            }
                            else{
                                tvthongbao_116.setVisibility(View.INVISIBLE);
                                adapter_116.notifyDataSetChanged();
                                EventUltil();
                            }
                        }
                   }
               });
               alertDialog_116.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       adapter_116.notifyDataSetChanged();
                       EventUltil();
                   }
               });
               alertDialog_116.show();
               return true;
           }
       });
    }


    public static void EventUltil() {
        long tongtien_116 = 0;
        for(int i = 0;i<trangchu.listgiohang_116.size();i++){
            tongtien_116 += trangchu.listgiohang_116.get(i).getGiasp();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tvtongtien_116.setText(decimalFormat.format(tongtien_116)+ ".000đ");
    }

    private void CheckData() {
        if(trangchu.listgiohang_116.size()<=0){
            adapter_116.notifyDataSetChanged();
            tvthongbao_116.setVisibility(View.VISIBLE);
            listView_116.setVisibility(View.INVISIBLE);
        }else{
            adapter_116.notifyDataSetChanged();
            tvthongbao_116.setVisibility(View.INVISIBLE);
            listView_116.setVisibility(View.VISIBLE);
        }
    }

    private void Anhxa() {
         listView_116 = (ListView)findViewById(R.id.list_view_giohang);
         tvthongbao_116 = (TextView)findViewById(R.id.tv_thongbao);
         tvtongtien_116 = (TextView)findViewById(R.id.tongtien);
         btthanhtoan_116 = (Button) findViewById(R.id.bt_thanhtoangiohang);
         bttieptucmua_116 = (Button) findViewById(R.id.bt_tieptucmuahang);
         giohang_116 = (androidx.appcompat.widget.Toolbar)findViewById(R.id.toolbar_giohang);
         adapter_116 = new GiohangAdapter(GiohangActivity.this,trangchu.listgiohang_116);
         listView_116.setAdapter(adapter_116);
    }
}