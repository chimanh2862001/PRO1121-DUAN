package com.example.pro1121_duan;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pro1121_duan.Adapter.PhongAdapter;
import com.example.pro1121_duan.DAO.DangTinDao;
import com.example.pro1121_duan.Model.DangTin;
import com.example.pro1121_duan.SQLite.MySQLite;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class ChiTietTro_Googlemap extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    TextView tvTitle,tvDientich,tvBed,tvToilet,tvTTMT, tvXCTLoaiPhong, tvMucGia, tvngayDang, tvDiaChi;
    double kinhdo,vido;
    String loaiPhong, thanhPho, quanHuyen, tenDiaDiem, tenDuong, soNha, moTa, lienHe;
    Integer gia;
    Button btnGoiOGhep;
    GridView gridView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_tro__googlemap);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        toolbar = findViewById(R.id.toolBarChiTietPhong);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        Intent intent = getIntent();
        tvTitle=findViewById(R.id.tvTitle);
        btnGoiOGhep=findViewById(R.id.btnGoiOGhep);
        tvDientich=findViewById(R.id.tvDientich);
        tvBed=findViewById(R.id.tvBed);
        tvToilet=findViewById(R.id.tvToilet);
        tvTTMT=findViewById(R.id.tvTTMT);
        tvXCTLoaiPhong = findViewById(R.id.tvXCTLoaiPhong);
        tvMucGia = findViewById(R.id.tvMucGia);
        tvngayDang = findViewById(R.id.tvNgayDang);
        tvDiaChi = findViewById(R.id.tvDiaChi);

        gridView = findViewById(R.id.listGiongTieuChi);
        ///

        loaiPhong = intent.getExtras().getString("LoaiPhong");
        thanhPho = intent.getExtras().getString("ThanhPho");
        quanHuyen = intent.getExtras().getString("QuanHuyen");
        tenDiaDiem = intent.getExtras().getString("TenDiaDiem");
        tenDuong = intent.getExtras().getString("TenDuong");
        soNha = intent.getExtras().getString("SoNha");

        gia = Integer.parseInt(String.valueOf(intent.getExtras().getInt("Gia")));

        moTa = intent.getExtras().getString("MoTa");
        lienHe ="tel:"+intent.getExtras().getString("LienHe");

        Integer dientich=Integer.parseInt(String.valueOf(intent.getExtras().getInt("Dientich")));
        Integer phongngu=Integer.parseInt(String.valueOf(intent.getExtras().getInt("Phongngu")));
        Integer vesinh=Integer.parseInt(String.valueOf(intent.getExtras().getInt("Vesinh")));

        Double kinhdo1=Double.parseDouble(String.valueOf(intent.getExtras().getDouble("Kinhdo")));
        Double vido1=Double.parseDouble(String.valueOf(intent.getExtras().getDouble("Vido")));

        kinhdo = kinhdo1;
        vido = vido1;
        
        ///
        String tieude = intent.getExtras().getString("Tieude");
        tenDiaDiem = tieude;


        ////

        tvTitle.setText(intent.getExtras().getString("Tieude"));
        tvDientich.setText(dientich+" m2");
        tvBed.setText(phongngu+" pn");
        tvToilet.setText(vesinh+" vs");
        tvTTMT.setText(moTa);
        tvXCTLoaiPhong.setText(loaiPhong);
        tvMucGia.setText("Mức Giá: "+gia);
        tvngayDang.setText("?/?/?");
        tvDiaChi.setText(thanhPho + ", " + quanHuyen + ", " + tenDuong + ", " + soNha);

        MySQLite mySQL = new MySQLite(getApplicationContext());
        DangTinDao dangTinDao = new DangTinDao(mySQL);
        List<DangTin> list = dangTinDao.getAll();
        PhongAdapter adapter = new PhongAdapter(list);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DangTin dangTin = list.get(position);
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

        btnGoiOGhep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse(lienHe));
                startActivity(intent1);
            }
        });



    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(kinhdo, vido);
        mMap.addMarker(new MarkerOptions().position(sydney).title(tenDiaDiem));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_xem_chi_tiet, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.chiaSe){

        }if (id == R.id.yeuThich){

        }
        return super.onOptionsItemSelected(item);
    }

}