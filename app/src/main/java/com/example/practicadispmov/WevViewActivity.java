package com.example.practicadispmov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.google.android.gms.maps.MapView;

public class WevViewActivity extends AppCompatActivity {

    WebView wv;

    Button atras, siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wev_view);

        wv = findViewById(R.id.webView);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("https://www.google.com/");

        atras = findViewById(R.id.btnWB_Atras);
        siguiente = findViewById(R.id.btnWB_Siguiente);
    }

    public void atrasM (View v)
    {
        finish();
    }

    public void suguienteM (View v)
    {
        Intent intent = new Intent(v.getContext(), MapaActivity.class);
        startActivity(intent);
    }
}
