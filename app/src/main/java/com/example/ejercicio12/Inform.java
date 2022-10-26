package com.example.ejercicio12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Inform extends AppCompatActivity {
    TextView name, surname, email, age;
    Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inform);
        name = findViewById(R.id.nombre);
        surname = findViewById(R.id.apellido);
        email = findViewById(R.id.correo);
        age = findViewById(R.id.edad);
        goBack = findViewById(R.id.btnRegresar);
        show();

        goBack.setOnClickListener(this::onClick);
    }

    private void onClick(View v) {
        Intent panel = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(panel);
    }

    protected void show(){
        name.setText(getIntent().getExtras().getString("nombre"));
        surname.setText(getIntent().getExtras().getString("apellido"));
        email.setText(getIntent().getExtras().getString("correo"));
        age.setText(getIntent().getExtras().getString("edad"));
    }
}