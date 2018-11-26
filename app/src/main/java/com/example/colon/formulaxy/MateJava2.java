package com.example.colon.formulaxy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MateJava2 extends Fragment {

    ListView listMat;
    ArrayAdapter<String> listViewAdapterMat;

    public MateJava2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_mate2, container, false);
        String[] menuItems = {"Matematica 1",
                "Matematica 2",
                "Matematica 3",
                "Matematica 4",
                "Matematica 5",
                "Matematica 6",
                "Matematica 7",
                "Matematica 8",
                "Matematica 9",
                "Matematica 10"};

        listMat = view.findViewById(R.id.mainMenuMat);
        listViewAdapterMat = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );
        listMat.setAdapter(listViewAdapterMat);

        listMat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item = position;
                String itemval = (String) listMat.getItemAtPosition(position);
                Toast.makeText(getContext(), "Position: " + item + " - Valor: " + itemval, Toast.LENGTH_LONG).show();
                Intent i = new Intent(getContext(), HomeJava.class); //
                startActivity(i);
            }
        });
        return view;
    }
}