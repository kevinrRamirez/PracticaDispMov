package com.example.practicadispmov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DatosUsuarioActivity extends AppCompatActivity {



    TextView tvNombre, tvTelefono, tvEdad, tvNacio;
    Button atras, siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);

        String nombre, telefono, edad, nacionalidad;
        Bundle bundle = getIntent().getExtras();

        nombre = bundle.getString("nombre");
        edad = bundle.getString("edad");
        telefono = bundle.getString("telefono");
        nacionalidad = bundle.getString("nacio");

        tvNombre = findViewById(R.id.tvMD_Nombre);
        tvEdad = findViewById(R.id.tvMD_Edad);
        tvTelefono = findViewById(R.id.tvMD_Telefono);
        tvNacio = findViewById(R.id.tvMD_Nacionalidad);

        tvNombre.setText(nombre);
        tvEdad.setText(edad);
        tvTelefono.setText(telefono);
        tvNacio.setText(nacionalidad);

        atras = findViewById(R.id.btMD_Atras);
        siguiente = findViewById(R.id.btMD_Siguiente);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MenuOptActivity.class);
                startActivity(intent);

            }
        });

    }
}
