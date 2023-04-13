package com.example.chips03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.chips03.databinding.ActivityMainBinding;
import com.google.android.material.chip.Chip;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LayoutInflater inflater = MainActivity.this.getLayoutInflater();

        Call<List<User>> call = Service.getUserApi().getAllUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> list = response.body();
                Log.d("xxx", list.toString());

                for(User u: list){
                    Chip chip = (Chip) inflater.inflate(R.layout.chip, null, false);
                    chip.setText(u.getName());
                    chip.setOnCloseIconClickListener(vi -> {
                        binding.group.removeView(vi);
                    });
                    binding.group.addView(chip);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
}