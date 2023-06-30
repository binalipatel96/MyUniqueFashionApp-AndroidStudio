package com.example.myuniquefashionapp;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    ArrayList<ProductModel> productModelArrayList;
    Context context;

    public ProductAdapter(Context context, ArrayList<ProductModel> productModelArrayList) {
        this.productModelArrayList = productModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_product,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.productImage.setImageResource(productModelArrayList.get(position).getProductImages());
        holder.productName.setText(productModelArrayList.get(position).getProductName());
        holder.productDesc.setText(productModelArrayList.get(position).getProductDesc());
        holder.productPrice.setText(productModelArrayList.get(position).getProductPrice());
    }

    @Override
    public int getItemCount() {
        return productModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView productImage;
        TextView productName, productDesc, productPrice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.product_name);
            productDesc = itemView.findViewById(R.id.product_desc);
            productPrice = itemView.findViewById(R.id.product_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("productname",productModelArrayList.get(getAdapterPosition()).getProductName());
                    intent.putExtra("productdesc",productModelArrayList.get(getAdapterPosition()).getProductDesc());
                    intent.putExtra("productprice",productModelArrayList.get(getAdapterPosition()).getProductPrice());
                    intent.putExtra("productimage",productModelArrayList.get(getAdapterPosition()).getProductImages());
                    context.startActivity(intent);
                }
            });
        }
    }
}
