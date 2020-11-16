package com.example.pro1121_duan;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pro1121_duan.DAO.DangTinDao;
import com.example.pro1121_duan.Model.DangTin;
import com.example.pro1121_duan.SQLite.MySQLite;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap map;

    Button button3;
    EditText edtTim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        edtTim=findViewById(R.id.edtTim);
        button3=findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tim=edtTim.getText().toString().trim();
                MySQLite mySQLite=new MySQLite(MapsActivity.this);
                DangTinDao dangTinDao=new DangTinDao(mySQLite);
                List<DangTin> dangTinList=dangTinDao.timKiem(tim);
                if (tim.isEmpty()){
                    edtTim.setError("Không được để trống");
                }else {
                    if (dangTinList.size()==0){
                        edtTim.setError("Không tìm thấy mục bạn yêu cầu");

                    }else {
                        for (DangTin s:dangTinList){
                            if (s.TieuDe.equals(tim)|| s.QuanHuyen.equals(tim)|| s.ThanhPho.equals(tim)){
                                LatLng sydney = new LatLng(s.KinhDo, s.ViDo);
                                map.addMarker(new MarkerOptions().position(sydney).title(s.TieuDe));
                                map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                            }else {
                                map.clear();
                            }
                        }

                    }
                }
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
        map = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}