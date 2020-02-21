package com.example.practicadispmov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button aceptar, cancelar;
    TextView nombre, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aceptar = findViewById(R.id.btnL_Aceptar);
        cancelar = findViewById(R.id.btnL_Cancelar);
        nombre = findViewById(R.id.et_Nombre);
        pass = findViewById(R.id.et_Contrasenia);


    }

    @Override
    public void onClick(View v) {
        Intent intent  = new Intent(this, DatosActivity.class);
        startActivity(intent);
    }

    public void valida(View v)
    {
        if (nombre.getText().toString().trim().equals("") || pass.getText().toString().trim().equals("") )
        {
            Toast toast = Toast.makeText(this, "Hay campos vacios", Toast.LENGTH_SHORT);
            toast.show();
        }else
        {
            Intent intent  = new Intent(this, DatosActivity.class);
            startActivity(intent);
        }
    }

    public void terminar(View v)
    {
        onDestroy();
    }



}
