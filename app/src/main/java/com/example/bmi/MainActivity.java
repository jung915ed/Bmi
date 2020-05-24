package com.example.bmi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editWeight;
    private EditText editHeight;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.main_linear);

        //add as fields
        findViews();
    }

    private void findViews() {
        editWeight = findViewById(R.id.edit_weight);
        editHeight = findViewById(R.id.edit_height);
        result = findViewById(R.id.result);
        Button help = findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.help)
                        .setMessage(R.string.bmi_info)
                        .setPositiveButton(R.string.ok, null)
                        .show();
            }
        });
    }

    //onClick event
    public void bmi(View view) {

        String w = editWeight.getText().toString();
        String h = editHeight.getText().toString();
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight / (height * height);
        //Log.d("MainActivity","BMI"+bmi);
        Toast.makeText(this, getString(R.string.ur_bmi_is) + bmi, Toast.LENGTH_LONG).show();
        result.setText(getString(R.string.ur_bmi_is) + bmi);
        new AlertDialog.Builder(this).setTitle("BMI").setMessage(getString(R.string.ur_bmi_is) + bmi)
                .setPositiveButton(getString(R.string.ok), (dialogInterface, i) -> {
                    editHeight.setText("");
                    editWeight.setText("");
                }).show();
    }
}