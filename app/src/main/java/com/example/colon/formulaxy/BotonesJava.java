package com.example.colon.formulaxy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BotonesJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.botones);
    }

    public void pasar1 (View view){
        Intent pasarLayout = new Intent(getApplicationContext(), InfoJava.class);
        startActivity(pasarLayout);
    }
}