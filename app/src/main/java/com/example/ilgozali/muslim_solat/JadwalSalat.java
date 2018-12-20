package com.example.ilgozali.muslim_solat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilgozali.muslim_solat.api.ApiClient;
import com.example.ilgozali.muslim_solat.api.ApiEndPoint;
import com.example.ilgozali.muslim_solat.response.Item;
import com.example.ilgozali.muslim_solat.response.JadwalSalatRespont;
import com.example.ilgozali.muslim_solat.response.TodayWeather;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalSalat extends AppCompatActivity {
    private static final String API_KEY = "abcd35aadff53bfdc038a9f42f8406c7";
    List<Item> JadwalSholat = new ArrayList<>();
    TodayWeather TodayWeaterDay = new TodayWeather();

    TextView bk_subuh,bk_duhur,bk_asar,bk_mahgrib,bk_isa,tanggal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_salat);
        bk_subuh = (TextView) findViewById(R.id.txsubuh);
        bk_duhur = (TextView) findViewById(R.id.txduhur);
        bk_asar = (TextView) findViewById(R.id.txashar);
        bk_mahgrib = (TextView) findViewById(R.id.txmagrib);
        bk_isa = (TextView) findViewById(R.id.txisa);
        tanggal = (TextView) findViewById(R.id.tv_tanggal);

loadJadwalSolat();
    }
    private void loadJadwalSolat(){
        ApiEndPoint apiEndPoint = ApiClient.getClient(this).create(ApiEndPoint.class);
        Call<JadwalSalatRespont> call = apiEndPoint.getJadwalSalat(API_KEY);
        call.enqueue(new Callback<JadwalSalatRespont>() {
            @Override
            public void onResponse(Call<JadwalSalatRespont> call, Response<JadwalSalatRespont> response) {
                //rumusan paten bukan kaleng2
                JadwalSalatRespont jadwalSalatRespont = response.body();
                if (jadwalSalatRespont != null) {
                    if (jadwalSalatRespont.getStatusValid() == 1) {
                        //ini untuk array tanda []
                        JadwalSholat.addAll(jadwalSalatRespont.getItems());
                        //ini untuk objeck tanda {}
                        TodayWeaterDay = jadwalSalatRespont.getTodayWeather();

                        Toast.makeText(JadwalSalat.this, "JadwalaSholat size : " + JadwalSholat.size(), Toast.LENGTH_SHORT).show();
                        for (Item item : JadwalSholat){
                            tanggal.setText(item.getDateFor());
                            bk_subuh.setText(item.getFajr());
                            bk_duhur.setText(item.getDhuhr());
                            bk_asar.setText(item.getAsr());
                            bk_mahgrib.setText(item.getMaghrib());
                            bk_isa.setText(item.getIsha());



                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<JadwalSalatRespont> call, Throwable t) {
                Toast.makeText(JadwalSalat.this, "Koneksi Gagal", Toast.LENGTH_SHORT).show();

            }
        });
}
}
