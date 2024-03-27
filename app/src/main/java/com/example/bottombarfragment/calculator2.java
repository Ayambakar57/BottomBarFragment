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

public class calculator2 extends AppCompatActivity {


    TextView bangunText2, hasilView2;
    EditText input2_1, input2_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculator2);
        Intent intent = getIntent();
        String shape = intent.getStringExtra("shape2");

        bangunText2 = findViewById(R.id.calculator_2parameter);
        input2_1 = findViewById(R.id.edittext2);
        input2_2 = findViewById(R.id.edittext3);
        hasilView2 = findViewById(R.id.Hasil_kakulator2);

        bangunText2.setText(shape);

        Button button1 = findViewById(R.id.confirm2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateArea2(shape);
            }
        });
    }

    private void calculateArea2(String shape) {
        String inputUser1 = input2_1.getText().toString();
        String inputUser2 = input2_2.getText().toString();
        if (!inputUser1.isEmpty() && !inputUser2.isEmpty()) {
            double number1 = Double.parseDouble(inputUser1);
            double number2 = Double.parseDouble(inputUser2);
            double area = 0;
            switch (shape) {
                case "Persegi panjang":
                    area = number1 * number2;
                    break;
                case "Segitiga":
                    area = 0.5 * number1 * number2;
                    break;
                case "Kerucut":
                    area = 3.14 * number1 * number1 * (number2 / 3);
                    break;
                case "Tabung":
                    area = 3.14 * number1 * number1 * number2;
                    break;
            }
            String resultArea = String.format("%.2f", area);
            hasilView2.setText("Area: " + resultArea);

        } else {
            hasilView2.setText("Masukkan Angka");
        }
    }
        }

