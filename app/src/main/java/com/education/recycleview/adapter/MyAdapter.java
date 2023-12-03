package com.education.recycleview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.education.recycleview.R;
import com.education.recycleview.UserDetails;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder> {

    private ArrayList<UserDetails> userdata;

    public MyAdapter(ArrayList<UserDetails> userdata) {
        this.userdata = userdata;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.list_item,parent,false);
        ItemViewHolder myItemViewHolder=new ItemViewHolder(view);
        return myItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
            final UserDetails userDetails= userdata.get(position);
            holder.userTextView.setText(userDetails.getUserName());
            holder.userImageView.setImageDrawable(userDetails.getUserpic());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),"click on item: "+userDetails.getUserName(),Toast.LENGTH_LONG).show();
                }
            });
    }

    @Override
    public int getItemCount() {
        return userdata.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
       public ImageView userImageView;
        public TextView userTextView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            userImageView=(ImageView) itemView.findViewById(R.id.imageView_iv);
            userTextView=(TextView) itemView.findViewById(R.id.headerTextView_tv);
        }
    }
}
