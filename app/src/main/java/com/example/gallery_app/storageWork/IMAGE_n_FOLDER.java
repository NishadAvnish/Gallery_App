package com.example.gallery_app.storageWork;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.example.gallery_app.RecyclerView.Databook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IMAGE_n_FOLDER {

    public Map<String, ArrayList<Databook>> imagesInFolderMap = new HashMap<>();
    public ArrayList<String> folderNameList=null;


    public void getImageFolderMap(Context appContext) {

        imagesInFolderMap.clear();

        String[] projection = {MediaStore.MediaColumns.DATA, MediaStore.Images.Media.BUCKET_DISPLAY_NAME};

        //Get all External Image Files
        fetchImagesInFolderCursor(appContext.getContentResolver()
                .query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        projection,
                        null,
                        null,
                        null));

        // Get all Internal images
        fetchImagesInFolderCursor(appContext.getContentResolver()
                .query(MediaStore.Images.Media.INTERNAL_CONTENT_URI,
                        projection,
                        null,
                        null,
                        null));

        //Get all folders Name from Map
        folderNameList =new ArrayList<>(imagesInFolderMap
                        .keySet());
    }

    private void fetchImagesInFolderCursor(Cursor imageFolderCursor) {
        int columnIndexData = imageFolderCursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        int columnIndexFolderName = imageFolderCursor.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);

        while (imageFolderCursor.moveToNext()) {

            String absolutePathOfImage = imageFolderCursor.getString(columnIndexData);
            String folderName = imageFolderCursor.getString(columnIndexFolderName);

            if (imagesInFolderMap.containsKey(folderName)) {

                //If folder is added then insert new Image Data into that folder
                      imagesInFolderMap.get(folderName).add(new Databook(folderName, absolutePathOfImage));

            } else {

                //if folder not added then create a new list
                ArrayList<Databook> listOfImagesInFolder = new ArrayList<Databook>();

                //insert image data in that list
                listOfImagesInFolder.add(new Databook(folderName, absolutePathOfImage));


                //add list into that folder

                imagesInFolderMap.put(folderName, listOfImagesInFolder);
            }
        }

        imageFolderCursor.close();
    }

}
