package com.example.pro1121_duan;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pro1121_duan.Adapter.ThemOGhepAdapter;
import com.example.pro1121_duan.DAO.OGhepDao;
import com.example.pro1121_duan.Model.OGhep;
import com.example.pro1121_duan.SQLite.MySQLite;

import java.util.List;


public class FragmentOGhepActivity extends Fragment {

    ListView listView;
    Toolbar toolbar;
    public FragmentOGhepActivity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_o_ghep_activity, container, false);

        toolbar = view.findViewById(R.id.toolBarOGhep);
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        appCompatActivity.setSupportActionBar(toolbar);

        listView = view.findViewById(R.id.lvListGhep);


        MySQLite mySQLite = new MySQLite(getActivity());
        OGhepDao oGhepDao = new OGhepDao(mySQLite);
        List<OGhep> oGhepList = oGhepDao.getAll();
        ThemOGhepAdapter themOGhepAdapter = new ThemOGhepAdapter(oGhepList);
        listView.setAdapter(themOGhepAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OGhep oGhep = oGhepList.get(position);

                Intent intent = new Intent(getActivity(), XemChiTietOGhepActivity.class);

                intent.putExtra("TieuDe", oGhep.TieuDe);
                intent.putExtra("GioiTinh", oGhep.GioiTinh);
                intent.putExtra("Gia", oGhep.Gia);
                intent.putExtra("DiaChi", oGhep.DiaChi);
                intent.putExtra("MoTa", oGhep.MoTa);
                intent.putExtra("LienHe", oGhep.LienHe);

                startActivity(intent);
            }
        });

        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_ghep, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.imgThemGhep){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.activity_them_o_ghep, null);
            builder.setView(view);

            AlertDialog alertDialog = builder.show();

            EditText edID = view.findViewById(R.id.idOGhep);
            EditText edTieuDe = view.findViewById(R.id.TieuDeOGhep);
            RadioButton rdNam = view.findViewById(R.id.RadioNam);
            RadioButton rdNu = view.findViewById(R.id.RadioNu);
            EditText edGia = view.findViewById(R.id.giaThemGhep);
            EditText edDiaChi = view.findViewById(R.id.diaChiThemGhep);
            EditText edMoTa = view. findViewById(R.id.moTaThemGhep);
            EditText edLienHe = view.findViewById(R.id.LienHeThemGhep);

            Button huy = view.findViewById(R.id.btnHuyOG);
            Button them = view.findViewById(R.id.btnThemOGhep);

            huy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });

            them.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edID.getText().toString().length() == 0 || edTieuDe.getText().toString().length() == 0 ||
                            edGia.getText().toString().length() == 0 || edDiaChi.getText().toString().length() == 0 || edMoTa.getText().toString().length() == 0 ||
                            edLienHe.getText().toString().length() == 0){
                        Toast.makeText(getActivity(), "Bạn Chưa Nhập Đủ Thông Tin", Toast.LENGTH_LONG).show();
                    }else {
                        OGhep oGhep = new OGhep();
                        oGhep.ID = edID.getText().toString().trim();
                        oGhep.TieuDe = edTieuDe.getText().toString().trim();
                        oGhep.Gia = Double.parseDouble(edGia.getText().toString().trim());
                        oGhep.DiaChi = edDiaChi.getText().toString().trim();
                        oGhep.MoTa = edMoTa.getText().toString().trim();
                        oGhep.LienHe = edLienHe.getText().toString().trim();
                        if (rdNam.isChecked()){
                            String gt = "Nam";
                            oGhep.GioiTinh = gt;
                        }else if (rdNu.isChecked()){
                            String gt = "Nữ";
                            oGhep.GioiTinh = gt;
                        }

                        MySQLite mySQLite = new MySQLite(getActivity());
                        OGhepDao oGhepDao = new OGhepDao(mySQLite);
                        boolean kq = oGhepDao.insert(oGhep);

                        if (kq){
                            Toast.makeText(getActivity(), "Thêm Thành Công", Toast.LENGTH_LONG).show();
                            alertDialog.dismiss();
                            List<OGhep> oGhepList = oGhepDao.getAll();
                            ThemOGhepAdapter themOGhepAdapter = new ThemOGhepAdapter(oGhepList);
                            listView.setAdapter(themOGhepAdapter);
                        }else {
                            Toast.makeText(getActivity(), "Thêm Không Thành Công", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });
        }

        if (id == R.id.imgTimKiemOG){
            Intent intent = new Intent(getActivity(), TimKiemOGhep.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}