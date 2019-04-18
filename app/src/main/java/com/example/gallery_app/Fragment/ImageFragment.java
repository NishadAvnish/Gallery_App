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
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gallery_app.R;
import com.example.gallery_app.RecyclerView.Adapter;
import com.example.gallery_app.RecyclerView.Databook;
import com.example.gallery_app.storageWork.ReadStorage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
        recyclerView= (RecyclerView) view.findViewById(R.id.imageRecyclerView);



        gridLayoutManager=new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        //Adapter=new Adapter(1,getFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath())),getContext());
        Adapter=new Adapter(1,getAllShownImagesPath(),getContext());
        recyclerView.setAdapter(Adapter);
        DividerItemDecoration dividerItemDecoration= new DividerItemDecoration(getContext(),HORIZONTAL);
        recyclerView.addItemDecoration(dividerItemDecoration);




    }

    private ArrayList<Databook> getAllShownImagesPath() {
        Uri uri;
        Cursor cursor;
        int column_index_data, column_index_folder_name;
        ArrayList<Databook> listOfAllImages = new ArrayList<Databook>();
        String absolutePathOfImage = null;
        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME};

        cursor = getContext().getContentResolver().query(uri, projection, null,
                null, null);

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        column_index_folder_name = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);
        while (cursor.moveToNext()) {
            absolutePathOfImage = cursor.getString(column_index_data);
            Log.i("TAG",absolutePathOfImage.getClass().getName());

            listOfAllImages.add(new Databook(absolutePathOfImage));
        }
        cursor.close();
        return listOfAllImages;
    }


   /* public ArrayList<Databook> getFile(File dir) {
        File listFile[] = dir.listFiles();
        ArrayList<Databook> arrayList=new ArrayList<>();
        if (listFile != null && listFile.length > 0) {
            for (int i = 0; i < listFile.length; i++) {

                if (listFile[i].isDirectory()) {
                    //fileList.add(listFile[i]);
                    getFile(listFile[i]);

                } else {
                    if (listFile[i].getName().endsWith(".png")
                            || listFile[i].getName().endsWith(".jpg")
                            || listFile[i].getName().endsWith(".jpeg")
                            || listFile[i].getName().endsWith(".gif")
                            || listFile[i].getName().endsWith(".JPG")
                            || listFile[i].getName().endsWith(".JPEG")
                            || listFile[i].getName().endsWith(".GIF"))

                    {   File file=listFile[i];
                            arrayList.add(new Databook(listFile[i].getAbsolutePath()));
                            Log.i("TAG",(listFile[i].getAbsolutePath()).getClass().getName());


                    }
                }

            }
        }
        return arrayList;
    }*/
}
