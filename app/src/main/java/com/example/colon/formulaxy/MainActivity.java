package com.example.colon.formulaxy;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    InfoJava ij = new InfoJava();
    TextView tvParrafo = ij.tvParrafo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void passMate(View view) {
        Intent pasarLayout = new Intent(getApplicationContext(), MateJava.class);
        startActivity(pasarLayout);
    }

    public void passFisica(View view) {
        Intent pasarLayout = new Intent(getApplicationContext(), FisicaJava.class);
        startActivity(pasarLayout);
    }

    public void passQuimica(View view) {
        Intent pasarLayout = new Intent(getApplicationContext(), QuimicaJava.class);
        startActivity(pasarLayout);
    }

    public void pasarInfo(View view) {
        Intent pasarLayout = new Intent(getApplicationContext(), InfoJava.class);
        startActivity(pasarLayout);
    }

    //Botones de las diferentes materias
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFisica:
                passFisica(view);
                break;
            case R.id.btnMate:
                passMate(view);
                break;
            case R.id.btnQuimica:
                passQuimica(view);
                break;
        }
    }

    //Metodo para leer el texto
    public void leer(String archive) {
        AssetManager assetManager = getAssets();
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open(archive);
            String text = btoString(inputStream);
            tvParrafo.setText(text);
        } catch (IOException ex) {
            tvParrafo.setText(ex.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    tvParrafo.setText(ex.getMessage());
                }
            }
        }
    }

    //Convierte bytes en texto
    public String btoString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        byte[] bytes = new byte[4096];
        int len = 0;
        while ((len = inputStream.read(bytes)) > 0) {
            b.write(bytes, 0, len);
        }
        return new String(b.toByteArray(), "UTF8");
    }

    //Descarga de archivo
    //Mover para los layout de los botones y saber como hacer para que se descargue cada archivo individualmente por cada boton
    //Metodo con url como variable y un switch para los diferentes archivos
    public void UpdateDB(View view) {
        String url = "https://the-eye.eu/public/Books/Asimov/Isaac%20Asimov%20Foundation%20Collection/Foundation/Foundation%20-%20Isaac%20Asimov.epub";
        DownloadManager DManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        Uri addr = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(addr);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        Long RefId = DManager.enqueue(request);
    }
}