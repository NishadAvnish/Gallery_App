package com.example.gallery_app.Fragment;


import java.util.ArrayList;

public class InnerModel {
    private String name;
    private ArrayList<outerModel> arrayList;

    public void setName(String name) {
        this.name = name;
    }

    public void setArrayList(ArrayList<outerModel> arrayList) {
        this.arrayList = arrayList;
    }

    public String getName() {
        return name;
    }

    public ArrayList<outerModel> getArrayList() {
        return arrayList;
    }

    public InnerModel(String name, ArrayList<outerModel> arrayList) {
        this.name = name;
        this.arrayList = arrayList;
    }
}
