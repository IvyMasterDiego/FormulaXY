package com.example.colon.formulaxy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PostFisJava extends Fragment {

    private ListView listPostFis;
    private ArrayAdapter<String> listViewAdapterPostFis;

    public PostFisJava() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_post_fis, container, false);
        String[] menuItems = {"Post Fisica 1",
                "Post Fisica 2",
                "Post Fisica 3",
                "Post Fisica 4",
                "Post Fisica 5",
                "Post Fisica 6",
                "Post Fisica 7",
                "Post Fisica 8",
                "Post Fisica 9",
                "Post Fisica 10" };

        listPostFis = view.findViewById(R.id.mainPostFis);
        listViewAdapterPostFis = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );
        listPostFis.setAdapter(listViewAdapterPostFis);

        return view;
    }
}
