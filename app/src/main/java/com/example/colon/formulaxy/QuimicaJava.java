package com.example.colon.formulaxy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class QuimicaJava extends AppCompatActivity {

    //Variables Globales
    MainActivity ma = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boton_quimica);
    }

    //Botones de los diferentes temas
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBoton21:
                ma.pasarInfo(view);
                ma.leer("ruta");
                break;
            case R.id.btnBoton22:
                ma.pasarInfo(view);
                ma.leer("ruta");
                break;
            case R.id.btnBoton23:
                ma.pasarInfo(view);
                ma.leer("ruta");
                break;
            case R.id.btnBoton24:
                ma.pasarInfo(view);
                ma.leer("ruta");
                break;
            case R.id.btnBoton25:
                ma.pasarInfo(view);
                ma.leer("ruta");
                break;
            case R.id.btnBoton26:
                ma.pasarInfo(view);
                ma.leer("ruta");
                break;
        }
    }
}