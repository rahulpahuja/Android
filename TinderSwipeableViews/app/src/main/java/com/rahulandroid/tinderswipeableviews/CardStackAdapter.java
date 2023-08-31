package com.rahulandroid.tinderswipeableviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter {

    List<ExamData> list = Collections.emptyList();
    Context context;
    ClickListener clickListener;

    public CardStackAdapter(List<ExamData> list,
                                Context context, ClickListener listiner)
    {
        this.list = list;
        this.context = context;
        this.clickListener = listiner;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View photoView = inflater.inflate(R.layout.exam_card, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        int index = position;
        MyViewHolder viewHolder1 = (MyViewHolder) (viewHolder);
        viewHolder1.examName.setText(list.get(position).name);
        viewHolder1.examDate.setText(list.get(position).date);
        viewHolder1.examMessage.setText(list.get(position).message);
        viewHolder1.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                clickListener.click(index);
            }
        });
    }
    @Override
    public int getItemCount() {return list.size();}

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView examName,examMessage,examDate;
        View view;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            examName = itemView.findViewById(R.id.examName);
            examDate = itemView.findViewById(R.id.examDate);
            examMessage =itemView.findViewById(R.id.examMessage);
            view  = itemView;
        }
    }
}
