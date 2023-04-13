package com.example.chips02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.chips02.databinding.ActivityMainBinding;
import com.google.android.material.chip.Chip;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final String TAG = "xxx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LayoutInflater inflater = MainActivity.this.getLayoutInflater();

        binding.btnCreate.setOnClickListener(v->{
            String text = String.valueOf(binding.textEdit.getText());
            String[] arr = text.split(" ");
            Log.d(TAG, Arrays.toString(arr));

            for(String i : arr){
                Chip chip = (Chip) inflater.inflate(R.layout.chip, null, false);
                chip.setText(i);
                chip.setOnCloseIconClickListener(vi -> {
                    binding.container.removeView(vi);
                });
                binding.container.addView(chip);
            }
        });

        binding.btnShow.setOnClickListener(v->{
            StringBuilder message = new StringBuilder();
            for (int i = 0; i < binding.container.getChildCount(); i++) {
                Chip chip = (Chip)binding.container.getChildAt(i);
                if (chip.isChecked()){
                    message.append(chip.getText()).append(" ");
                }
            }
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        });
    }
}