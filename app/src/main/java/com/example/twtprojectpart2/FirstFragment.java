package com.example.twtprojectpart2;


import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    ArrayList<Integer> imageCollection = new ArrayList<>();
//    images.add(android.R.drawable.ic_btn_speak_now);

//    private int[] icons = {android.R.drawable.ic_btn_speak_now, android.R.drawable.ic_delete,
//            android.R.drawable.ic_menu_upload, android.R.drawable.ic_dialog_info,
//            android.R.drawable.ic_delete, android.R.drawable.ic_btn_speak_now,
//            android.R.drawable.ic_dialog_info, android.R.drawable.ic_menu_upload
//    };

    RecyclerView recycler_view;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imageCollection.add(android.R.drawable.ic_btn_speak_now);
        imageCollection.add(android.R.drawable.ic_delete);
        imageCollection.add(android.R.drawable.ic_menu_upload);
        imageCollection.add(android.R.drawable.ic_dialog_info);
        imageCollection.add(android.R.drawable.ic_btn_speak_now);
        imageCollection.add(android.R.drawable.ic_delete);
        imageCollection.add(android.R.drawable.ic_menu_upload);
        imageCollection.add(android.R.drawable.ic_dialog_info);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        recycler_view = (RecyclerView)view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setHasFixedSize(true);

        recyclerViewAdapter = new RecyclerViewAdapter(imageCollection);
        recycler_view.setAdapter(recyclerViewAdapter);

        // add divider
        DividerItemDecoration divider = new DividerItemDecoration(getContext(), 1);
        recycler_view.addItemDecoration(divider);

        return view;
    }

}
