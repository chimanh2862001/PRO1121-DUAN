package com.example.pro1121_duan.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pro1121_duan.Model.NguoiDung;
import com.example.pro1121_duan.SQLite.MySQLite;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDao {
    private MySQLite mySQLite;

    public NguoiDungDao(MySQLite mySQLite) {
        this.mySQLite = mySQLite;
    }

    public boolean insert(NguoiDung nguoiDung){
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", nguoiDung.name);
        contentValues.put("Phone", nguoiDung.phone);
        contentValues.put("Pass", nguoiDung.pass);

        long kq = sqLiteDatabase.insert("NguoiDung", null, contentValues);
        if (kq > 0) return true;
        else return false;
    }

    public boolean update(NguoiDung nguoiDung){
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", nguoiDung.name);
        contentValues.put("Phone", nguoiDung.phone);
        contentValues.put("Pass", nguoiDung.pass);

        long kq = sqLiteDatabase.update("NguoiDung", contentValues, "Name = ?", new String[]{nguoiDung.name});
        if (kq > 0) return true;
        else return false;
    }

    public boolean delete(String name){
        long kq = mySQLite.getWritableDatabase().delete("NguoiDung", "Name = ?", new String[]{name});
        if (kq > 0) return true;
        else return false;
    }

    public List<NguoiDung> getAll(){
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        String select = "SELECT * FROM NguoiDung";
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(select, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                NguoiDung nguoiDung = new NguoiDung();

                nguoiDung.name = cursor.getString(cursor.getColumnIndex("Name"));
                nguoiDung.phone = cursor.getString(cursor.getColumnIndex("Phone"));
                nguoiDung.pass = cursor.getString(cursor.getColumnIndex("Pass"));

                nguoiDungList.add(nguoiDung);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return nguoiDungList;
    }
}
