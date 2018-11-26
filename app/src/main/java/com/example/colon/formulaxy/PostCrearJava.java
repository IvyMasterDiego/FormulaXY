package com.example.colon.formulaxy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PostCrearJava extends AppCompatActivity {

    TextView texto;
    ImageButton floatButtonBack;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_post_crear);
        texto = findViewById(R.id.parrafoPost);
        floatButtonBack = findViewById(R.id.btnBack);

        floatButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeJava.class);
                startActivity(intent);
            }
        });
    }
}
