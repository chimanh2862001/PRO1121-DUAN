package com.example.pro1121_duan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class TimKiemOGhep extends AppCompatActivity {

    String[] MucGia = {"--- Mức Giá ---", "500.000 - 1.000.000VND", "1.000.000 - 3.000.000VND", "3.000.000 - 5.000.000VND", "Trên 5.000.000VND"};
    String[] GioiTinh = {"--- Giới Tính ---", "Nam", "Nữ"};
    String[] KhuVuc = {"--- Khu Vực---","Bắc Từ Liêm","Cầu Giấy","Đống Đa","Hà Đông","Hai Bà Trưng","Hoàn Kiếm","Hoàng Mai"
            ,"Long Biên","Nam Từ Liêm","Tây Hồ","Thanh Xuân","Quốc Oai","Ba Vì","Chương Mỹ","Đan Phượng","Đông Anh"
            ,"Gia Lâm","Hoài Đức","Mê Linh","Mỹ Đức","Phú Xuyên","Phúc Thọ","Sóc Sơn","Thạch Thất","Thanh Oai"
            ,"Thanh Trì","Thường Tín","Ứng Hòa"};

    Spinner spMG, spGT, spDC;
    Button btnTK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem_o_ghep);

        spMG = findViewById(R.id.spMucGia);
        spGT = findViewById(R.id.spGioiTinh);
        spDC = findViewById(R.id.spDiaChi);

        btnTK = findViewById(R.id.btnXemTimKiemOG);

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(TimKiemOGhep.this, android.R.layout.simple_list_item_1, MucGia);
        ArrayAdapter<String> stringArrayAdapter1 = new ArrayAdapter<>(TimKiemOGhep.this, android.R.layout.simple_list_item_1, GioiTinh);
        ArrayAdapter<String> stringArrayAdapter2 = new ArrayAdapter<>(TimKiemOGhep.this, android.R.layout.simple_list_item_1, KhuVuc);

        spMG.setAdapter(stringArrayAdapter);
        spGT.setAdapter(stringArrayAdapter1);
        spDC.setAdapter(stringArrayAdapter2);

        btnTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spMG.getSelectedItem().toString().equals("--- Mức Giá ---") || spGT.getSelectedItem().toString().equals("--- Giới Tính ---") || spDC.getSelectedItem().toString().equals("--- Khu Vực---")){
                    Toast.makeText(TimKiemOGhep.this, "Vui lòng chọn các mục cần tìm", Toast.LENGTH_LONG).show();
                }else if (spMG.getSelectedItem().toString().equals("500.000 - 1.000.000VND")){
                    String mucGia = "700000";
                    String gioiTinh = spGT.getSelectedItem().toString();
                    String DiaChi = spDC.getSelectedItem().toString();

                    Intent intent = new Intent(TimKiemOGhep.this, XemTimKiemOGhepActivity.class);
                    intent.putExtra("mg", mucGia);
                    intent.putExtra("gt", gioiTinh);
                    intent.putExtra("dc", DiaChi);
                    startActivity(intent);
                }else if (spMG.getSelectedItem().toString().equals("1.000.000 - 3.000.000VND")){
                    String mucGia = "2000000";
                    String gioiTinh = spGT.getSelectedItem().toString();
                    String DiaChi = spDC.getSelectedItem().toString();

                    Intent intent = new Intent(TimKiemOGhep.this, XemTimKiemOGhepActivity.class);
                    intent.putExtra("mg", mucGia);
                    intent.putExtra("gt", gioiTinh);
                    intent.putExtra("dc", DiaChi);
                    startActivity(intent);
                }else if (spMG.getSelectedItem().toString().equals("3.000.000 - 5.000.000VND")) {
                    String mucGia = "4000000";
                    String gioiTinh = spGT.getSelectedItem().toString();
                    String DiaChi = spDC.getSelectedItem().toString();

                    Intent intent = new Intent(TimKiemOGhep.this, XemTimKiemOGhepActivity.class);
                    intent.putExtra("mg", mucGia);
                    intent.putExtra("gt", gioiTinh);
                    intent.putExtra("dc", DiaChi);
                    startActivity(intent);
                }else if (spMG.getSelectedItem().toString().equals("Trên 5.000.000VND")) {
                    String mucGia = "7000000";
                    String gioiTinh = spGT.getSelectedItem().toString();
                    String DiaChi = spDC.getSelectedItem().toString();

                    Intent intent = new Intent(TimKiemOGhep.this, XemTimKiemOGhepActivity.class);
                    intent.putExtra("mg", mucGia);
                    intent.putExtra("gt", gioiTinh);
                    intent.putExtra("dc", DiaChi);
                    startActivity(intent);
                }
            }
        });
    }
}