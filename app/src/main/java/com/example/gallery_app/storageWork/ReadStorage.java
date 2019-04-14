package com.example.gallery_app.storageWork;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class ReadStorage {

      public File root;
      public ArrayList<File>fileList=new ArrayList<>(2);

      public ArrayList<File> imageFromExternal(){

          //Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS); for a specific directory
          // before using external check that external storage is present or not
          root= new File(Environment.getExternalStorageDirectory().getAbsolutePath());

          return getFile(root);

      }


    public ArrayList<File> imageFromInternal(){
        root= new File(Environment.getDataDirectory().getAbsolutePath());
        return getFile(root);

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
                            || listFile[i].getName().endsWith(".gif"))

                    {
                        fileList.add(listFile[i]);
                    }
                }

            }
        }
        return fileList;
    }


}
