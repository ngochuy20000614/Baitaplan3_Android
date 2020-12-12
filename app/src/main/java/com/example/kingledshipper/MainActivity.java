package com.example.kingledshipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private String user_116, pass_116;
    DatabaseReference databaseReference_116;

    TextView username_116, password_116;
    Button btthemvao_116;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference_116 =  FirebaseDatabase.getInstance().getReference();
        Start();

        btthemvao_116.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference_116.child("account").child("username").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        user_116 = snapshot.getValue().toString();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                databaseReference_116.child("account").child("password").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        pass_116 = snapshot.getValue().toString();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                if (username_116.getText().toString().equals(user_116) && password_116.getText().toString().equals(pass_116)){
                    Toast.makeText(MainActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    Intent intent_116 = new Intent(MainActivity.this,trangchu.class);
                    startActivity(intent_116);
                }else{
                    Toast.makeText(MainActivity.this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void Start(){
        username_116 = (TextView)findViewById(R.id.tv_username);
        password_116 = (TextView)findViewById(R.id.tv_password);
        btthemvao_116 = (Button)findViewById(R.id.bt_dangnhap);
    }
}