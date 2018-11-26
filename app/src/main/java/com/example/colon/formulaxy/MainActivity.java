package com.example.colon.formulaxy;

import android.app.ActionBar;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    InfoJava ij = new InfoJava();
    TextView tvParrafo = ij.tvParrafo;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Animacion del menu
        mDrawerLayout = findViewById(R.id.drawer);
        mToogle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToogle);
        NavigationView nvDrawer = findViewById(R.id.nv);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(nvDrawer);
    }

    //Animacion del Click
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToogle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Funcion de los botones
    public void selectItemDrawer(MenuItem menuItem){
        Fragment myFragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()){
            case R.id.item1:
                fragmentClass = HomeJava.class;
                break;
            case R.id.item2:
                fragmentClass = MateJava2.class;
                break;
            case R.id.item3:
                fragmentClass = FisicaJava2.class;
                break;
            case R.id.item4:
                fragmentClass = QuimicaJava2.class;
                break;
            case R.id.item5:
                fragmentClass = SettingsJava.class;
                break;
            default:
                fragmentClass = HomeJava.class;
        } try{
            myFragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        FragmentManager fragmentManager= getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent,myFragment).commit();
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawerLayout.closeDrawers();
    }

    private void setupDrawerContent (NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                selectItemDrawer(menuItem);
                return false;
            }
        });
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