package com.example.pro1121_duan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ActivityNotFoundException;
import android.content.ContentUris;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class XemChiTietOGhepActivity extends AppCompatActivity {

    TextView tvTieuDe, tvGia, tvDiaChi, tvMoTa, tvLienHe, tvGioiTinh;
    Toolbar toolbar;
    Button btnNhanTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_chi_tiet_o_ghep);

        toolbar = findViewById(R.id.toolBarChiTietOGhep);
        getSupportActionBar();
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnNhanTin = findViewById(R.id.btnNhanTinOGhep);
        btnNhanTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Intent intent = getIntent();

        tvTieuDe = findViewById(R.id.tvTieuDeOG);
        tvGia = findViewById(R.id.tvGiaOG);
        tvGioiTinh = findViewById(R.id.tvGioiTinhOG);
        tvDiaChi = findViewById(R.id.tvDiaChiOG);
        tvMoTa = findViewById(R.id.tvMoTaOG);

        String td = intent.getExtras().getString("TieuDe");
        String gt = intent.getExtras().getString("GioiTinh");
        Double gia = Double.parseDouble(String.valueOf(intent.getExtras().getDouble("Gia")));
        String dc = intent.getExtras().getString("DiaChi");
        String mt = intent.getExtras().getString("MoTa");
        String lh = intent.getExtras().getString("LienHe");

        tvTieuDe.setText(td);
        tvGia.setText(gia+"");
        tvGioiTinh.setText(gt);
        tvDiaChi.setText(dc);
        tvMoTa.setText(mt);
    }
}