package com.example.pro1121_duan.Model;

public class OGhep {
    public String ID;
    public String TieuDe;
    public String Image;
    public String GioiTinh;
    public Double Gia;
    public String DiaChi;
    public String MoTa;
    public String LienHe;

    public OGhep() {

    }

    public OGhep(String ID, String tieuDe, String image, String gioiTinh, Double gia, String diaChi, String moTa, String lienHe){
        this.ID = ID;
        TieuDe = tieuDe;
        this.Image = image;
        GioiTinh = gioiTinh;
        Gia = gia;
        DiaChi = diaChi;
        MoTa = moTa;
        LienHe = lienHe;
    }
}
