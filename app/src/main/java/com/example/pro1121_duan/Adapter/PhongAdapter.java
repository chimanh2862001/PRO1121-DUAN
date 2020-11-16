package com.example.pro1121_duan.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pro1121_duan.FragmentOGhepActivity;
import com.example.pro1121_duan.Model.DangTin;
import com.example.pro1121_duan.R;
import com.example.pro1121_duan.XemTimChitiet;

import java.util.List;

public class PhongAdapter extends BaseAdapter {
    List<DangTin> dangTinList;

    public PhongAdapter(List<DangTin> dangTinList){

        this.dangTinList = dangTinList;
    }




    @Override
    public int getCount() {
        return dangTinList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,viewGroup,false);
        TextView tieude= view.findViewById(R.id.textView7);
        TextView diachi= view.findViewById(R.id.textView8);
        TextView dientich= view.findViewById(R.id.tvDienTichAdapter);
        TextView phongngu = view.findViewById(R.id.tvPhongNguAdapter);
        TextView veSinh = view.findViewById(R.id.tvVeSinhAdapter);
        TextView loaiPhong = view.findViewById(R.id.tvLoaiPhongAdapter);
        TextView gia= view.findViewById(R.id.textView2);
        ImageView imgLuu = view.findViewById(R.id.imgLuuTin);

        DangTin tt = dangTinList.get(i);
        tieude.setText(""+tt.TieuDe);
        diachi.setText(""+tt.getThanhPho()+" - "+tt.QuanHuyen+" - "+tt.TenDiaDiem);
        dientich.setText(tt.DienTich+"m2");
        phongngu.setText(tt.PhongNgu +"");
        veSinh.setText(tt.VeSinh +"");
        gia.setText(""+tt.Gia+".VND");
        loaiPhong.setText(tt.LoaiPhong);

        imgLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(viewGroup.getContext(), "Luu Thanh Cong", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
