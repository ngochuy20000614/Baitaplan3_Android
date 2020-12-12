package com.example.kingledshipper;

import java.io.Serializable;

public class Sanpham implements Serializable {
    private long giasp_116;
    public String hinhanh_116;
    private boolean quyen_116;
    private String tensp_116;
    private int idsp_116;
    private int soluong_116;

    public Sanpham(){

    }

    public Sanpham(int idsp_116, long giasp_116, String hinhanh_116, boolean quyen_116, String tensp_116, int soluong_116) {
        this.giasp_116 = giasp_116;
        this.hinhanh_116 = hinhanh_116;
        this.quyen_116 = quyen_116;
        this.tensp_116 = tensp_116;
        this.idsp_116 = idsp_116;
        this.soluong_116 = soluong_116;
    }

    public int getSoluong() {
        return soluong_116;
    }

    public void setSoluong(int soluong_116) {
        this.soluong_116 = soluong_116;
    }

    public int getIdsp() {
        return idsp_116;
    }

    public void setIdsp(int idsp_116) {
        this.idsp_116 = idsp_116;
    }

    public long getGiasp() {
        return giasp_116;
    }

    public void setGiasp(long giasp_116) {
        this.giasp_116 = giasp_116;
    }

    public String getHinhanh() {
        return hinhanh_116;
    }

    public void setHinhanh(String hinhanh_116) {
        this.hinhanh_116 = hinhanh_116;
    }

    public boolean isQuyen() {
        return quyen_116;
    }

    public void setQuyen(boolean quyen_116) {
        this.quyen_116 = quyen_116;
    }

    public String getTensp() {
        return tensp_116;
    }

    public void setTensp(String tensp_116) {
        this.tensp_116 = tensp_116;
    }
}
