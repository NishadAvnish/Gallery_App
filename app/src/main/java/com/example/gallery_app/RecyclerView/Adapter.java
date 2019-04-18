package com.example.gallery_app.RecyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gallery_app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder>{
    Integer flag;
    ArrayList<Databook> arrayList=null;
    Context context;

    public Adapter(Integer flag, ArrayList<Databook> arrayList, Context context) {
        this.flag = flag;
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //
        //if(flag==1){
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragmnet_image_inflaterecycler,viewGroup,false);
        return new myViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.myViewHolder myViewHolder, int i) {

       // myViewHolder.gridText.setText(arrayList.get(i).getName());

        Glide.with(context)
                .load(arrayList.get(i).Path)
                .centerCrop()
                .placeholder(R.drawable.activ)
                .into(myViewHolder.gridImage);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class myViewHolder extends RecyclerView.ViewHolder{
        ImageView gridImage;
        TextView gridText;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            gridImage=itemView.findViewById(R.id.gridImage);
            gridText=itemView.findViewById(R.id.gridText);

        }
    }
}
