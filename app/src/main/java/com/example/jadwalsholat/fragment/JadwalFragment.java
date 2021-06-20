package com.example.jadwalsholat.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jadwalsholat.JadwalSholatAdapter;
import com.example.jadwalsholat.MainActivity;
import com.example.jadwalsholat.R;
import com.example.jadwalsholat.model.Times;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class JadwalFragment extends Fragment {

    private JadwalSholatAdapter JadwalSholatAdapter;
    private RecyclerView recyclerView;
    private MainActivity mainActivity;


    public JadwalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        JadwalSholatAdapter = new JadwalSholatAdapter(getContext());
        JadwalSholatAdapter.notifyDataSetChanged();

        recyclerView = view.findViewById(R.id.js_subuh);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        mainActivity = new ViewModelProvider(this).get(MainActivity.class);
        mainActivity.setResult(getResult);
        try {
            mainActivity.getJackal();
        } catch (Exception e) {
            e.printStackTrace();
        }

        recyclerView.setAdapter(JadwalSholatAdapter);
    }

    private Observer<ArrayList<Times>> getResult = new Observer<ArrayList<Times>>() {
        @Override
        public void onChanged(ArrayList<Times> times) {
            if (times != null){
                JadwalSholatAdapter.setData(times);
            }
        }
    };
}

