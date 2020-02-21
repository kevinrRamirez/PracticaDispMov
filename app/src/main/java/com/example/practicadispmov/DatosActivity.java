package com.example.practicadispmov;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class DatosActivity extends AppCompatActivity implements View.OnClickListener {

    Button fecha, limpiar, siguiente;
    TextView nombre, fechat, telefono;
    Spinner nacionalidad;
    RadioButton hombre, mujer;
    int dia , mes, anio;
    String edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        fecha = findViewById(R.id.btnEdad);
        limpiar = findViewById(R.id.btnD_Limpiar);
        siguiente = findViewById(R.id.btnD_Siguiente);

        nombre = findViewById(R.id.etD_Nombre);
        fechat = findViewById(R.id.et_EdadFecha);
        telefono = findViewById(R.id.etD_Telefono);

        nacionalidad = findViewById(R.id.spinner_Nacio);

        hombre = findViewById(R.id.rbtn_Hombre);
        mujer = findViewById(R.id.rbtn_Mujer);

        //final String nacional = seleccionaItem();

        fecha.setOnClickListener(this);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(nombre.getText().toString().trim().equals(""))
                {
                    Toast toast = Toast.makeText(v.getContext(),"No hay nombre", Toast.LENGTH_SHORT);
                    toast.show();
                }else if (telefono.getText().toString().trim().equals(""))
                {
                    Toast toast = Toast.makeText(v.getContext(),"No hay telefono", Toast.LENGTH_SHORT);
                    toast.show();
                }else
                {

                    Intent intent = new Intent(v.getContext(), DatosUsuarioActivity.class);
                    intent.putExtra("edad",edad);
                    intent.putExtra("nombre",nombre.getText().toString());
                    intent.putExtra("telefono",telefono.getText().toString());
                    intent.putExtra("nacio", seleccionaItem());

                    Toast toast = Toast.makeText(v.getContext(),"Datos Capturados", Toast.LENGTH_SHORT);
                    toast.show();
                    startActivity(intent);
                }



                //seleccionaItem(v);
            }
        });

        String [] nacionalidades = {"Mexicano", "Brasilenio", "Peruano", "Aleman"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nacionalidades);
        nacionalidad.setAdapter(adapter);

       // nacionalidad.setOnItemClickListener(this);


    }

    @Override
    public void onClick(View v) {

        final Calendar calendar = Calendar.getInstance();
        if(v == fecha) {
            dia = calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            anio = calendar.get(Calendar.YEAR);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    int month1 =month;
                    int month2 = month1;

                    edad = getAge(year,month,dayOfMonth);
                    fechat.setText(dayOfMonth + "/ 0" + (month2+1) + "/" + year );

                }
            }, anio, mes, dia);
            datePickerDialog.show();
        }

    }
/*
    public void siguienteMetodo(View v)
    {
        Intent intent = new Intent(v.getContext(), DatosUsuarioActivity.class);
        intent.putExtra("edad",edad);
        intent.putExtra("nombre",nombreT);
        intent.putExtra("telefono",telefonoT);
        intent.putExtra("nacio",nacional);

        Toast toast = Toast.makeText(v.getContext(),"Datos Capturados", Toast.LENGTH_SHORT);
        toast.show();

        startActivity(intent);
        seleccionaItem(v);
    }

 */

    private String getAge(int year, int month, int day)
    {
    Calendar dob = Calendar.getInstance();
    Calendar today = Calendar.getInstance();
    dob.set(year, month, day);
    int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
    if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){ age--; }
    Integer ageInt = new Integer(age);
    String ageS = ageInt.toString();
    return ageS;
    }



    public String seleccionaItem ()
    {
        String seleccion = nacionalidad.getSelectedItem().toString();
        String nac = "";

        if (seleccion.equals("Mexicano"))
        {

            Toast.makeText(this,"Es Mexicano",Toast.LENGTH_SHORT).show();
            nac = "Mexicano";

        }else if (seleccion.equals("Brasilenio"))
        {

            Toast.makeText(this,"Es Brasilenio",Toast.LENGTH_SHORT).show();
            nac = "Brasilenio";

        }else if (seleccion.equals("Peruano"))
        {

            Toast.makeText(this,"Es Peruano",Toast.LENGTH_SHORT).show();
            nac = "Peruano";

        }else if (seleccion.equals("Aleman"))
        {

            Toast.makeText(this,"Es Aleman",Toast.LENGTH_SHORT).show();
            nac = "Aleman";

        }
        return nac;
    }

    public void valida(View v)
    {

    }

    public  void limpiar(View v)
    {

        nombre.setText("");
        fechat.setText("");
        telefono.setText("");

    }
}
