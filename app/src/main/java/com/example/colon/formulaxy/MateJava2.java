package com.example.colon.formulaxy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MateJava2 extends Fragment {

    ListView listMat;
    ArrayAdapter<String> listViewAdapterMat;

    public MateJava2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Authenticate auth = new Authenticate("admin", "1234");
        auth.execute();
        while(auth.getToken() == null){
            continue;
        }
        /*FetchJSON fetcher = new FetchJSON(auth.getToken(), "groups");
        fetcher.execute();
        while(fetcher.getJson() == null){
            continue;
        }
        Log.d("token",fetcher.getJson().toString());*/
        JSONObject paquete = new JSONObject();
        try {
            paquete.put("code", "Diego Gay!");
            paquete.put("name", "test");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        DeleteJSON sender = new DeleteJSON(auth.getToken(), "groups/Diego Gay!");
        sender.execute();
        while(sender.getResp() == null){
            continue;
        }
        Log.d("SENDER",sender.getResp());
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