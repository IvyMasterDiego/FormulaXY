package com.example.colon.formulaxy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class PostQuimJava extends Fragment {

    private ListView listPostQuim;
    private ArrayAdapter<String> listViewAdapterPostQuim;
    private ImageButton floatButtonQuim;

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

        listPostQuim = view.findViewById(R.id.mainPosQuim);
        listViewAdapterPostQuim = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems);
        listPostQuim.setAdapter(listViewAdapterPostQuim);

        floatButtonQuim = view.findViewById(R.id.btnAgregarPostQuim);
        floatButtonQuim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PostCrearJava.class);
                startActivity(intent);
            }
        });
        return view;
    }
}