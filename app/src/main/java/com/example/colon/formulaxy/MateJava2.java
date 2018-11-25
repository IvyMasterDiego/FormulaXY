package com.example.colon.formulaxy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MateJava2 extends Fragment {

    ListView listMat;
    ArrayAdapter<String> listViewAdapterMat;

    public MateJava2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FetcherAPI fetcher = new FetcherAPI("http://13.58.197.240:5000/");
        ArrayList<String> data = fetcher.Authenticate("admin", "1234");
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
                "Matematica 10" };

        listMat = view.findViewById(R.id.mainMenuMat);
        listViewAdapterMat = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );
        listMat.setAdapter(listViewAdapterMat);
        return view;
    }
}