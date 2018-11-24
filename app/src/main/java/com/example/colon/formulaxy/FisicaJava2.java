package com.example.colon.formulaxy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FisicaJava2 extends Fragment {

    ListView listFis;
    ArrayAdapter<String> listViewAdapterFis;

    public FisicaJava2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fisica2, container, false);
        String[] menuItems = {"Fisica 1",
                "Fisica 2",
                "Fisica 3",
                "Fisica 4",
                "Fisica 5",
                "Fisica 6",
                "Fisica 7",
                "Fisica 8",
                "Fisica 9",
                "Fisica 10" };

        listFis = view.findViewById(R.id.mainMenuFis);
        listViewAdapterFis = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );
        listFis.setAdapter(listViewAdapterFis);

        return view;
    }
}