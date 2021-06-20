package com.example.jadwalsholat;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jadwalsholat.model.Location;
import com.example.jadwalsholat.model.Times;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class JadwalSholatAdapter extends RecyclerView.Adapter<JadwalSholatAdapter.ViewHolder> {

    private ArrayList<Location> location = new ArrayList<>();
    private Context context;

    private static String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w185/";

    public JadwalSholatAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<Times> items){
        location.clear();
        location.addAll(items);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public JadwalSholatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalSholatAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(BASE_IMAGE_URL+location.get(position)
                .getCity())
                .into((ImageView) holder.itemView);

        holder.js_lokasi.setText(location.get(position).getTimezone());
        holder.js_maghrib.setText(String.valueOf(location.get(position).getCountry()));

    }

    @Override
    public int getItemCount() {
        return location.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView js_lokasi;
        private TextView js_subuh, js_dzuhur, js_ashar, js_maghrib, js_isya;
        private FloatingActionButton js_refresh_button;

        public void setJs_ashar(TextView js_ashar) {
            this.js_ashar = js_ashar;
        }

        public void setJs_dzuhur(TextView js_dzuhur) {
            this.js_dzuhur = js_dzuhur;
        }

        public void setJs_isya(TextView js_isya) {
            this.js_isya = js_isya;
        }

        public void setJs_lokasi(TextView js_lokasi) {
            this.js_lokasi = js_lokasi;
        }

        public void setJs_subuh(TextView js_subuh) {
            this.js_subuh = js_subuh;
        }

        public void setJs_maghrib(TextView js_maghrib) {
            this.js_maghrib = js_maghrib;
        }

        public void setJs_refresh_button(FloatingActionButton js_refresh_button) {
            this.js_refresh_button = js_refresh_button;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            js_lokasi = itemView.findViewById(R.id.js_lokasi);
            js_subuh = itemView.findViewById(R.id.js_subuh);
            js_dzuhur = itemView.findViewById(R.id.js_dzuhur);
            js_ashar = itemView.findViewById(R.id.js_ashar);
            js_maghrib = itemView.findViewById(R.id.js_maghrib);
            js_isya = itemView.findViewById(R.id.js_isya);
        }
    }
}