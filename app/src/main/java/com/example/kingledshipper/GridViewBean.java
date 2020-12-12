package com.example.kingledshipper;

import android.widget.GridView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GridViewBean{
    private String hinhanh_116;
    private String tensp_116;
    private long giasp_116;
    private boolean quyen_116;

    public GridViewBean(String hinhanh_116, String tensp_116, long giasp_116, boolean quyen_116) {
        this.hinhanh_116 = hinhanh_116;
        this.tensp_116 = tensp_116;
        this.giasp_116 = giasp_116;
        this.quyen_116 = quyen_116;
    }

    public String getHinhanh_116() {
        return hinhanh_116;
    }

    public void setHinhanh_116(String hinhanh_116) {
        this.hinhanh_116 = hinhanh_116;
    }

    public String getTensp_116() {
        return tensp_116;
    }

    public void setTensp_116(String tensp_116) {
        this.tensp_116 = tensp_116;
    }

    public long getGiasp_116() {
        return giasp_116;
    }

    public void setGiasp_116(long giasp_116) {
        this.giasp_116 = giasp_116;
    }

    public boolean isQuyen_116() {
        return quyen_116;
    }

    public void setQuyen_116(boolean quyen_116) {
        this.quyen_116 = quyen_116;
    }
}
