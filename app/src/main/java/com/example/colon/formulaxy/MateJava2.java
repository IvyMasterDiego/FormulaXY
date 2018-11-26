package com.example.colon.formulaxy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

        FxyApi api = new FxyApi();
        api.login("jose", "jose");
        JSONArray posts = api.getPostByTopic("JOSE", "Fisica");
        try {
            Log.d("Results:", posts.getJSONObject(0).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        View view = inflater.inflate(R.layout.list_mate2, container, false);
        int menu_lenght = 1;
        if(posts.length() > 0){
            menu_lenght = posts.length();
        }
        String[] menuItems = new String[menu_lenght];

        for (int i =0; i < posts.length(); i++){
            Post pst = new Post();
            try {
                pst = pst.JsonToPost(posts.getJSONObject(i));
                menuItems[i] = pst.title;
                Log.d("title", pst.title);
            } catch (JSONException e) {
                Toast post_error = Toast.makeText(getActivity(), "Error cargando posts", Toast.LENGTH_SHORT);
                post_error.show();
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        for(int i =0; i < menuItems.length; i++){
            if(menuItems[i] == null)menuItems[i] = "No posts";
        }
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