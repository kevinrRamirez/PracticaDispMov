package com.example.practicadispmov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ImagenesActivity extends AppCompatActivity{

    Button siguiente, atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes);

        siguiente = findViewById(R.id.btMD_Siguiente);
        atras = findViewById(R.id.btMD_Atras);


    }

    public void atras (View v)
    {
        finish();
    }

    public void siguiente(View v)
    {
        Intent intent = new Intent(v.getContext(),CamaraActivity.class);
        startActivity(intent);
    }


}
