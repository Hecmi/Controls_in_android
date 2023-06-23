package com.example.controls_in_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText txtCedula;
    EditText txtNombre;
    EditText txtFechaNac;
    EditText txtCiudad;
    RadioGroup rgGenero;
    RadioButton rbMasculino;
    EditText txtCorreo;
    EditText txtTelefono;

    TextView txtError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtener los componentes de la actividad principal:
        txtCedula = (EditText)findViewById(R.id.txtCedula);
        txtNombre = (EditText)findViewById(R.id.txtNombres);
        txtFechaNac = (EditText)findViewById(R.id.txtFechaNac);
        txtCiudad = (EditText)findViewById(R.id.txtCiudad);
        rgGenero = (RadioGroup)findViewById(R.id.rgGenero);
        rbMasculino = (RadioButton)findViewById(R.id.rbMasculino);
        txtCorreo = (EditText)findViewById(R.id.txtEmail);
        txtTelefono = (EditText)findViewById(R.id.txtTelefono);

        txtError = (TextView) findViewById(R.id.txtError);
    }

    public boolean validar_datos(){
        String cedula = txtCedula.getText().toString();
        String nombre = txtNombre.getText().toString();
        String fechaNac = txtFechaNac.getText().toString();
        String ciudad = txtCiudad.getText().toString();
        String correo = txtCorreo.getText().toString();
        String telefono = txtTelefono.getText().toString();

        //Obtener el id del checkbox activado: -1 si no hay ninguno activado
        int id_check_selected = rgGenero.getCheckedRadioButtonId();

        if(cedula.isEmpty()){
            txtError.setText("Ingrese su número de cédula.");
            return false;
        }
        if(cedula.length() < 10){
            txtError.setText("Número de cédla inválido.");
            return false;
        }
        if(nombre.isEmpty()){
            txtError.setText("Ingrese su nombre.");
            return false;
        }

        String regex_fechaNac = "^(.+)/(.+)/(.+)$";
        Pattern pattern = Pattern.compile(regex_fechaNac);

        if(!pattern.matcher(fechaNac).matches()){
            txtError.setText("Fecha de nacimiento inválida.");
            return false;
        }
        if(fechaNac.isEmpty()){
            txtError.setText("Ingrese su fecha de nacimiento.");
            return false;
        }
        if(ciudad.isEmpty()){
            txtError.setText("Ingrese la ciudad en la que reside.");
            return false;
        }
        if(id_check_selected == -1){
            txtError.setText("Seleccione su género.");
            return false;
        }

        //Validaciones para el email:
        String regex_email = "^(.+)@(.+)$";
        pattern = Pattern.compile(regex_email);

        if(!pattern.matcher(correo).matches()){
            txtError.setText("Correo electrónico inválido.");
            return false;
        }
        if(correo.isEmpty()){
            txtError.setText("Ingrese su correo electrónico.");
            return false;
        }
        if(correo.isEmpty()){
            txtError.setText("Ingrese su correo electrónico.");
            return false;
        }


        if(telefono.isEmpty()){
            txtError.setText("Ingrese su número de teléfono.");
            return false;
        }
        if(telefono.length() < 10){
            txtError.setText("Número de teléfono inválido.");
            return false;
        }

        return true;
    }
    public void Enviar_datos(View view){
        //Si hay un error en la validación de los datos retornar.
        if(validar_datos()){
            //Almacenar los campos en el Bundle:
            Bundle b = new Bundle();
            b.putString("CEDULA", txtCedula.getText().toString());
            b.putString("NOMBRES", txtNombre.getText().toString());
            b.putString("FECHA_NAC", txtFechaNac.getText().toString());
            b.putString("CIUDAD", txtCiudad.getText().toString());
            b.putString("GENERO", rbMasculino.isChecked() ? "Masculino": "Femenino");
            b.putString("CORREO", txtCorreo.getText().toString());
            b.putString("TELEFONO", txtTelefono.getText().toString());

            //Crear intent para llamar a la segunda activida, donde se mostrarán los datos:
            Intent intent = new Intent(MainActivity.this, DatosActivity.class);
            intent.putExtras(b);

            startActivity(intent);
        }
    }

    public void Limpiar_datos(View view){
        txtCedula.setText("");
        txtNombre.setText("");
        txtFechaNac.setText("");
        txtCiudad.setText("");
        rgGenero.clearCheck();
        txtCorreo.setText("");
        txtTelefono.setText("");
    }
}