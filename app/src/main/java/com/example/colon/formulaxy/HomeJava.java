package com.example.colon.formulaxy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeJava extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_home, container, false);
        Intent abrirPST = new Intent(getActivity(), PostCrearJava.class);
        startActivity(abrirPST);
        return view;
    }
}