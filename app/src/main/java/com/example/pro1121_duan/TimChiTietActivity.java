package com.example.pro1121_duan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class TimChiTietActivity extends AppCompatActivity {
    String [] loaiphong={"--- Loại Phòng ---","Kí Túc","Phòng Trọ","Chung Cư", "Nhà Nguyên Căn"};
    String [] khuvuc={"--- Khu Vực---","Bắc Từ Liêm","Cầu Giấy","Đống Đa","Hà Đông","Hai Bà Trưng","Hoàn Kiếm","Hoàng Mai"
            ,"Long Biên","Nam Từ Liêm","Tây Hồ","Thanh Xuân","Quốc Oai","Ba Vì","Chương Mỹ","Đan Phượng","Đông Anh"
            ,"Gia Lâm","Hoài Đức","Mê Linh","Mỹ Đức","Phú Xuyên","Phúc Thọ","Sóc Sơn","Thạch Thất","Thanh Oai"
            ,"Thanh Trì","Thường Tín","Ứng Hòa"};
    String []mucgia={"--- Mức Giá ---","Dưới 1.500.000VND","1.500.000 - 3.000.000VND","Trên 3.000.000VND"};
    String [] dientich={"--- Diện Tích ---","20 - 30m²","30 - 50m²","> 50m²",};
    Spinner spinner1,spinner2,spinner3,spinner4;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_chi_tiet);
        spinner1=findViewById(R.id.spinner1);
        spinner2=findViewById(R.id.spinner2);
        spinner3=findViewById(R.id.spinner3);
        spinner4=findViewById(R.id.spinner4);
        button=findViewById(R.id.button);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(TimChiTietActivity.this,android.R.layout.simple_list_item_1,loaiphong);
        ArrayAdapter<String> arrayAdapter2=new ArrayAdapter<>(TimChiTietActivity.this,android.R.layout.simple_list_item_1,khuvuc);
        ArrayAdapter<String> arrayAdapter3=new ArrayAdapter<>(TimChiTietActivity.this,android.R.layout.simple_list_item_1,mucgia);
        ArrayAdapter<String> arrayAdapter4=new ArrayAdapter<>(TimChiTietActivity.this,android.R.layout.simple_list_item_1,dientich);

        spinner1.setAdapter(arrayAdapter);
        spinner2.setAdapter(arrayAdapter2);
        spinner3.setAdapter(arrayAdapter3);
        spinner4.setAdapter(arrayAdapter4);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String mucgia=null;
//                String dientich=null;
                if (spinner1.getSelectedItem().toString().equals("--- Loại Phòng ---") || spinner2.getSelectedItem().toString().equals("--- Khu Vực---")
                   || spinner3.getSelectedItem().toString().equals("--- Mức Giá ---")|| spinner4.getSelectedItem().toString().equals("--- Diện Tích ---")){
                    Toast.makeText(TimChiTietActivity.this, "Vui lòng lựa chọn các mục cần tìm chi tiết", Toast.LENGTH_SHORT).show();
                    return;
                }else if(spinner3.getSelectedItem().toString().equals("Dưới 1.500.000VND")
                        && spinner4.getSelectedItem().toString().equals("20 - 30m²")) {
                    ////1.1
                    String loaiphong=spinner1.getSelectedItem().toString();
                    String khuvuc=spinner2.getSelectedItem().toString();
                    String mucgia="1200000";
                    String dientich="25";
                    Intent intent=new Intent(TimChiTietActivity.this,XemTimChitiet.class);
                    intent.putExtra("loaiphong",loaiphong);
                    intent.putExtra("khuvuc",khuvuc);
                    intent.putExtra("mucgia",mucgia);
                    intent.putExtra("dientich",dientich);
                    startActivity(intent);

                }else if (spinner3.getSelectedItem().toString().equals("Dưới 1.500.000VND")
                        && spinner4.getSelectedItem().toString().equals("30 - 50m²")){

                    ////1.2
                    String loaiphong=spinner1.getSelectedItem().toString();
                    String khuvuc=spinner2.getSelectedItem().toString();
                    String mucgia="1200000";
                    String dientich="35";
                    Intent intent=new Intent(TimChiTietActivity.this,XemTimChitiet.class);
                    intent.putExtra("loaiphong",loaiphong);
                    intent.putExtra("khuvuc",khuvuc);
                    intent.putExtra("mucgia",mucgia);
                    intent.putExtra("dientich",dientich);
                    startActivity(intent);
                }else if (spinner3.getSelectedItem().toString().equals("Dưới 1.500.000VND")
                        && spinner4.getSelectedItem().toString().equals("> 50m²")){

                    ////1.3

                    String loaiphong=spinner1.getSelectedItem().toString();
                    String khuvuc=spinner2.getSelectedItem().toString();
                    String mucgia="1200000";
                    String dientich="55";
                    Intent intent=new Intent(TimChiTietActivity.this,XemTimChitiet.class);
                    intent.putExtra("loaiphong",loaiphong);
                    intent.putExtra("khuvuc",khuvuc);
                    intent.putExtra("mucgia",mucgia);
                    intent.putExtra("dientich",dientich);
                    startActivity(intent);


                }else if (spinner3.getSelectedItem().toString().equals("1.500.000 - 3.000.000VND")
                        && spinner4.getSelectedItem().toString().equals("20 - 30m²")){
                    ////2.1

                    String loaiphong=spinner1.getSelectedItem().toString();
                    String khuvuc=spinner2.getSelectedItem().toString();
                    String mucgia="2000000";
                    String dientich="25";
                    Intent intent=new Intent(TimChiTietActivity.this,XemTimChitiet.class);
                    intent.putExtra("loaiphong",loaiphong);
                    intent.putExtra("khuvuc",khuvuc);
                    intent.putExtra("mucgia",mucgia);
                    intent.putExtra("dientich",dientich);

                    startActivity(intent);

                }else if (spinner3.getSelectedItem().toString().equals("1.500.000 - 3.000.000VND")
                        && spinner4.getSelectedItem().toString().equals("30 - 50m²")){

                    ////2.2

                    String loaiphong=spinner1.getSelectedItem().toString();
                    String khuvuc=spinner2.getSelectedItem().toString();
                    String mucgia="2000000";
                    String dientich="35";
                    Intent intent=new Intent(TimChiTietActivity.this,XemTimChitiet.class);
                    intent.putExtra("loaiphong",loaiphong);
                    intent.putExtra("khuvuc",khuvuc);
                    intent.putExtra("mucgia",mucgia);
                    intent.putExtra("dientich",dientich);

                    startActivity(intent);
                }else if (spinner3.getSelectedItem().toString().equals("1.500.000 - 3.000.000VND")
                        && spinner4.getSelectedItem().toString().equals("> 50m²")){
                    ////2.3

                    String loaiphong=spinner1.getSelectedItem().toString();
                    String khuvuc=spinner2.getSelectedItem().toString();
                    String mucgia="2000000";
                    String dientich="55";
                    Intent intent=new Intent(TimChiTietActivity.this,XemTimChitiet.class);
                    intent.putExtra("loaiphong",loaiphong);
                    intent.putExtra("khuvuc",khuvuc);
                    intent.putExtra("mucgia",mucgia);
                    intent.putExtra("dientich",dientich);

                    startActivity(intent);

                }else if (spinner3.getSelectedItem().toString().equals("Trên 3.000.000VND")
                        && spinner4.getSelectedItem().toString().equals("20 - 30m²")){
                    ////3.1

                    String loaiphong=spinner1.getSelectedItem().toString();
                    String khuvuc=spinner2.getSelectedItem().toString();
                    String mucgia="3500000";
                    String dientich="25";
                    Intent intent=new Intent(TimChiTietActivity.this,XemTimChitiet.class);
                    intent.putExtra("loaiphong",loaiphong);
                    intent.putExtra("khuvuc",khuvuc);
                    intent.putExtra("mucgia",mucgia);
                    intent.putExtra("dientich",dientich);
                    startActivity(intent);

                }else if (spinner3.getSelectedItem().toString().equals("Trên 3.000.000VND")
                        && spinner4.getSelectedItem().toString().equals("30 - 50m²")){
                    //3.2

                    String loaiphong=spinner1.getSelectedItem().toString();
                    String khuvuc=spinner2.getSelectedItem().toString();
                    String mucgia="3500000";
                    String dientich="35";
                    Intent intent=new Intent(TimChiTietActivity.this,XemTimChitiet.class);
                    intent.putExtra("loaiphong",loaiphong);
                    intent.putExtra("khuvuc",khuvuc);
                    intent.putExtra("mucgia",mucgia);
                    intent.putExtra("dientich",dientich);
                    startActivity(intent);

                }else if (spinner3.getSelectedItem().toString().equals("Trên 3.000.000VND")
                        && spinner4.getSelectedItem().toString().equals("> 50m²")){
                    ///3.3
                    String loaiphong=spinner1.getSelectedItem().toString();
                    String khuvuc=spinner2.getSelectedItem().toString();
                    String mucgia="3500000";
                    String dientich="55";
                    Intent intent=new Intent(TimChiTietActivity.this,XemTimChitiet.class);
                    intent.putExtra("loaiphong",loaiphong);
                    intent.putExtra("khuvuc",khuvuc);
                    intent.putExtra("mucgia",mucgia);
                    intent.putExtra("dientich",dientich);
                    startActivity(intent);

                }

            }
        });

//        String loaiphong=spinner1.getSelectedItem().toString();
//        String khuvuc=spinner2.getSelectedItem().toString();
//        String mucgia=spinner3.getSelectedItem().toString();
//        String  dientich=spinner4.getSelectedItem().toString();
//        Intent intent=new Intent(TimChiTietActivity.this,XemTimChitiet.class);
//        intent.putExtra("loaiphong",loaiphong);
//        intent.putExtra("khuvuc",khuvuc);
//        intent.putExtra("mucgia",mucgia);
//        intent.putExtra("dientich",dientich);
//
//        startActivity(intent);



    }
}