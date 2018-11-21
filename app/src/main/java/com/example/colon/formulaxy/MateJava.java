package com.example.colon.formulaxy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MateJava extends AppCompatActivity {

    //Variables Globales
    MainActivity ma = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boton_mate);
    }

    //Botones de los diferentes temas
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBoton1:
                ma.pasarInfo(view);
                ma.leer("ruta");
                break;
            case R.id.btnBoton2:
                ma.pasarInfo(view);
                ma.leer("ruta");
                break;
            case R.id.btnBoton3:
                ma.pasarInfo(view);
                ma.leer("ruta");
                break;
            case R.id.btnBoton4:
                ma.pasarInfo(view);
                ma.leer("ruta");
                break;
            case R.id.btnBoton5:
                ma.pasarInfo(view);
                ma.leer("ruta");
                break;
            case R.id.btnBoton6:
                ma.pasarInfo(view);
                ma.leer("ruta");
                break;
        }
    }
}