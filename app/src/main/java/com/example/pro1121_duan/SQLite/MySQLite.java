package com.example.pro1121_duan.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLite extends SQLiteOpenHelper {
    public MySQLite(Context context) {
        super(context, "data.sql", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = " CREATE TABLE DangTin(ID NVARCHAR(5) PRIMARY KEY, TieuDe NVARCHAR(50),LoaiPhong NVARCHAR(50),ThanhPho NVARCHAR(20),QuanHuyen NVARCHAR(30),TenDiaDiem NVARCHAR(50),TenDuong NVARCHAR(50),SoNha NVARCHAR(50), " +
                "DienTich INTEGER, PhongNgu INTEGER, VeSinh INTEGER, Gia INTEGER, KinhDo DOUBLE, ViDo DOUBLE, MoTa NVARCHAR(225), LienHe NVARCHAR(50)) ";


        String CREATE_TABLE_OGHEP = " CREATE TABLE OGhep(ID NVARCHAR(5) PRIMARY KEY, TieuDe NVARCHAR(50), Image IMAGE, " +
                "GioiTinh NVARCHAR(10), Gia DOUBLE, DiaChi NVARCHAR(225), MoTa NVARCHAR(225), LienHe NVARCHAR(50)) ";
        String CREATE_TABLE_NGUOIDUNG = " CREATE TABLE NguoiDung(Name NVARCHAR(50) PRIMARY KEY, Phone NVARCHAR(10) NOT NULL, Pass NVARCHAR(50))";

        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE_OGHEP);
        db.execSQL(CREATE_TABLE_NGUOIDUNG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
