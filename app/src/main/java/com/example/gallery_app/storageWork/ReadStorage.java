package com.example.gallery_app.storageWork;

import android.net.Uri;
import android.os.Environment;

import com.example.gallery_app.Fragment.ImageFragment;
import com.example.gallery_app.RecyclerView.Databook;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

public class ReadStorage {

      public File root;
      public ArrayList<File>fileList=new ArrayList<>(2);

      public void imageFromExternal(){

          //Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS); for a specific directory
          // before using external check that external storage is present or not
          root= new File(Environment.getExternalStorageDirectory().getAbsolutePath());

          getFile(root);

      }


    public void imageFromInternal(){
        root= new File(Environment.getDataDirectory().getAbsolutePath());
        getFile(root);

    }

    public ArrayList<File> getFile(File dir) {
        File listFile[] = dir.listFiles();
        if (listFile != null && listFile.length > 0) {
            for (int i = 0; i < listFile.length; i++) {

                if (listFile[i].isDirectory()) {
                    fileList.add(listFile[i]);
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
                        new Databook(Uri.fromFile(listFile[i]),listFile[i].getName());
                    }
                }

            }
        }
        return fileList;
    }


}
