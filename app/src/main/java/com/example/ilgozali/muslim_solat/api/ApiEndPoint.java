package com.example.ilgozali.muslim_solat.api;

import com.example.ilgozali.muslim_solat.response.JadwalSalatRespont;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndPoint {
    @GET("bekasi.json")
        //untuk memanggil variabelnya
    Call<JadwalSalatRespont> getJadwalSalat(@Query("key") String key);

    @GET("jakart.json")
    Call<JadwalSalatRespont> getJadwalSolatJakarta(@Query("key") String key);
}
