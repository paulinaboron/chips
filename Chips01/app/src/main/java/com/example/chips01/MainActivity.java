package com.example.chips01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.chips01.databinding.ActivityMainBinding;
import com.google.android.material.chip.Chip;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final String TAG = "xxx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.choiceGroup.setOnCheckedStateChangeListener((group, checkedIds) -> {
            for (int i = 0; i < group.getChildCount(); i++) {
                Chip chip = (Chip) group.getChildAt(i);
                chip.setOnCheckedChangeListener((compoundButton, b) -> {
                    Log.d("xxx", "change");
                });
                if (chip.isChecked()) { binding.tvChoice.setText(chip.getText());   }
            }
        });

        binding.filterGroup.setOnCheckedStateChangeListener((group, checkedIds) -> {

            binding.tvFilter.setText("");

            for (int i = 0; i < group.getChildCount(); i++) {
                Chip chip = (Chip) group.getChildAt(i);
                chip.setOnCheckedChangeListener((compoundButton, b) -> {
                    Log.d("xxx", "change");
                });
                if (chip.isChecked()) {
                    binding.tvFilter.append(chip.getText());
                }
            }

        });

        binding.entryGroup.setOnCheckedStateChangeListener((group, checkedIds) -> {

            binding.tvEntry.setText("");

            for (int i = 0; i < group.getChildCount(); i++) {
                Chip chip = (Chip) group.getChildAt(i);
                chip.setOnCheckedChangeListener((compoundButton, b) -> {
                    Log.d("xxx", "change");
                });
                chip.setOnCloseIconClickListener(group::removeView);
                if (chip.isChecked()) {
                    binding.tvEntry.append(chip.getText());
                }
            }

        });

    }
}