package com.education.recycleview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.education.model.ProductDetails;
import com.education.recycleview.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder> {

    private List<ProductDetails> productDetails;

    public MyAdapter(List<ProductDetails> productDetails) {
        this.productDetails = productDetails;
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
            final ProductDetails productDetails= this.productDetails.get(position);
            holder.bindItem(productDetails);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),"click on item: "+productDetails.getTitle(),Toast.LENGTH_LONG).show();
                }
            });
    }

    @Override
    public int getItemCount() {
        return productDetails.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
       public ImageView userImageView;
        public TextView userTextView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            userImageView=(ImageView) itemView.findViewById(R.id.coverImage);
            userTextView=(TextView) itemView.findViewById(R.id.title);

        }

        void bindItem(ProductDetails productDetails){
            userTextView.setText(productDetails.getTitle());
            Glide.with(itemView.getContext())
                    .load(productDetails.geturl())
                    .placeholder(R.drawable.baseline_person_3_24) // Add a placeholder image
                    .error(R.drawable.baseline_person_3_24) // Add an error image
                    .into(userImageView);

        }
    }
}
