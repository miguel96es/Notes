package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //poner el icono en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    //Metodo registrarse
    public void Registrarse (View view){
        Intent registarse = new Intent(this, AppActivity.class);
        startActivity(registarse);
    }
    //Metodo iniciar sesion
    public void Iniciar (View view){
        Intent iniciar = new Intent(this,AppActivity.class);
        startActivity(iniciar);
    }
}