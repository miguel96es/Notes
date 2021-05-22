package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //poner el icono en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

    }

    //Metodo iniciar sesion
    public void Iniciar (View view){
        Intent iniciar = new Intent(this, AppActivity.class);
        startActivity(iniciar);
    }

    //metodo boton registrate
    public void Registrate (View view){
        Intent registrate = new Intent(this, RegisterActivity.class);
        startActivity(registrate);
    }
}