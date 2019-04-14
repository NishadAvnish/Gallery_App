package com.example.gallery_app.Fragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gallery_app.R;
import com.example.gallery_app.RecyclerView.Adapter;
import com.example.gallery_app.RecyclerView.Databook;

import java.util.ArrayList;

import static android.widget.GridLayout.HORIZONTAL;

public class ImageFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Databook> arrayList=new ArrayList<>();
    Adapter Adapter;
    GridLayoutManager gridLayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_imagefragment,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView= (RecyclerView) view.findViewById(R.id.imageRecyclerView);


        DividerItemDecoration dividerItemDecoration= new DividerItemDecoration(getContext(),HORIZONTAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        Adapter=new Adapter(1,arrayList,getContext());


        arrayList.add(new Databook(R.drawable.activ,"AVNISH"));
        arrayList.add(new Databook(R.drawable.activ,"AVNISH"));
        arrayList.add(new Databook(R.drawable.activ,"AVNISH"));
        arrayList.add(new Databook(R.drawable.activ,"AVNISH"));
        arrayList.add(new Databook(R.drawable.activ,"AVNISH"));
        arrayList.add(new Databook(R.drawable.activ,"AVNISH"));
        Adapter.notifyDataSetChanged();


        gridLayoutManager=new GridLayoutManager(getContext(),3);
        recyclerView.setAdapter(Adapter);
        recyclerView.setLayoutManager(gridLayoutManager);

    }



}
