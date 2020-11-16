package com.example.pro1121_duan.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pro1121_duan.Model.OGhep;
import com.example.pro1121_duan.R;

import java.util.List;

public class ThemOGhepAdapter extends BaseAdapter {

    List<OGhep> oGhepList;

    public ThemOGhepAdapter(List<OGhep> oGhepList) {
        this.oGhepList = oGhepList;
    }

    @Override
    public int getCount() {
        return oGhepList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.o_ghep_adpater, parent, false);
        TextView tvTieuDe = convertView.findViewById(R.id.tvTieuDeAd);
        TextView tvMucGia = convertView.findViewById(R.id.tvMucGiaOgAd);
        TextView tvViTri = convertView.findViewById(R.id.tvViTriAd);

        OGhep oGhep = oGhepList.get(position);
        tvTieuDe.setText(oGhep.TieuDe);
        tvMucGia.setText(oGhep.Gia+" VND");
        tvViTri.setText(oGhep.DiaChi);

        return convertView;
    }
}
