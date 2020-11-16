package com.example.pro1121_duan.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pro1121_duan.Model.OGhep;
import com.example.pro1121_duan.SQLite.MySQLite;

import java.util.ArrayList;
import java.util.List;

public class OGhepDao {
    private MySQLite mySQLite;

    public OGhepDao(MySQLite mySQLite) {
        this.mySQLite = mySQLite;
    }

    public boolean insert(OGhep oGhep){
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", oGhep.ID);
        contentValues.put("TieuDe", oGhep.TieuDe);
        contentValues.put("Image", oGhep.Image);
        contentValues.put("GioiTinh", oGhep.GioiTinh);
        contentValues.put("Gia", oGhep.Gia);
        contentValues.put("DiaChi", oGhep.DiaChi);
        contentValues.put("MoTa", oGhep.MoTa);

        long kq = sqLiteDatabase.insert("OGhep", null, contentValues);
        if (kq > 0) return true;
        else return false;
    }

    public boolean update(OGhep oGhep){
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", oGhep.ID);
        contentValues.put("TieuDe", oGhep.TieuDe);
        contentValues.put("Image", oGhep.Image);
        contentValues.put("GioiTinh", oGhep.GioiTinh);
        contentValues.put("Gia", oGhep.Gia);
        contentValues.put("DiaChi", oGhep.DiaChi);
        contentValues.put("MoTa", oGhep.MoTa);

        long kq = sqLiteDatabase.update("OGhep", contentValues, "ID = ?", new String[]{oGhep.ID});
        if (kq > 0) return true;
        else return false;
    }

    public boolean delete(String id){
        long kq = mySQLite.getWritableDatabase().delete("OGhep", "ID = ?", new String[]{id});
        if (kq > 0) return true;
        else return false;
    }

    public List<OGhep> getAll(){
        List<OGhep> oGhepList = new ArrayList<>();
        String select = "SELECT * FROM OGhep";
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(select, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                OGhep oGhep = new OGhep();

                oGhep.ID = cursor.getString(cursor.getColumnIndex("ID"));
                oGhep.TieuDe = cursor.getString(cursor.getColumnIndex("TieuDe"));
                oGhep.Image = cursor.getString(cursor.getColumnIndex("Image"));
                oGhep.GioiTinh = cursor.getString(cursor.getColumnIndex("GioiTinh"));
                oGhep.Gia = cursor.getDouble(cursor.getColumnIndex("Gia"));
                oGhep.DiaChi = cursor.getString(cursor.getColumnIndex("DiaChi"));
                oGhep.MoTa = cursor.getString(cursor.getColumnIndex("MoTa"));

                oGhepList.add(oGhep);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return oGhepList;
    }

    public List<OGhep> timkiem1(String gioiTinh, String diaChi){
        List<OGhep> oGhepList = new ArrayList<>();
        String selcet = "SELECT * FROM OGhep WHERE GioiTinh LIKE '%"+gioiTinh+"%' and  DiaChi LIKE '%"+diaChi+"%' and  Gia BETWEEN 5000000 AND 1000000";
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(selcet, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                OGhep oGhep = new OGhep();

                oGhep.ID = cursor.getString(cursor.getColumnIndex("ID"));
                oGhep.TieuDe = cursor.getString(cursor.getColumnIndex("TieuDe"));
                oGhep.Image = cursor.getString(cursor.getColumnIndex("Image"));
                oGhep.GioiTinh = cursor.getString(cursor.getColumnIndex("GioiTinh"));
                oGhep.Gia = cursor.getDouble(cursor.getColumnIndex("Gia"));
                oGhep.DiaChi = cursor.getString(cursor.getColumnIndex("DiaChi"));
                oGhep.MoTa = cursor.getString(cursor.getColumnIndex("MoTa"));

                oGhepList.add(oGhep);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return oGhepList;
    }

    public List<OGhep> timkiem12(String gioiTinh, String diaChi){
        List<OGhep> oGhepList = new ArrayList<>();
        String selcet = "SELECT * FROM OGhep WHERE GioiTinh LIKE '%"+gioiTinh+"%' and  DiaChi LIKE '%"+diaChi+"%' and  Gia BETWEEN 1000000 AND 3000000";
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(selcet, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                OGhep oGhep = new OGhep();

                oGhep.ID = cursor.getString(cursor.getColumnIndex("ID"));
                oGhep.TieuDe = cursor.getString(cursor.getColumnIndex("TieuDe"));
                oGhep.Image = cursor.getString(cursor.getColumnIndex("Image"));
                oGhep.GioiTinh = cursor.getString(cursor.getColumnIndex("GioiTinh"));
                oGhep.Gia = cursor.getDouble(cursor.getColumnIndex("Gia"));
                oGhep.DiaChi = cursor.getString(cursor.getColumnIndex("DiaChi"));
                oGhep.MoTa = cursor.getString(cursor.getColumnIndex("MoTa"));

                oGhepList.add(oGhep);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return oGhepList;
    }

    public List<OGhep> timkiem13(String gioiTinh, String diaChi){
        List<OGhep> oGhepList = new ArrayList<>();
        String selcet = "SELECT * FROM OGhep WHERE GioiTinh LIKE '%"+gioiTinh+"%' and  DiaChi LIKE '%"+diaChi+"%' and  Gia BETWEEN 3000000 AND 5000000";
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(selcet, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                OGhep oGhep = new OGhep();

                oGhep.ID = cursor.getString(cursor.getColumnIndex("ID"));
                oGhep.TieuDe = cursor.getString(cursor.getColumnIndex("TieuDe"));
                oGhep.Image = cursor.getString(cursor.getColumnIndex("Image"));
                oGhep.GioiTinh = cursor.getString(cursor.getColumnIndex("GioiTinh"));
                oGhep.Gia = cursor.getDouble(cursor.getColumnIndex("Gia"));
                oGhep.DiaChi = cursor.getString(cursor.getColumnIndex("DiaChi"));
                oGhep.MoTa = cursor.getString(cursor.getColumnIndex("MoTa"));

                oGhepList.add(oGhep);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return oGhepList;
    }

    public List<OGhep> timkiem14(String gioiTinh, String diaChi){
        List<OGhep> oGhepList = new ArrayList<>();
        String selcet = "SELECT * FROM OGhep WHERE GioiTinh LIKE '%"+gioiTinh+"%' and  DiaChi LIKE '%"+diaChi+"%' and  Gia > 5000000";
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(selcet, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                OGhep oGhep = new OGhep();

                oGhep.ID = cursor.getString(cursor.getColumnIndex("ID"));
                oGhep.TieuDe = cursor.getString(cursor.getColumnIndex("TieuDe"));
                oGhep.Image = cursor.getString(cursor.getColumnIndex("Image"));
                oGhep.GioiTinh = cursor.getString(cursor.getColumnIndex("GioiTinh"));
                oGhep.Gia = cursor.getDouble(cursor.getColumnIndex("Gia"));
                oGhep.DiaChi = cursor.getString(cursor.getColumnIndex("DiaChi"));
                oGhep.MoTa = cursor.getString(cursor.getColumnIndex("MoTa"));

                oGhepList.add(oGhep);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return oGhepList;
    }
}
