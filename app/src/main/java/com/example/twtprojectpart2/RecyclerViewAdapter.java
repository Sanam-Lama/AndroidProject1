package com.example.twtprojectpart2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Random;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>{

    ArrayList<Integer> imageCollection;

    public RecyclerViewAdapter(ArrayList<Integer> imageCollection) {
        this.imageCollection = imageCollection;
    }

    public static ArrayList<ObjectClass> icon_objects = new ArrayList<>();
    private Context context;
    private int number = 0;

    public RecyclerViewAdapter (Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder( ViewGroup parent, int i) {

        View view = null;
        Random random = new Random();
        random.nextInt(2);

        if (number == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_left, parent,false);
            number = 1;
        }
        else if (number == 1) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_right, parent,false);
            number = 0;
        }
       // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_first, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);

       // icon_objects.add(android.R.drawable.ic_btn_speak_now);




        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, final int position) {
        int image_id = imageCollection.get(position);
        viewHolder.image_view.setImageResource(image_id);
        viewHolder.title.setText("Row Title " + position);
        viewHolder.subTitle.setText("Row SubTitle " + position);


        // Glide provides flexibility in image loading by providing support for many sources like remote URLs, local file system etc.
//        Glide.with(context)
//                .asBitmap()
//                .load(imageCollection.get(position))
//                .into(viewHolder.image_view);



        viewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailsActivity.class);

                //  Log.e("print", "INSIDE THE CLICK INTENT");
                Log.e("print", imageCollection.get(position).toString());
                intent.putExtra("myCustomObject", imageCollection.get(position) );
                intent.putExtra("myTitleObject", position);
                intent.putExtra("mySubtitleObject", position);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imageCollection.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView image_view;
        TextView title, subTitle;
        RelativeLayout parent_layout;

        public RecyclerViewHolder(@NonNull final View itemView) {
            super(itemView);

            image_view = (ImageView)itemView.findViewById(R.id.imageView);
            title = (TextView)itemView.findViewById(R.id.title);
            subTitle = (TextView)itemView.findViewById(R.id.subtitle);
            parent_layout = (RelativeLayout)itemView.findViewById(R.id.parentLayout);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(), DetailsActivity.class);
//
//                  //  Log.e("print", "INSIDE THE CLICK INTENT");
//                    intent.putExtra("myCustomObject", imageCollection.get() );
//                    v.getContext().startActivity(intent);
//                }
//            });
        }
    }
}
