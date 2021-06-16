package com.example.jadwalsholat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jadwalsholat.api.ApiService;
import com.example.jadwalsholat.api.ApiUrl;
import com.example.jadwalsholat.model.Times;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView js_lokasi;
    private TextView js_subuh, js_dzuhur, js_ashar, js_maghrib, js_isya;
    private FloatingActionButton js_refresh_button;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Jadwal Sholat Indonesia");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        js_lokasi = findViewById(R.id.js_lokasi);
        js_subuh = findViewById(R.id.js_subuh);
        js_dzuhur = findViewById(R.id.js_dzuhur);
        js_ashar = findViewById(R.id.js_ashar);
        js_maghrib = findViewById(R.id.js_maghrib);
        js_isya = findViewById(R.id.js_isya);
        js_refresh_button = findViewById(R.id.js_refresh_button);

        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Mohon menunggu");
        progressDialog.show();

        getJackal();

       js_refresh_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog =new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Mohon ditunggu");
                progressDialog.show();

                getJackal();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (id==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void getJackal(){
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Please Wait / Silahkan tunggu ...");
        progressDialog.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.URL_ROOT_HTTPS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<Times> call = apiService.getJadwal();

        call.enqueue(new Callback<Times>(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Times> call, Response<Times> response){

            progressDialog.dismiss();

            if (response.isSuccessful()) {
                js_lokasi.setText(response.body().getLocation().get(0).getCity()+", "+response.body().getLocation().get(0).getCountry());
                js_subuh.setText(response.body().getFajr());
                js_dzuhur.setText(response.body().getDhuhr());
                js_ashar.setText(response.body().getAsr());
                js_maghrib.setText(response.body().getMaghrib());
                js_isya.setText(response.body().getIsha());
            }
            }

            @Override
            public void onFailure(Call<Times> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Sorry, please try again... server Down..", Toast.LENGTH_SHORT).show();
            }
    });
    }
}