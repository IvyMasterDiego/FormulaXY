package com.example.colon.formulaxy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class QuimicaJava2 extends Fragment {

    ListView listQui;
    ArrayAdapter<String> listViewAdapterQui;

    public QuimicaJava2() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_quimica2, container, false);
        String[] menuItems = {"Quimica 1",
                "Quimica 2",
                "Quimica 3",
                "Quimica 4",
                "Quimica 5",
                "Quimica 6",
                "Quimica 7",
                "Quimica 8",
                "Quimica 9",
                "Quimica 10" };

        listQui = view.findViewById(R.id.mainMenuQuim);
        listViewAdapterQui = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );
        listQui.setAdapter(listViewAdapterQui);
        return view;
    }
}