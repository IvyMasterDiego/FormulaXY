package com.example.colon.formulaxy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class PostMateJava extends Fragment {

    private ListView listPostMate;
    private ArrayAdapter<String> listViewAdapterPostMate;
    private ImageButton floatButtonMate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_post_mate, container, false);
        String[] menuItems = {"Post Mate 1",
                "Post Mate 2",
                "Post Mate 3",
                "Post Mate 4",
                "Post Mate 5",
                "Post Mate 6",
                "Post Mate 7",
                "Post Mate 8",
                "Post Mate 9",
                "Post Mate 10" };

        listPostMate = view.findViewById(R.id.mainPostMat);
        listViewAdapterPostMate = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems);
        listPostMate.setAdapter(listViewAdapterPostMate);

        floatButtonMate = view.findViewById(R.id.btnAgregarPostMate);
        floatButtonMate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PostCrearJava.class);
                startActivity(intent);
            }
        });
        return view;
    }
}