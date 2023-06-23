package com.example.controls_in_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        TextView txtDatosEnviados = (TextView)findViewById(R.id.txtDatosEnviados);

        Bundle b = this.getIntent().getExtras();

        txtDatosEnviados.setText(
                "Cédula: " + b.getString("CEDULA") + "\n" +
                "Nombres: " + b.getString("NOMBRES") + "\n" +
                "Fecha de Nacimiento: " + b.getString("CEDULA") + "\n" +
                "Ciudad: " + b.getString("CIUDAD") + "\n" +
                "Género: " + b.getString("GENERO") + "\n" +
                "Correo: " + b.getString("CORREO") + "\n" +
                "Teléfono: " + b.getString("TELEFONO")
        );


    }
}