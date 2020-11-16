package com.example.pro1121_duan.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pro1121_duan.Model.DangTin;
import com.example.pro1121_duan.SQLite.MySQLite;

import java.util.ArrayList;
import java.util.List;

public class DangTinDao {
    private MySQLite mySQLite;

    public DangTinDao(MySQLite mySQLite) {
        this.mySQLite = mySQLite;
    }

    public boolean insert(DangTin dangTin){
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", dangTin.Id);
        contentValues.put("TieuDe", dangTin.TieuDe);
        contentValues.put("LoaiPhong", dangTin.LoaiPhong);
       // contentValues.put("Image", dangTin.Image);
        contentValues.put("ThanhPho", dangTin.ThanhPho);
        contentValues.put("QuanHuyen", dangTin.QuanHuyen);
        contentValues.put("TenDiaDiem", dangTin.TenDiaDiem);
        contentValues.put("TenDuong", dangTin.TenDuong);
        contentValues.put("SoNha", dangTin.SoNha);

        contentValues.put("DienTich", dangTin.DienTich);
        contentValues.put("PhongNgu", dangTin.PhongNgu);
        contentValues.put("VeSinh", dangTin.VeSinh);
        contentValues.put("Gia", dangTin.Gia);

        contentValues.put("KinhDo", dangTin.KinhDo);
        contentValues.put("ViDo", dangTin.ViDo);
        contentValues.put("MoTa", dangTin.MoTa);
        contentValues.put("LienHe", dangTin.LienHe);

        long kq = sqLiteDatabase.insert("DangTin", null, contentValues);
        if (kq > 0) return true;
        else return false;
    }

    public boolean update(DangTin dangTin){
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", dangTin.Id);
        contentValues.put("TieuDe", dangTin.TieuDe);
        contentValues.put("LoaiPhong", dangTin.LoaiPhong);
        // contentValues.put("Image", dangTin.Image);
        contentValues.put("ThanhPho", dangTin.ThanhPho);
        contentValues.put("QuanHuyen", dangTin.QuanHuyen);
        contentValues.put("TenDiaDiem", dangTin.TenDiaDiem);
        contentValues.put("TenDuong", dangTin.TenDuong);
        contentValues.put("SoNha", dangTin.SoNha);

        contentValues.put("DienTich", dangTin.DienTich);
        contentValues.put("PhongNgu", dangTin.PhongNgu);
        contentValues.put("VeSinh", dangTin.VeSinh);
        contentValues.put("Gia", dangTin.Gia);

        contentValues.put("KinhDo", dangTin.KinhDo);
        contentValues.put("ViDo", dangTin.ViDo);
        contentValues.put("MoTa", dangTin.MoTa);
        contentValues.put("LienHe", dangTin.LienHe);

        long kq = sqLiteDatabase.update("DangTin", contentValues, "ID = ?", new String[]{dangTin.Id});
        if (kq > 0) return true;
        else return false;
    }

    public boolean delete(String id){
        long kq = mySQLite.getWritableDatabase().delete("DangTin", "ID = ?", new String[]{id});
        if (kq > 0) return true;
        else return false;
    }

    public List<DangTin> getAll(){
        List<DangTin> dangTinList = new ArrayList<>();
        String select = "SELECT * FROM DangTin";
        Cursor cursor = mySQLite.getWritableDatabase().rawQuery(select, null);

        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                DangTin dangTin = new DangTin();

                dangTin.Id = cursor.getString(cursor.getColumnIndex("ID"));
                dangTin.TieuDe = cursor.getString(cursor.getColumnIndex("TieuDe"));
                dangTin.LoaiPhong = cursor.getString(cursor.getColumnIndex("LoaiPhong"));
                dangTin.ThanhPho = cursor.getString(cursor.getColumnIndex("ThanhPho"));
                dangTin.QuanHuyen = cursor.getString(cursor.getColumnIndex("QuanHuyen"));
                dangTin.TenDiaDiem = cursor.getString(cursor.getColumnIndex("TenDiaDiem"));
                dangTin.TenDuong = cursor.getString(cursor.getColumnIndex("TenDuong"));
                dangTin.SoNha = cursor.getString(cursor.getColumnIndex("SoNha"));


                dangTin.DienTich = cursor.getInt(cursor.getColumnIndex("DienTich"));
                dangTin.PhongNgu = cursor.getInt(cursor.getColumnIndex("PhongNgu"));
                dangTin.VeSinh = cursor.getInt(cursor.getColumnIndex("VeSinh"));
                dangTin.Gia = cursor.getInt(cursor.getColumnIndex("Gia"));

                dangTin.KinhDo = cursor.getDouble(cursor.getColumnIndex("KinhDo"));
                dangTin.ViDo = cursor.getDouble(cursor.getColumnIndex("ViDo"));
                dangTin.MoTa = cursor.getString(cursor.getColumnIndex("MoTa"));
                dangTin.LienHe = cursor.getString(cursor.getColumnIndex("LienHe"));

                dangTinList.add(dangTin);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return dangTinList;
    }
    public List<DangTin> timKiem(String  tim){
        List<DangTin> dangTinList=new ArrayList<>();
        String gell="Select*from DangTin where TieuDe like '%"+tim+"%' or QuanHuyen like'%"+tim+"%' or ThanhPho like'%"+tim+"%' ";
        Cursor cursor=mySQLite.getReadableDatabase().rawQuery(gell,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                DangTin dangTin=new DangTin();

                dangTin.Id = cursor.getString(cursor.getColumnIndex("ID"));
                dangTin.TieuDe = cursor.getString(cursor.getColumnIndex("TieuDe"));
                dangTin.LoaiPhong = cursor.getString(cursor.getColumnIndex("LoaiPhong"));
                dangTin.ThanhPho = cursor.getString(cursor.getColumnIndex("ThanhPho"));
                dangTin.QuanHuyen = cursor.getString(cursor.getColumnIndex("QuanHuyen"));
                dangTin.TenDiaDiem = cursor.getString(cursor.getColumnIndex("TenDiaDiem"));
                dangTin.TenDuong = cursor.getString(cursor.getColumnIndex("TenDuong"));
                dangTin.SoNha = cursor.getString(cursor.getColumnIndex("SoNha"));


                dangTin.DienTich = cursor.getInt(cursor.getColumnIndex("DienTich"));
                dangTin.PhongNgu = cursor.getInt(cursor.getColumnIndex("PhongNgu"));
                dangTin.VeSinh = cursor.getInt(cursor.getColumnIndex("VeSinh"));
                dangTin.Gia = cursor.getInt(cursor.getColumnIndex("Gia"));

                dangTin.KinhDo = cursor.getDouble(cursor.getColumnIndex("KinhDo"));
                dangTin.ViDo = cursor.getDouble(cursor.getColumnIndex("ViDo"));
                dangTin.MoTa = cursor.getString(cursor.getColumnIndex("MoTa"));
                dangTin.LienHe = cursor.getString(cursor.getColumnIndex("LienHe"));

                dangTinList.add(dangTin);
                cursor.moveToNext();

            }
            cursor.close();
        }
        return dangTinList;
    }

   public List<DangTin> timchitiet11(String loaiphong,String khuvuc){
        List<DangTin> dangTinList=new ArrayList<>();
       String gell="Select*from DangTin where LoaiPhong like '%"+loaiphong+"%' and QuanHuyen like'%"+khuvuc+"%' and Gia <1500000 and DienTich between 20 and 30";
       Cursor cursor=mySQLite.getReadableDatabase().rawQuery(gell,null);
       if (cursor.getCount()>0){
           cursor.moveToFirst();
           while (!cursor.isAfterLast()){
               DangTin dangTin=new DangTin();

               dangTin.Id = cursor.getString(cursor.getColumnIndex("ID"));
               dangTin.TieuDe = cursor.getString(cursor.getColumnIndex("TieuDe"));
               dangTin.LoaiPhong = cursor.getString(cursor.getColumnIndex("LoaiPhong"));
               dangTin.ThanhPho = cursor.getString(cursor.getColumnIndex("ThanhPho"));
               dangTin.QuanHuyen = cursor.getString(cursor.getColumnIndex("QuanHuyen"));
               dangTin.TenDiaDiem = cursor.getString(cursor.getColumnIndex("TenDiaDiem"));
               dangTin.TenDuong = cursor.getString(cursor.getColumnIndex("TenDuong"));
               dangTin.SoNha = cursor.getString(cursor.getColumnIndex("SoNha"));


               dangTin.DienTich = cursor.getInt(cursor.getColumnIndex("DienTich"));
               dangTin.PhongNgu = cursor.getInt(cursor.getColumnIndex("PhongNgu"));
               dangTin.VeSinh = cursor.getInt(cursor.getColumnIndex("VeSinh"));
               dangTin.Gia = cursor.getInt(cursor.getColumnIndex("Gia"));

               dangTin.KinhDo = cursor.getDouble(cursor.getColumnIndex("KinhDo"));
               dangTin.ViDo = cursor.getDouble(cursor.getColumnIndex("ViDo"));
               dangTin.MoTa = cursor.getString(cursor.getColumnIndex("MoTa"));
               dangTin.LienHe = cursor.getString(cursor.getColumnIndex("LienHe"));

               dangTinList.add(dangTin);
               cursor.moveToNext();

           }
           cursor.close();
       }
        return  dangTinList;
   }

   public List<DangTin> timchitiet12(String loaiphong,String khuvuc){
       List<DangTin> dangTinList=new ArrayList<>();
       String gell="Select*from DangTin where LoaiPhong like '%"+loaiphong+"%' and QuanHuyen like'%"+khuvuc+"%' and Gia <1500000 and DienTich between 30 and 50";
       Cursor cursor=mySQLite.getReadableDatabase().rawQuery(gell,null);
       if (cursor.getCount()>0){
           cursor.moveToFirst();
           while (!cursor.isAfterLast()){
               DangTin dangTin=new DangTin();

               dangTin.Id = cursor.getString(cursor.getColumnIndex("ID"));
               dangTin.TieuDe = cursor.getString(cursor.getColumnIndex("TieuDe"));
               dangTin.LoaiPhong = cursor.getString(cursor.getColumnIndex("LoaiPhong"));
               dangTin.ThanhPho = cursor.getString(cursor.getColumnIndex("ThanhPho"));
               dangTin.QuanHuyen = cursor.getString(cursor.getColumnIndex("QuanHuyen"));
               dangTin.TenDiaDiem = cursor.getString(cursor.getColumnIndex("TenDiaDiem"));
               dangTin.TenDuong = cursor.getString(cursor.getColumnIndex("TenDuong"));
               dangTin.SoNha = cursor.getString(cursor.getColumnIndex("SoNha"));


               dangTin.DienTich = cursor.getInt(cursor.getColumnIndex("DienTich"));
               dangTin.PhongNgu = cursor.getInt(cursor.getColumnIndex("PhongNgu"));
               dangTin.VeSinh = cursor.getInt(cursor.getColumnIndex("VeSinh"));
               dangTin.Gia = cursor.getInt(cursor.getColumnIndex("Gia"));

               dangTin.KinhDo = cursor.getDouble(cursor.getColumnIndex("KinhDo"));
               dangTin.ViDo = cursor.getDouble(cursor.getColumnIndex("ViDo"));
               dangTin.MoTa = cursor.getString(cursor.getColumnIndex("MoTa"));
               dangTin.LienHe = cursor.getString(cursor.getColumnIndex("LienHe"));

               dangTinList.add(dangTin);
               cursor.moveToNext();

           }
           cursor.close();
       }
       return  dangTinList;

   }

   public List<DangTin> timchitiet13(String loaiphong,String khuvuc){
       List<DangTin> dangTinList=new ArrayList<>();
       String gell="Select*from DangTin where LoaiPhong like '%"+loaiphong+"%' and QuanHuyen like'%"+khuvuc+"%' and Gia <1500000 and DienTich >50";
       Cursor cursor=mySQLite.getReadableDatabase().rawQuery(gell,null);
       if (cursor.getCount()>0){
           cursor.moveToFirst();
           while (!cursor.isAfterLast()){
               DangTin dangTin=new DangTin();

               dangTin.Id = cursor.getString(cursor.getColumnIndex("ID"));
               dangTin.TieuDe = cursor.getString(cursor.getColumnIndex("TieuDe"));
               dangTin.LoaiPhong = cursor.getString(cursor.getColumnIndex("LoaiPhong"));
               dangTin.ThanhPho = cursor.getString(cursor.getColumnIndex("ThanhPho"));
               dangTin.QuanHuyen = cursor.getString(cursor.getColumnIndex("QuanHuyen"));
               dangTin.TenDiaDiem = cursor.getString(cursor.getColumnIndex("TenDiaDiem"));
               dangTin.TenDuong = cursor.getString(cursor.getColumnIndex("TenDuong"));
               dangTin.SoNha = cursor.getString(cursor.getColumnIndex("SoNha"));


               dangTin.DienTich = cursor.getInt(cursor.getColumnIndex("DienTich"));
               dangTin.PhongNgu = cursor.getInt(cursor.getColumnIndex("PhongNgu"));
               dangTin.VeSinh = cursor.getInt(cursor.getColumnIndex("VeSinh"));
               dangTin.Gia = cursor.getInt(cursor.getColumnIndex("Gia"));

               dangTin.KinhDo = cursor.getDouble(cursor.getColumnIndex("KinhDo"));
               dangTin.ViDo = cursor.getDouble(cursor.getColumnIndex("ViDo"));
               dangTin.MoTa = cursor.getString(cursor.getColumnIndex("MoTa"));
               dangTin.LienHe = cursor.getString(cursor.getColumnIndex("LienHe"));

               dangTinList.add(dangTin);
               cursor.moveToNext();

           }
           cursor.close();
       }
       return  dangTinList;
   }

   public List<DangTin> timchitiet21(String loaiphong,String khuvuc){

       List<DangTin> dangTinList=new ArrayList<>();
       String gell="Select*from DangTin where LoaiPhong like '%"+loaiphong+"%' and QuanHuyen like'%"+khuvuc+"%' and Gia between 1500000 and 3000000 and DienTich between 20 and 30";
       Cursor cursor=mySQLite.getReadableDatabase().rawQuery(gell,null);
       if (cursor.getCount()>0){
           cursor.moveToFirst();
           while (!cursor.isAfterLast()){
               DangTin dangTin=new DangTin();

               dangTin.Id = cursor.getString(cursor.getColumnIndex("ID"));
               dangTin.TieuDe = cursor.getString(cursor.getColumnIndex("TieuDe"));
               dangTin.LoaiPhong = cursor.getString(cursor.getColumnIndex("LoaiPhong"));
               dangTin.ThanhPho = cursor.getString(cursor.getColumnIndex("ThanhPho"));
               dangTin.QuanHuyen = cursor.getString(cursor.getColumnIndex("QuanHuyen"));
               dangTin.TenDiaDiem = cursor.getString(cursor.getColumnIndex("TenDiaDiem"));
               dangTin.TenDuong = cursor.getString(cursor.getColumnIndex("TenDuong"));
               dangTin.SoNha = cursor.getString(cursor.getColumnIndex("SoNha"));


               dangTin.DienTich = cursor.getInt(cursor.getColumnIndex("DienTich"));
               dangTin.PhongNgu = cursor.getInt(cursor.getColumnIndex("PhongNgu"));
               dangTin.VeSinh = cursor.getInt(cursor.getColumnIndex("VeSinh"));
               dangTin.Gia = cursor.getInt(cursor.getColumnIndex("Gia"));

               dangTin.KinhDo = cursor.getDouble(cursor.getColumnIndex("KinhDo"));
               dangTin.ViDo = cursor.getDouble(cursor.getColumnIndex("ViDo"));
               dangTin.MoTa = cursor.getString(cursor.getColumnIndex("MoTa"));
               dangTin.LienHe = cursor.getString(cursor.getColumnIndex("LienHe"));

               dangTinList.add(dangTin);
               cursor.moveToNext();

           }
           cursor.close();
       }
       return  dangTinList;
   }

   public List<DangTin> timchitiet22(String loaiphong,String khuvuc){

       List<DangTin> dangTinList=new ArrayList<>();
       String gell="Select*from DangTin where LoaiPhong like '%"+loaiphong+"%' and QuanHuyen like'%"+khuvuc+"%' and Gia between 1500000 and 3000000 and DienTich between 30 and 50";
       Cursor cursor=mySQLite.getReadableDatabase().rawQuery(gell,null);
       if (cursor.getCount()>0){
           cursor.moveToFirst();
           while (!cursor.isAfterLast()){
               DangTin dangTin=new DangTin();

               dangTin.Id = cursor.getString(cursor.getColumnIndex("ID"));
               dangTin.TieuDe = cursor.getString(cursor.getColumnIndex("TieuDe"));
               dangTin.LoaiPhong = cursor.getString(cursor.getColumnIndex("LoaiPhong"));
               dangTin.ThanhPho = cursor.getString(cursor.getColumnIndex("ThanhPho"));
               dangTin.QuanHuyen = cursor.getString(cursor.getColumnIndex("QuanHuyen"));
               dangTin.TenDiaDiem = cursor.getString(cursor.getColumnIndex("TenDiaDiem"));
               dangTin.TenDuong = cursor.getString(cursor.getColumnIndex("TenDuong"));
               dangTin.SoNha = cursor.getString(cursor.getColumnIndex("SoNha"));


               dangTin.DienTich = cursor.getInt(cursor.getColumnIndex("DienTich"));
               dangTin.PhongNgu = cursor.getInt(cursor.getColumnIndex("PhongNgu"));
               dangTin.VeSinh = cursor.getInt(cursor.getColumnIndex("VeSinh"));
               dangTin.Gia = cursor.getInt(cursor.getColumnIndex("Gia"));

               dangTin.KinhDo = cursor.getDouble(cursor.getColumnIndex("KinhDo"));
               dangTin.ViDo = cursor.getDouble(cursor.getColumnIndex("ViDo"));
               dangTin.MoTa = cursor.getString(cursor.getColumnIndex("MoTa"));
               dangTin.LienHe = cursor.getString(cursor.getColumnIndex("LienHe"));

               dangTinList.add(dangTin);
               cursor.moveToNext();

           }
           cursor.close();
       }
       return  dangTinList;
   }

   public List<DangTin> timchitiet23(String loaiphong,String khuvuc){
       List<DangTin> dangTinList=new ArrayList<>();
       String gell="Select*from DangTin where LoaiPhong like '%"+loaiphong+"%' and QuanHuyen like'%"+khuvuc+"%' and Gia between 1500000 and 3000000 and DienTich >50";
       Cursor cursor=mySQLite.getReadableDatabase().rawQuery(gell,null);
       if (cursor.getCount()>0){
           cursor.moveToFirst();
           while (!cursor.isAfterLast()){
               DangTin dangTin=new DangTin();

               dangTin.Id = cursor.getString(cursor.getColumnIndex("ID"));
               dangTin.TieuDe = cursor.getString(cursor.getColumnIndex("TieuDe"));
               dangTin.LoaiPhong = cursor.getString(cursor.getColumnIndex("LoaiPhong"));
               dangTin.ThanhPho = cursor.getString(cursor.getColumnIndex("ThanhPho"));
               dangTin.QuanHuyen = cursor.getString(cursor.getColumnIndex("QuanHuyen"));
               dangTin.TenDiaDiem = cursor.getString(cursor.getColumnIndex("TenDiaDiem"));
               dangTin.TenDuong = cursor.getString(cursor.getColumnIndex("TenDuong"));
               dangTin.SoNha = cursor.getString(cursor.getColumnIndex("SoNha"));


               dangTin.DienTich = cursor.getInt(cursor.getColumnIndex("DienTich"));
               dangTin.PhongNgu = cursor.getInt(cursor.getColumnIndex("PhongNgu"));
               dangTin.VeSinh = cursor.getInt(cursor.getColumnIndex("VeSinh"));
               dangTin.Gia = cursor.getInt(cursor.getColumnIndex("Gia"));

               dangTin.KinhDo = cursor.getDouble(cursor.getColumnIndex("KinhDo"));
               dangTin.ViDo = cursor.getDouble(cursor.getColumnIndex("ViDo"));
               dangTin.MoTa = cursor.getString(cursor.getColumnIndex("MoTa"));
               dangTin.LienHe = cursor.getString(cursor.getColumnIndex("LienHe"));

               dangTinList.add(dangTin);
               cursor.moveToNext();

           }
           cursor.close();
       }
       return  dangTinList;
   }
   public List<DangTin> timkiem31(String loaiphong,String khuvuc){
       List<DangTin> dangTinList=new ArrayList<>();
       String gell="Select*from DangTin where LoaiPhong like '%"+loaiphong+"%' and QuanHuyen like'%"+khuvuc+"%' and Gia >3000000 and DienTich between 20 and 30";
       Cursor cursor=mySQLite.getReadableDatabase().rawQuery(gell,null);
       if (cursor.getCount()>0){
           cursor.moveToFirst();
           while (!cursor.isAfterLast()){
               DangTin dangTin=new DangTin();

               dangTin.Id = cursor.getString(cursor.getColumnIndex("ID"));
               dangTin.TieuDe = cursor.getString(cursor.getColumnIndex("TieuDe"));
               dangTin.LoaiPhong = cursor.getString(cursor.getColumnIndex("LoaiPhong"));
               dangTin.ThanhPho = cursor.getString(cursor.getColumnIndex("ThanhPho"));
               dangTin.QuanHuyen = cursor.getString(cursor.getColumnIndex("QuanHuyen"));
               dangTin.TenDiaDiem = cursor.getString(cursor.getColumnIndex("TenDiaDiem"));
               dangTin.TenDuong = cursor.getString(cursor.getColumnIndex("TenDuong"));
               dangTin.SoNha = cursor.getString(cursor.getColumnIndex("SoNha"));


               dangTin.DienTich = cursor.getInt(cursor.getColumnIndex("DienTich"));
               dangTin.PhongNgu = cursor.getInt(cursor.getColumnIndex("PhongNgu"));
               dangTin.VeSinh = cursor.getInt(cursor.getColumnIndex("VeSinh"));
               dangTin.Gia = cursor.getInt(cursor.getColumnIndex("Gia"));

               dangTin.KinhDo = cursor.getDouble(cursor.getColumnIndex("KinhDo"));
               dangTin.ViDo = cursor.getDouble(cursor.getColumnIndex("ViDo"));
               dangTin.MoTa = cursor.getString(cursor.getColumnIndex("MoTa"));
               dangTin.LienHe = cursor.getString(cursor.getColumnIndex("LienHe"));

               dangTinList.add(dangTin);
               cursor.moveToNext();

           }
           cursor.close();
       }
       return  dangTinList;
   }

    public List<DangTin> timkiem32(String loaiphong,String khuvuc){
        List<DangTin> dangTinList=new ArrayList<>();
        String gell="Select*from DangTin where LoaiPhong like '%"+loaiphong+"%' and QuanHuyen like'%"+khuvuc+"%' and Gia >3000000 and DienTich between 30 and 50";
        Cursor cursor=mySQLite.getReadableDatabase().rawQuery(gell,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                DangTin dangTin=new DangTin();

                dangTin.Id = cursor.getString(cursor.getColumnIndex("ID"));
                dangTin.TieuDe = cursor.getString(cursor.getColumnIndex("TieuDe"));
                dangTin.LoaiPhong = cursor.getString(cursor.getColumnIndex("LoaiPhong"));
                dangTin.ThanhPho = cursor.getString(cursor.getColumnIndex("ThanhPho"));
                dangTin.QuanHuyen = cursor.getString(cursor.getColumnIndex("QuanHuyen"));
                dangTin.TenDiaDiem = cursor.getString(cursor.getColumnIndex("TenDiaDiem"));
                dangTin.TenDuong = cursor.getString(cursor.getColumnIndex("TenDuong"));
                dangTin.SoNha = cursor.getString(cursor.getColumnIndex("SoNha"));


                dangTin.DienTich = cursor.getInt(cursor.getColumnIndex("DienTich"));
                dangTin.PhongNgu = cursor.getInt(cursor.getColumnIndex("PhongNgu"));
                dangTin.VeSinh = cursor.getInt(cursor.getColumnIndex("VeSinh"));
                dangTin.Gia = cursor.getInt(cursor.getColumnIndex("Gia"));

                dangTin.KinhDo = cursor.getDouble(cursor.getColumnIndex("KinhDo"));
                dangTin.ViDo = cursor.getDouble(cursor.getColumnIndex("ViDo"));
                dangTin.MoTa = cursor.getString(cursor.getColumnIndex("MoTa"));
                dangTin.LienHe = cursor.getString(cursor.getColumnIndex("LienHe"));

                dangTinList.add(dangTin);
                cursor.moveToNext();

            }
            cursor.close();
        }
        return  dangTinList;
    }

    public List<DangTin> timkiem33(String loaiphong,String khuvuc){
        List<DangTin> dangTinList=new ArrayList<>();
        String gell="Select*from DangTin where LoaiPhong like '%"+loaiphong+"%' and QuanHuyen like'%"+khuvuc+"%' and Gia >3000000 and DienTich >50";
        Cursor cursor=mySQLite.getReadableDatabase().rawQuery(gell,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                DangTin dangTin=new DangTin();

                dangTin.Id = cursor.getString(cursor.getColumnIndex("ID"));
                dangTin.TieuDe = cursor.getString(cursor.getColumnIndex("TieuDe"));
                dangTin.LoaiPhong = cursor.getString(cursor.getColumnIndex("LoaiPhong"));
                dangTin.ThanhPho = cursor.getString(cursor.getColumnIndex("ThanhPho"));
                dangTin.QuanHuyen = cursor.getString(cursor.getColumnIndex("QuanHuyen"));
                dangTin.TenDiaDiem = cursor.getString(cursor.getColumnIndex("TenDiaDiem"));
                dangTin.TenDuong = cursor.getString(cursor.getColumnIndex("TenDuong"));
                dangTin.SoNha = cursor.getString(cursor.getColumnIndex("SoNha"));


                dangTin.DienTich = cursor.getInt(cursor.getColumnIndex("DienTich"));
                dangTin.PhongNgu = cursor.getInt(cursor.getColumnIndex("PhongNgu"));
                dangTin.VeSinh = cursor.getInt(cursor.getColumnIndex("VeSinh"));
                dangTin.Gia = cursor.getInt(cursor.getColumnIndex("Gia"));

                dangTin.KinhDo = cursor.getDouble(cursor.getColumnIndex("KinhDo"));
                dangTin.ViDo = cursor.getDouble(cursor.getColumnIndex("ViDo"));
                dangTin.MoTa = cursor.getString(cursor.getColumnIndex("MoTa"));
                dangTin.LienHe = cursor.getString(cursor.getColumnIndex("LienHe"));

                dangTinList.add(dangTin);
                cursor.moveToNext();

            }
            cursor.close();
        }
        return  dangTinList;
    }


}
