package com.example.colon.formulaxy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PostQuimJava extends Fragment {

    private ListView listPostQuim;
    private ArrayAdapter<String> listViewAdapterPostQuim;

    public PostQuimJava() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_post_quim, container, false);
        String[] menuItems = {"Post Quimica 1",
                "Post Quimica 2",
                "Post Quimica 3",
                "Post Quimica 4",
                "Post Quimica 5",
                "Post Quimica 6",
                "Post Quimica 7",
                "Post Quimica 8",
                "Post Quimica 9",
                "Post Quimica 10" };

        listPostQuim = view.findViewById(R.id.mainPostFis);
        listViewAdapterPostQuim = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );
        listPostQuim.setAdapter(listViewAdapterPostQuim);

        return view;
    }
}
