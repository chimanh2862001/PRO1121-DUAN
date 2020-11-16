package com.example.pro1121_duan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pro1121_duan.Adapter.ThemOGhepAdapter;
import com.example.pro1121_duan.DAO.OGhepDao;
import com.example.pro1121_duan.Model.OGhep;
import com.example.pro1121_duan.SQLite.MySQLite;

import java.util.List;

public class XemTimKiemOGhepActivity extends AppCompatActivity {

    String[] non = {"Xin Lỗi!Không Tìm Thấy Phòng Như Yêu Cầu Của Bạn!"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_tim_kiem_o_ghep);

        listView = findViewById(R.id.lvlistXemTimKiem);

        Intent intent = getIntent();
        String mg = intent.getExtras().getString("mg");
        String gt = intent.getExtras().getString("gt");
        String dc = intent.getExtras().getString("dc");

        System.out.println(mg);
        System.out.println(gt);
        System.out.println(dc);

        MySQLite mySQLite = new MySQLite(XemTimKiemOGhepActivity.this);
        OGhepDao oGhepDao = new OGhepDao(mySQLite);

        if (mg.equals("700000")){
            List<OGhep> oGhepList = oGhepDao.timkiem1(gt, dc);
            if (oGhepList.size() == 0){
                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(XemTimKiemOGhepActivity.this, android.R.layout.simple_list_item_1, non);
                listView.setAdapter(stringArrayAdapter);
            }else {
                ThemOGhepAdapter themOGhepAdapter = new ThemOGhepAdapter(oGhepList);
                listView.setAdapter(themOGhepAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        OGhep oGhep = oGhepList.get(position);
                        Intent intent1 = new Intent(XemTimKiemOGhepActivity.this, XemChiTietOGhepActivity.class);
                        intent1.putExtra("TieuDe", oGhep.TieuDe);
                        intent1.putExtra("GioiTinh", oGhep.GioiTinh);
                        intent1.putExtra("Gia", oGhep.Gia);
                        intent1.putExtra("DiaChi", oGhep.DiaChi);
                        intent1.putExtra("MoTa", oGhep.MoTa);
                        intent1.putExtra("LienHe", oGhep.LienHe);
                        startActivity(intent1);
                    }
                });
            }
        }
        if (mg.equals("2000000")){
            List<OGhep> oGhepList = oGhepDao.timkiem12(gt, dc);
            if (oGhepList.size() == 0){
                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(XemTimKiemOGhepActivity.this, android.R.layout.simple_list_item_1, non);
                listView.setAdapter(stringArrayAdapter);
            }else {
                ThemOGhepAdapter themOGhepAdapter = new ThemOGhepAdapter(oGhepList);
                listView.setAdapter(themOGhepAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        OGhep oGhep = oGhepList.get(position);
                        Intent intent1 = new Intent(XemTimKiemOGhepActivity.this, XemChiTietOGhepActivity.class);
                        intent1.putExtra("TieuDe", oGhep.TieuDe);
                        intent1.putExtra("GioiTinh", oGhep.GioiTinh);
                        intent1.putExtra("Gia", oGhep.Gia);
                        intent1.putExtra("DiaChi", oGhep.DiaChi);
                        intent1.putExtra("MoTa", oGhep.MoTa);
                        intent1.putExtra("LienHe", oGhep.LienHe);
                        startActivity(intent1);
                    }
                });
            }
        }
        if (mg.equals("4000000")){
            List<OGhep> oGhepList = oGhepDao.timkiem13(gt, dc);
            if (oGhepList.size() == 0){
                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(XemTimKiemOGhepActivity.this, android.R.layout.simple_list_item_1, non);
                listView.setAdapter(stringArrayAdapter);
            }else {
                ThemOGhepAdapter themOGhepAdapter = new ThemOGhepAdapter(oGhepList);
                listView.setAdapter(themOGhepAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        OGhep oGhep = oGhepList.get(position);
                        Intent intent1 = new Intent(XemTimKiemOGhepActivity.this, XemChiTietOGhepActivity.class);
                        intent1.putExtra("TieuDe", oGhep.TieuDe);
                        intent1.putExtra("GioiTinh", oGhep.GioiTinh);
                        intent1.putExtra("Gia", oGhep.Gia);
                        intent1.putExtra("DiaChi", oGhep.DiaChi);
                        intent1.putExtra("MoTa", oGhep.MoTa);
                        intent1.putExtra("LienHe", oGhep.LienHe);
                        startActivity(intent1);
                    }
                });
            }
        }

        if (mg.equals("7000000")){
            List<OGhep> oGhepList = oGhepDao.timkiem14(gt, dc);
            if (oGhepList.size() == 0){
                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(XemTimKiemOGhepActivity.this, android.R.layout.simple_list_item_1, non);
                listView.setAdapter(stringArrayAdapter);
            }else {
                ThemOGhepAdapter themOGhepAdapter = new ThemOGhepAdapter(oGhepList);
                listView.setAdapter(themOGhepAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        OGhep oGhep = oGhepList.get(position);
                        Intent intent1 = new Intent(XemTimKiemOGhepActivity.this, XemChiTietOGhepActivity.class);
                        intent1.putExtra("TieuDe", oGhep.TieuDe);
                        intent1.putExtra("GioiTinh", oGhep.GioiTinh);
                        intent1.putExtra("Gia", oGhep.Gia);
                        intent1.putExtra("DiaChi", oGhep.DiaChi);
                        intent1.putExtra("MoTa", oGhep.MoTa);
                        intent1.putExtra("LienHe", oGhep.LienHe);
                        startActivity(intent1);
                    }
                });
            }
        }
    }
}