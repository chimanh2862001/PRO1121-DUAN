package com.example.pro1121_duan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pro1121_duan.Adapter.PhongAdapter;
import com.example.pro1121_duan.Adapter.PhongListViewAdapter;
import com.example.pro1121_duan.DAO.DangTinDao;
import com.example.pro1121_duan.Model.DangTin;
import com.example.pro1121_duan.SQLite.MySQLite;

import java.util.List;

public class XemTimChitiet extends AppCompatActivity {
  String [] all={"Không Tìm Thấy Dữ Liệu Cần Tìm!!!"};
  ListView Lv;
  EditText edTimKiem;
  TextView tvHuy;

  String[] loaiPhong = {"--- Loại Phòng ---","Kí Túc/Homestay","Phòng Trọ","Chung Cư", "Nhà Nguyên Căn"};
  String[] phongNgu = {"--- Số Phòng Ngủ ---" ,"1", "2", "3", "4", "6"};
  String[] dienTich = {"--- Diện Tích ---","20 - 30m²","30 - 50m²","> 50m²",};
  String[] mucgia ={"--- Mức Giá ---","Dưới 1.500.000VND","1.500.000 - 3.000.000VND","Trên 3.000.000VND"};
  String[] sapXep ={ "--- Sắp Xếp ---" ,"Giá thấp đến cao", "Giá cao đến thấp", "Diện tích nhỏ đến lớn", "Diện tích lớn đến nhỏ"};

  Spinner spLoaiPhong, spPhongNgu, spDienTich, spMucGia, spSapXep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_tim_chitiet);
        Lv=findViewById(R.id.Lv);
        edTimKiem = findViewById(R.id.edTimKiemTimChiTiet);
        tvHuy = findViewById(R.id.tvHuyTimChiTiet);

        spLoaiPhong = findViewById(R.id.spinner1);
        spPhongNgu = findViewById(R.id.spinner2);
        spDienTich = findViewById(R.id.spinner3);
        spMucGia = findViewById(R.id.spinner4);
        spSapXep = findViewById(R.id.spinner5);

        ArrayAdapter<String> arrayAdapter1=new ArrayAdapter<>(XemTimChitiet.this,android.R.layout.simple_list_item_1,loaiPhong);
        ArrayAdapter<String> arrayAdapter2=new ArrayAdapter<>(XemTimChitiet.this,android.R.layout.simple_list_item_1,phongNgu);
        ArrayAdapter<String> arrayAdapter3=new ArrayAdapter<>(XemTimChitiet.this,android.R.layout.simple_list_item_1,dienTich);
        ArrayAdapter<String> arrayAdapter4=new ArrayAdapter<>(XemTimChitiet.this,android.R.layout.simple_list_item_1,mucgia);
        ArrayAdapter<String> arrayAdapter5=new ArrayAdapter<>(XemTimChitiet.this,android.R.layout.simple_list_item_1,sapXep);

        spLoaiPhong.setAdapter(arrayAdapter1);
        spPhongNgu.setAdapter(arrayAdapter2);
        spDienTich.setAdapter(arrayAdapter3);
        spMucGia.setAdapter(arrayAdapter4);
        spSapXep.setAdapter(arrayAdapter5);


        Intent intent=getIntent();

        String loaiphong = intent.getExtras().getString("loaiphong");

        String khuvuc=intent.getExtras().getString("khuvuc");

        String mucgia=intent.getExtras().getString("mucgia");

        String dientich=intent.getExtras().getString("dientich");

        edTimKiem.setText(khuvuc);
        tvHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        System.out.println(mucgia);
        System.out.println(dientich);
        System.out.println(loaiphong);
        System.out.println(khuvuc);

        MySQLite mySQLite=new MySQLite(XemTimChitiet.this);
        DangTinDao dangTinDao=new DangTinDao(mySQLite);

//        List<DangTin> dangTinList=dangTinDao.timchiTiet(loaiphong,khuvuc,mucgia,dientich);
//        if (dangTinList.size()==0){
//            ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
//            Lv.setAdapter(arrayAdapter);
//        }else {
//            PhongAdapter phongAdapter=new PhongAdapter(dangTinList);
//            Lv.setAdapter(phongAdapter);
//        }

         ///1.1
        if (mucgia.equals("1200000")&& dientich.equals("25")){
             List<DangTin> dangTinList=dangTinDao.timchitiet11(loaiphong,khuvuc);
            ///1.1
            if (dangTinList.size()==0){
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
                Lv.setAdapter(arrayAdapter);
            }else {
              PhongListViewAdapter phongAdapter=new PhongListViewAdapter(dangTinList);
              Lv.setAdapter(phongAdapter);
              Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                  @Override
                  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                      DangTin dangTin = dangTinList.get(position);
                      Intent intent= new Intent(getApplicationContext(),ChiTietTro_Googlemap.class);
                      intent.putExtra("Tieude",dangTin.TieuDe);
                      intent.putExtra("Dientich",dangTin.DienTich);
                      intent.putExtra("Phongngu",dangTin.PhongNgu);
                      intent.putExtra("Vesinh",dangTin.VeSinh);
                      intent.putExtra("Kinhdo",dangTin.KinhDo);
                      intent.putExtra("Vido",dangTin.ViDo);
                      intent.putExtra("LoaiPhong", dangTin.LoaiPhong);
                      intent.putExtra("ThanhPho", dangTin.ThanhPho);
                      intent.putExtra("QuanHuyen", dangTin.QuanHuyen);
                      intent.putExtra("TenDiaDiem", dangTin.TenDiaDiem);
                      intent.putExtra("TenDuong", dangTin.TenDuong);
                      intent.putExtra("SoNha", dangTin.SoNha);
                      intent.putExtra("Gia", dangTin.Gia);
                      intent.putExtra("MoTa", dangTin.MoTa);
                      intent.putExtra("LienHe", dangTin.LienHe);
                      startActivity(intent);
                  }
              });
            }

        }
        if (mucgia.equals("1200000")&& dientich.equals("35")){
            //1/2
            List<DangTin> dangTinList=dangTinDao.timchitiet12(loaiphong,khuvuc);
            if (dangTinList.size()==0){
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
                Lv.setAdapter(arrayAdapter);
            }else {
                PhongListViewAdapter phongAdapter=new PhongListViewAdapter(dangTinList);
                Lv.setAdapter(phongAdapter);
                Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        DangTin dangTin = dangTinList.get(position);
                        Intent intent= new Intent(getApplicationContext(),ChiTietTro_Googlemap.class);
                        intent.putExtra("Tieude",dangTin.TieuDe);
                        intent.putExtra("Dientich",dangTin.DienTich);
                        intent.putExtra("Phongngu",dangTin.PhongNgu);
                        intent.putExtra("Vesinh",dangTin.VeSinh);
                        intent.putExtra("Kinhdo",dangTin.KinhDo);
                        intent.putExtra("Vido",dangTin.ViDo);
                        intent.putExtra("LoaiPhong", dangTin.LoaiPhong);
                        intent.putExtra("ThanhPho", dangTin.ThanhPho);
                        intent.putExtra("QuanHuyen", dangTin.QuanHuyen);
                        intent.putExtra("TenDiaDiem", dangTin.TenDiaDiem);
                        intent.putExtra("TenDuong", dangTin.TenDuong);
                        intent.putExtra("SoNha", dangTin.SoNha);
                        intent.putExtra("Gia", dangTin.Gia);
                        intent.putExtra("MoTa", dangTin.MoTa);
                        intent.putExtra("LienHe", dangTin.LienHe);
                        startActivity(intent);
                    }
                });
            }
        }
        if(mucgia.equals("1200000")&& dientich.equals("55")){
            //1.3
            List<DangTin> dangTinList=dangTinDao.timchitiet13(loaiphong,khuvuc);
            if (dangTinList.size()==0){
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
                Lv.setAdapter(arrayAdapter);
            }else {
                PhongListViewAdapter phongAdapter=new PhongListViewAdapter(dangTinList);
                Lv.setAdapter(phongAdapter);
                Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        DangTin dangTin = dangTinList.get(position);
                        Intent intent= new Intent(getApplicationContext(),ChiTietTro_Googlemap.class);
                        intent.putExtra("Tieude",dangTin.TieuDe);
                        intent.putExtra("Dientich",dangTin.DienTich);
                        intent.putExtra("Phongngu",dangTin.PhongNgu);
                        intent.putExtra("Vesinh",dangTin.VeSinh);
                        intent.putExtra("Kinhdo",dangTin.KinhDo);
                        intent.putExtra("Vido",dangTin.ViDo);
                        intent.putExtra("LoaiPhong", dangTin.LoaiPhong);
                        intent.putExtra("ThanhPho", dangTin.ThanhPho);
                        intent.putExtra("QuanHuyen", dangTin.QuanHuyen);
                        intent.putExtra("TenDiaDiem", dangTin.TenDiaDiem);
                        intent.putExtra("TenDuong", dangTin.TenDuong);
                        intent.putExtra("SoNha", dangTin.SoNha);
                        intent.putExtra("Gia", dangTin.Gia);
                        intent.putExtra("MoTa", dangTin.MoTa);
                        intent.putExtra("LienHe", dangTin.LienHe);
                        startActivity(intent);
                    }
                });
            }
        }
        if (mucgia.equals("2000000") && dientich.equals("25")){

            //2.1
            List<DangTin> dangTinList=dangTinDao.timchitiet21(loaiphong,khuvuc);
            if (dangTinList.size()==0){
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
                Lv.setAdapter(arrayAdapter);
            }else {
                PhongListViewAdapter phongAdapter=new PhongListViewAdapter(dangTinList);
                Lv.setAdapter(phongAdapter);
                Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        DangTin dangTin = dangTinList.get(position);
                        Intent intent= new Intent(getApplicationContext(),ChiTietTro_Googlemap.class);
                        intent.putExtra("Tieude",dangTin.TieuDe);
                        intent.putExtra("Dientich",dangTin.DienTich);
                        intent.putExtra("Phongngu",dangTin.PhongNgu);
                        intent.putExtra("Vesinh",dangTin.VeSinh);
                        intent.putExtra("Kinhdo",dangTin.KinhDo);
                        intent.putExtra("Vido",dangTin.ViDo);
                        intent.putExtra("LoaiPhong", dangTin.LoaiPhong);
                        intent.putExtra("ThanhPho", dangTin.ThanhPho);
                        intent.putExtra("QuanHuyen", dangTin.QuanHuyen);
                        intent.putExtra("TenDiaDiem", dangTin.TenDiaDiem);
                        intent.putExtra("TenDuong", dangTin.TenDuong);
                        intent.putExtra("SoNha", dangTin.SoNha);
                        intent.putExtra("Gia", dangTin.Gia);
                        intent.putExtra("MoTa", dangTin.MoTa);
                        intent.putExtra("LienHe", dangTin.LienHe);
                        startActivity(intent);
                    }
                });
            }
        }
        if (mucgia.equals("2000000") && dientich.equals("35")){
            ///2.2
            List<DangTin> dangTinList=dangTinDao.timchitiet22(loaiphong,khuvuc);
            if (dangTinList.size()==0){
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
                Lv.setAdapter(arrayAdapter);
            }else {
                PhongListViewAdapter phongAdapter=new PhongListViewAdapter(dangTinList);
                Lv.setAdapter(phongAdapter);
                Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        DangTin dangTin = dangTinList.get(position);
                        Intent intent= new Intent(getApplicationContext(),ChiTietTro_Googlemap.class);
                        intent.putExtra("Tieude",dangTin.TieuDe);
                        intent.putExtra("Dientich",dangTin.DienTich);
                        intent.putExtra("Phongngu",dangTin.PhongNgu);
                        intent.putExtra("Vesinh",dangTin.VeSinh);
                        intent.putExtra("Kinhdo",dangTin.KinhDo);
                        intent.putExtra("Vido",dangTin.ViDo);
                        intent.putExtra("LoaiPhong", dangTin.LoaiPhong);
                        intent.putExtra("ThanhPho", dangTin.ThanhPho);
                        intent.putExtra("QuanHuyen", dangTin.QuanHuyen);
                        intent.putExtra("TenDiaDiem", dangTin.TenDiaDiem);
                        intent.putExtra("TenDuong", dangTin.TenDuong);
                        intent.putExtra("SoNha", dangTin.SoNha);
                        intent.putExtra("Gia", dangTin.Gia);
                        intent.putExtra("MoTa", dangTin.MoTa);
                        intent.putExtra("LienHe", dangTin.LienHe);
                        startActivity(intent);
                    }
                });
            }
        }

        if (mucgia.equals("2000000") && dientich.equals("55")){

            //2.3
            List<DangTin> dangTinList=dangTinDao.timchitiet23(loaiphong,khuvuc);
            if (dangTinList.size()==0){
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
                Lv.setAdapter(arrayAdapter);
            }else {
                PhongListViewAdapter phongAdapter=new PhongListViewAdapter(dangTinList);
                Lv.setAdapter(phongAdapter);
                Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        DangTin dangTin = dangTinList.get(position);
                        Intent intent= new Intent(getApplicationContext(),ChiTietTro_Googlemap.class);
                        intent.putExtra("Tieude",dangTin.TieuDe);
                        intent.putExtra("Dientich",dangTin.DienTich);
                        intent.putExtra("Phongngu",dangTin.PhongNgu);
                        intent.putExtra("Vesinh",dangTin.VeSinh);
                        intent.putExtra("Kinhdo",dangTin.KinhDo);
                        intent.putExtra("Vido",dangTin.ViDo);
                        intent.putExtra("LoaiPhong", dangTin.LoaiPhong);
                        intent.putExtra("ThanhPho", dangTin.ThanhPho);
                        intent.putExtra("QuanHuyen", dangTin.QuanHuyen);
                        intent.putExtra("TenDiaDiem", dangTin.TenDiaDiem);
                        intent.putExtra("TenDuong", dangTin.TenDuong);
                        intent.putExtra("SoNha", dangTin.SoNha);
                        intent.putExtra("Gia", dangTin.Gia);
                        intent.putExtra("MoTa", dangTin.MoTa);
                        intent.putExtra("LienHe", dangTin.LienHe);
                        startActivity(intent);
                    }
                });
            }

        }

        if (mucgia.equals("3500000") && dientich.equals("25")){
            //3.1
            List<DangTin> dangTinList=dangTinDao.timkiem31(loaiphong,khuvuc);
            if (dangTinList.size()==0){
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
                Lv.setAdapter(arrayAdapter);
            }else {
                PhongListViewAdapter phongAdapter=new PhongListViewAdapter(dangTinList);
                Lv.setAdapter(phongAdapter);
                Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        DangTin dangTin = dangTinList.get(position);
                        Intent intent= new Intent(getApplicationContext(),ChiTietTro_Googlemap.class);
                        intent.putExtra("Tieude",dangTin.TieuDe);
                        intent.putExtra("Dientich",dangTin.DienTich);
                        intent.putExtra("Phongngu",dangTin.PhongNgu);
                        intent.putExtra("Vesinh",dangTin.VeSinh);
                        intent.putExtra("Kinhdo",dangTin.KinhDo);
                        intent.putExtra("Vido",dangTin.ViDo);
                        intent.putExtra("LoaiPhong", dangTin.LoaiPhong);
                        intent.putExtra("ThanhPho", dangTin.ThanhPho);
                        intent.putExtra("QuanHuyen", dangTin.QuanHuyen);
                        intent.putExtra("TenDiaDiem", dangTin.TenDiaDiem);
                        intent.putExtra("TenDuong", dangTin.TenDuong);
                        intent.putExtra("SoNha", dangTin.SoNha);
                        intent.putExtra("Gia", dangTin.Gia);
                        intent.putExtra("MoTa", dangTin.MoTa);
                        intent.putExtra("LienHe", dangTin.LienHe);
                        startActivity(intent);
                    }
                });
            }
        }

        if (mucgia.equals("3500000") && dientich.equals("35")){

            List<DangTin> dangTinList=dangTinDao.timkiem32(loaiphong,khuvuc);
            if (dangTinList.size()==0){
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
                Lv.setAdapter(arrayAdapter);
            }else {
                PhongListViewAdapter phongAdapter=new PhongListViewAdapter(dangTinList);
                Lv.setAdapter(phongAdapter);
                Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        DangTin dangTin = dangTinList.get(position);
                        Intent intent= new Intent(getApplicationContext(),ChiTietTro_Googlemap.class);
                        intent.putExtra("Tieude",dangTin.TieuDe);
                        intent.putExtra("Dientich",dangTin.DienTich);
                        intent.putExtra("Phongngu",dangTin.PhongNgu);
                        intent.putExtra("Vesinh",dangTin.VeSinh);
                        intent.putExtra("Kinhdo",dangTin.KinhDo);
                        intent.putExtra("Vido",dangTin.ViDo);
                        intent.putExtra("LoaiPhong", dangTin.LoaiPhong);
                        intent.putExtra("ThanhPho", dangTin.ThanhPho);
                        intent.putExtra("QuanHuyen", dangTin.QuanHuyen);
                        intent.putExtra("TenDiaDiem", dangTin.TenDiaDiem);
                        intent.putExtra("TenDuong", dangTin.TenDuong);
                        intent.putExtra("SoNha", dangTin.SoNha);
                        intent.putExtra("Gia", dangTin.Gia);
                        intent.putExtra("MoTa", dangTin.MoTa);
                        intent.putExtra("LienHe", dangTin.LienHe);
                        startActivity(intent);
                    }
                });
            }
        }
        if (mucgia.equals("3500000") && dientich.equals("55")){
            List<DangTin> dangTinList = dangTinDao.timkiem33(loaiphong,khuvuc);
            if (dangTinList.size()==0){
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
                Lv.setAdapter(arrayAdapter);
            }else {
                PhongListViewAdapter phongAdapter=new PhongListViewAdapter(dangTinList);
                Lv.setAdapter(phongAdapter);
                Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        DangTin dangTin = dangTinList.get(position);
                        Intent intent= new Intent(getApplicationContext(),ChiTietTro_Googlemap.class);
                        intent.putExtra("Tieude",dangTin.TieuDe);
                        intent.putExtra("Dientich",dangTin.DienTich);
                        intent.putExtra("Phongngu",dangTin.PhongNgu);
                        intent.putExtra("Vesinh",dangTin.VeSinh);
                        intent.putExtra("Kinhdo",dangTin.KinhDo);
                        intent.putExtra("Vido",dangTin.ViDo);
                        intent.putExtra("LoaiPhong", dangTin.LoaiPhong);
                        intent.putExtra("ThanhPho", dangTin.ThanhPho);
                        intent.putExtra("QuanHuyen", dangTin.QuanHuyen);
                        intent.putExtra("TenDiaDiem", dangTin.TenDiaDiem);
                        intent.putExtra("TenDuong", dangTin.TenDuong);
                        intent.putExtra("SoNha", dangTin.SoNha);
                        intent.putExtra("Gia", dangTin.Gia);
                        intent.putExtra("MoTa", dangTin.MoTa);
                        intent.putExtra("LienHe", dangTin.LienHe);
                        startActivity(intent);
                    }
                });
            }
        }


    }
}