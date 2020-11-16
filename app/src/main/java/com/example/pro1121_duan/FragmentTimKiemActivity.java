package com.example.pro1121_duan;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.pro1121_duan.Adapter.PhongAdapter;
import com.example.pro1121_duan.Adapter.PhongListViewAdapter;
import com.example.pro1121_duan.DAO.DangTinDao;
import com.example.pro1121_duan.Model.DangTin;
import com.example.pro1121_duan.SQLite.MySQLite;

import java.util.List;


public class FragmentTimKiemActivity extends Fragment {
 GridView gridView;
 ListView listView;
 ImageView dangtin;
 EditText edtTim;
 ImageView imgtimchitet,imgSearch, imgGanBan;

 ScrollView scrollView;

    public FragmentTimKiemActivity() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tim_kiem_activity, container, false);
        gridView = view.findViewById(R.id.listds);
        dangtin =view.findViewById(R.id.imageView5);
        imgtimchitet=view.findViewById(R.id.imgtimchitiet);
        edtTim=view.findViewById(R.id.edtTim);
        imgSearch=view.findViewById(R.id.imgSearch);
        imgGanBan = view.findViewById(R.id.imageView4);
        listView = view.findViewById(R.id.lvListXemAll);

        scrollView = view.findViewById(R.id.scrollTK);


        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtTim.getText().toString().trim().length()==0){
                    Toast.makeText(getActivity(), "Vui Lòng Nhập Thông Tin Tìm kiếm", Toast.LENGTH_SHORT).show();
                     return;
                }else {
                    String timkiem = edtTim.getText().toString().trim();
                    Intent intent = new Intent(getActivity(), XemTimKiem.class);
                    intent.putExtra("timkiem", timkiem);
                    startActivity(intent);
                }

            }
        });

        imgGanBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
            }
        });


        dangtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                startActivity(new Intent(getActivity() ,ThemTin.class));


            }
        });

        imgtimchitet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   Intent intent=new Intent(getActivity(),TimChiTietActivity.class);
                   startActivity(intent);
            }
        });
        MySQLite mySQL = new MySQLite(getActivity());
        DangTinDao dangTinDao = new DangTinDao(mySQL);
        List<DangTin> list = dangTinDao.getAll();
        PhongAdapter adapter = new PhongAdapter(list);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DangTin dangTin = list.get(position);
                Intent intent= new Intent(getActivity(),ChiTietTro_Googlemap.class);

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

        PhongListViewAdapter phongListViewAdapter = new PhongListViewAdapter(list);
        listView.setAdapter(phongListViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DangTin dangTin = list.get(position);
                Intent intent= new Intent(getActivity(),ChiTietTro_Googlemap.class);

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

        return  view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragtimkiem,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.idDangPhong){
            Intent intent = new Intent(getActivity(), ThemTin.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}