package com.example.bottombarfragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class calculator1 extends AppCompatActivity {

    TextView bangunText, hasilView;
    EditText input1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator1);

        bangunText = findViewById(R.id.calculator_1parameter);
        input1 = findViewById(R.id.edittext1);
        hasilView = findViewById(R.id.Hasil_kakulator1);


        Intent intent = getIntent();
        String shape = intent.getStringExtra("shape1");

        bangunText.setText(shape);

        Button button1 = findViewById(R.id.confirm1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateArea1(shape);
            }
        });
    }

    private void calculateArea1(String shape) {
        String inputUser = input1.getText().toString();
        if (!inputUser.isEmpty()) {
            double number = Double.parseDouble(inputUser);
            double area = 0;
            switch (shape) {
                case "Persegi":
                    area = number * number;
                    break;
                case "Lingkaran":
                    area = 3.14 * number * number;
                    break;
                case "Kubus":
                    area = number * number * number;
                    break;
                case "Bola":
                    area = ((double) 4 / 3) * 3.14 * number * number * number;
                    break;
            }
            String resultArea = String.format("%.2f", area);
            hasilView.setText("Area: " + resultArea);

        } else {
            hasilView.setText("Masukkan Angka");
        }
    }
    }

