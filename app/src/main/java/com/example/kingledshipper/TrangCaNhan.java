package com.example.kingledshipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputLayout;

public class TrangCaNhan extends AppCompatActivity {

    EditText edt_tenkh_116, edt_sodt_116, edt_email_116;
    Button bt_trove_116, bt_xacnhan_116;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_ca_nhan);
        Start();
        EventButton();
    }
    private void EventButton() {
        bt_trove_116.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_116 = new Intent(TrangCaNhan.this,GiohangActivity.class);
                startActivity(intent_116);
             }
        });
        bt_xacnhan_116.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenkh_116 = edt_tenkh_116.getText().toString();
                String sodt_116 = edt_sodt_116.getText().toString();
                String email_116 = edt_email_116.getText().toString();
                if(tenkh_116.trim().equals("")||sodt_116.trim().equals("")||email_116.trim().equals("")){
                    Toast.makeText(getApplicationContext(),"Bạn chưa nhập đủ thông tin",Toast.LENGTH_SHORT).show();
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(TrangCaNhan.this);
                    builder.setIcon(R.drawable.ic_notice_24);
                    builder.setTitle("Thông báo");
                    builder.setMessage("Xác nhận để hoàn tất đơn hàng!");
                    builder.setPositiveButton("Xác nhận", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent_116 = new Intent(getApplicationContext(),trangchu.class);
                            startActivity(intent_116);
                            Toast.makeText(getApplicationContext(),"Bạn đã đặt hàng thành công!",Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                }
            }
        });
    }

    private void Start() {
        bt_trove_116 = (Button)findViewById(R.id.bt_trove);
        bt_xacnhan_116 = (Button)findViewById(R.id.bt_xacnhan);
        edt_tenkh_116 = (EditText)findViewById(R.id.edittet_khachhang);
        edt_sodt_116 = (EditText)findViewById(R.id.edittet_sodienthoai);
        edt_email_116 = (EditText)findViewById(R.id.edittet_email);
    }
}