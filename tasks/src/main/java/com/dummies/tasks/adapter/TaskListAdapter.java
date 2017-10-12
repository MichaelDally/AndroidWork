package com.dummies.tasks.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dummies.tasks.activity.R;
import com.dummies.tasks.interfaces.OnEditTask;
import com.squareup.picasso.Picasso;

public class TaskListAdapter
        extends RecyclerView.Adapter<TaskListAdapter.ViewHolder>
{
    static String[] fakeData = new String[]
            {"One",
                    "Two",
                    "Three",
                    "Four",
                    "Five",
                    "Yeaaah boi"};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_task, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int index) {
        final Context context = viewHolder.titleView.getContext();
        viewHolder.titleView.setText(fakeData[index]);

        //Set thumbnail
        Picasso.with(context)
                .load(getImageUrlForTask(index))
                .into(viewHolder.imageView);

        //Set the click action
        viewHolder.cardView.setOnClickListener(
                new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ((OnEditTask)context).editTask(index);
            }
        });

    }

    private static String getImageUrlForTask(long taskId) {
        return "http://lorempixel.com/600/400/cats/?fakeId="+taskId;
    }

    @Override
    public int getItemCount() {
        return fakeData.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView titleView;
        ImageView imageView;
        public ViewHolder(CardView card){
            super(card);
            cardView = card;
            titleView = card.findViewById(R.id.text1);
            imageView = (ImageView)card.findViewById(R.id.image);
        }
    }
}
