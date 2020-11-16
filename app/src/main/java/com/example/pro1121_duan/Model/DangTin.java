package com.example.pro1121_duan.Model;

public class DangTin {
    public String Id;
    public String TieuDe;
    public String LoaiPhong;
   // public String Image;
    public String ThanhPho;
    public String QuanHuyen;
    public String TenDiaDiem;
    public String TenDuong;
    public String SoNha;
    public Integer DienTich;
    public Integer PhongNgu;
    public Integer VeSinh;
    public Integer Gia;
    public Double KinhDo;
    public Double ViDo;
    public String MoTa;
    public String LienHe;

    public DangTin() {

    }

    public DangTin(String id, String tieuDe, String loaiPhong, String thanhPho,
                   String quanHuyen, String tenDiaDiem, String tenDuong, String soNha,
                   Integer dienTich, Integer phongNgu, Integer veSinh, Integer gia, Double kinhDo,
                   Double viDo, String moTa, String lienHe) {
        Id = id;
        TieuDe = tieuDe;
        LoaiPhong = loaiPhong;
        ThanhPho = thanhPho;
        QuanHuyen = quanHuyen;
        TenDiaDiem = tenDiaDiem;
        TenDuong = tenDuong;
        SoNha = soNha;
        DienTich = dienTich;
        PhongNgu = phongNgu;
        VeSinh = veSinh;
        Gia = gia;
        KinhDo = kinhDo;
        ViDo = viDo;
        MoTa = moTa;
        LienHe = lienHe;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTieuDe() {
        return TieuDe;
    }

    public void setTieuDe(String tieuDe) {
        TieuDe = tieuDe;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        LoaiPhong = loaiPhong;
    }

    public String getThanhPho() {
        return ThanhPho;
    }

    public void setThanhPho(String thanhPho) {
        ThanhPho = thanhPho;
    }

    public String getQuanHuyen() {
        return QuanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        QuanHuyen = quanHuyen;
    }

    public String getTenDiaDiem() {
        return TenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        TenDiaDiem = tenDiaDiem;
    }

    public String getTenDuong() {
        return TenDuong;
    }

    public void setTenDuong(String tenDuong) {
        TenDuong = tenDuong;
    }

    public String getSoNha() {
        return SoNha;
    }

    public void setSoNha(String soNha) {
        SoNha = soNha;
    }

    public Integer getDienTich() {
        return DienTich;
    }

    public void setDienTich(Integer dienTich) {
        DienTich = dienTich;
    }

    public Integer getPhongNgu() {
        return PhongNgu;
    }

    public void setPhongNgu(Integer phongNgu) {
        PhongNgu = phongNgu;
    }

    public Integer getVeSinh() {
        return VeSinh;
    }

    public void setVeSinh(Integer veSinh) {
        VeSinh = veSinh;
    }

    public Integer getGia() {
        return Gia;
    }

    public void setGia(Integer gia) {
        Gia = gia;
    }

    public Double getKinhDo() {
        return KinhDo;
    }

    public void setKinhDo(Double kinhDo) {
        KinhDo = kinhDo;
    }

    public Double getViDo() {
        return ViDo;
    }

    public void setViDo(Double viDo) {
        ViDo = viDo;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public String getLienHe() {
        return LienHe;
    }

    public void setLienHe(String lienHe) {
        LienHe = lienHe;
    }
}
