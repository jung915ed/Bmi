package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView result = findViewById(R.id.result_bmi);
        float bmi = getIntent().getFloatExtra("BMI", 0);
        result.setText(getString(R.string.ur_bmi_is) + bmi);
    }
}