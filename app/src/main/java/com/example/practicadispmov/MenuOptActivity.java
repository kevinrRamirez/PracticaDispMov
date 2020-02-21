package com.example.practicadispmov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuOptActivity extends AppCompatActivity {

    Button gps, internt, camara, imagenes, creitos, atras, salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opt);

        gps = findViewById(R.id.btnMen_GPS);
        internt = findViewById(R.id.btnMen_Internet);
        camara = findViewById(R.id.btnMen_Camara);
        imagenes = findViewById(R.id.btnMen_Imagenes);
        creitos = findViewById(R.id.btnMen_Creditos);
        atras = findViewById(R.id.btnMen_Atras);
        salir = findViewById(R.id.btnMen_Salir);


    }

    public void Ogps(View v)
    {
        Intent intent = new Intent(v.getContext(), MapaActivity.class);
        startActivity(intent);
    }

    public void Ointernet(View v)
    {
        Intent intent = new Intent(v.getContext(), WevViewActivity.class);
        startActivity(intent);
    }

    public void Ocamara(View v)
    {
        Intent intent = new Intent(v.getContext(), CamaraActivity.class);
        startActivity(intent);
    }

    public void Oimagenes(View v)
    {
        Intent intent = new Intent(v.getContext(), ImagenesActivity.class);
        startActivity(intent);
    }

    public void Ocreditos(View v)
    {
        Intent intent = new Intent(v.getContext(), CreditosActivity.class);
        startActivity(intent);
    }

    public void atrasM(View v)
    {
        finish();
    }

    public void salirM(View v)
    {
        System.exit(0);
    }
}
