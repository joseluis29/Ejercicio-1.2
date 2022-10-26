package com.example.ejercicio12;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nombre, apellido, edad, correo;
    Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enviar = findViewById(R.id.btnEnviar);

        enviar.setOnClickListener(this::onClick);
    }

    private void onClick(View v) {
        extract_data();
        if (empty_field(nombre)) message("Debe ingresar su nombre");
        else if (empty_field(apellido)) message("Debe ingresar su apellido");
        else if (empty_field(correo)) message("Debe ingresar su correo");
        else if (empty_field(edad)) message("Debe ingresar su edad");
        else next_view();
    }

    protected void next_view(){
        Intent panel = new Intent(getApplicationContext(), Inform.class);
        panel.putExtra("nombre", nombre.getText().toString());
        panel.putExtra("apellido", apellido.getText().toString());
        panel.putExtra("correo", correo.getText().toString());
        panel.putExtra("edad", edad.getText().toString());
        startActivity(panel);
    }

    protected boolean empty_field(EditText object){
        if (object.getText().toString().length() < 1) return true;
        else return false;
    }

    protected void message(String message){
        Toast.makeText(this, message, LENGTH_SHORT).show();
    }

    protected void extract_data(){
        this.nombre = findViewById(R.id.txtNombre);
        this.apellido = findViewById(R.id.txtApellido);
        this.edad = findViewById(R.id.txtEdad);
        this.correo = findViewById(R.id.txtCorreo);
    }
}