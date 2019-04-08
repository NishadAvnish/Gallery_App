package com.example.gallery_app.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gallery_app.R;

import java.util.ArrayList;


public class ImageFragment extends Fragment {

    RecyclerView innerRecycle,outerRecycle;
    ArrayList<InnerModel>innerArrayList;
    ArrayList<outerModel>outerArrayList;
    LinearLayoutManager innerLayoutmanager,outerLayoutManager;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         Initialize();

         innerArrayList=new ArrayList<>();
         outerArrayList=new ArrayList<>();
         innerLayoutmanager= new LinearLayoutManager(getContext());
         outerLayoutManager=new LinearLayoutManager(getContext());
         innerRecycle.setLayoutManager(innerLayoutmanager);
         outerRecycle.setLayoutManager(outerLayoutManager);

         InnerAdapter innerAdapter= new InnerAdapter(getContext(),innerArrayList);




    }

    private void Initialize() {
        innerRecycle= getView().findViewById(R.id.innerRecyclerview);
        outerRecycle=getView().findViewById(R.id.outerrecyclerview);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image,container,false);

    }
}
