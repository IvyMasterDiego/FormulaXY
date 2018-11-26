package com.example.colon.formulaxy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MateJava2 extends Fragment {

    ListView listMat;
    ArrayAdapter<String> listViewAdapterMat;

    public MateJava2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Authenticate auth = new Authenticate("jose", "jose");
        auth.execute();
        while(auth.getToken() == null){
            continue;
        }
        FetchJSON fetch = new FetchJSON(auth.getToken(), "posts/JOSE/Matematicas");
        try {
            fetch.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d("results", fetch.getJson());
        JSONObject raw = new JSONObject();
        try {
            raw = new JSONObject(fetch.response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray posts = new JSONArray();
        try {
            posts = new JSONArray(raw.getString("posts"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            Log.d("Post 1:", posts.getJSONObject(0).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
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