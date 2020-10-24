package com.rahul.mvvmjavaexample.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rahul.mvvmjavaexample.R;
import com.rahul.mvvmjavaexample.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private  List<NicePlace> places;
    private ArrayList<String> mImageNames;
    private ArrayList<String> mImages;
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> mImageNames, ArrayList<String> mImages, Context mContext) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mContext = mContext;
    }

    public RecyclerViewAdapter(List<NicePlace> placeList, Context mContext) {
        this.places =  placeList;
        this.mContext = mContext;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: ");
        if(places!=null){
            final NicePlace place = places.get(position);
            Glide.with(mContext).asBitmap().load(place.getImageUrl()).into(holder.imageView);
            holder.textViewImageName.setText(place.getTitle());
            holder.rlParentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick: "+place.getTitle());
                    Toast.makeText(mContext, "Clicked "+place.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }else if(places==null){
            Glide.with(mContext).asBitmap().load(mImages.get(position)).into(holder.imageView);
            holder.textViewImageName.setText(mImageNames.get(position));
            holder.rlParentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick: "+mImageNames.get(position));
                    Toast.makeText(mContext, "Clicked"+mImageNames.get(position), Toast.LENGTH_SHORT).show();
                }
            });
        }



    }

    @Override
    public int getItemCount() {
        if(places!=null) return places.size();
        else if(places==null) return  mImageNames.size();
        else return -1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageView;
        TextView textViewImageName;
        RelativeLayout rlParentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textViewImageName = itemView.findViewById(R.id.tv_image_name);
            rlParentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
