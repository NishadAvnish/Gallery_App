package com.example.gallery_app.Fragment;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.gallery_app.R;
import com.example.gallery_app.RecyclerView.Adapter;
import com.example.gallery_app.RecyclerView.Databook;
import com.example.gallery_app.storageWork.IMAGE_n_FOLDER;
import com.example.gallery_app.storageWork.ReadStorage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static android.view.View.inflate;
import static android.widget.GridLayout.HORIZONTAL;

public class ImageFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Databook> arrayList=new ArrayList<>();
    public Adapter Adapter;
    GridLayoutManager gridLayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_imagefragment,container,false);

    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView= view.findViewById(R.id.imageRecyclerView);

       /* View v= getLayoutInflater().inflate(R.layout.fragmnet_image_inflaterecycler, null);
        CardView cardView=v.findViewById(R.id.cardview);
        int viewWidth = recyclerView.getMeasuredWidth();
        float cardViewWidth = getActivity().getResources().getDimension(R.dimen.cardView);
        int newSpanCount = (int) Math.floor(viewWidth / cardViewWidth);
*/
        gridLayoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        //Adapter=new Adapter(1,getFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath())),getContext());
        IMAGE_n_FOLDER image_n_folder= new IMAGE_n_FOLDER();
        image_n_folder.getImageFolderMap(getContext());

        Adapter=new Adapter(1,image_n_folder.folderNameList,getContext());
        recyclerView.setAdapter(Adapter);
        /*DividerItemDecoration dividerItemDecoration= new DividerItemDecoration(getContext(),HORIZONTAL);
        recyclerView.addItemDecoration(dividerItemDecoration);*/




    }

}
