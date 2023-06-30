package com.example.myuniquefashionapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    String categoryNames[];
    int categoryImages[];
    Context context;

    public CategoryAdapter(Context ct, String categoryName[], int categoryImage[]) {
        context = ct;
        categoryNames = categoryName;
        categoryImages = categoryImage;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Instantiate a layout xml file into its corresponding View object
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.category_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.categoryName.setText(categoryNames[position]);
        holder.categoryImage.setImageResource(categoryImages[position]);
    }

    @Override
    public int getItemCount() {
        return categoryImages.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.category_name);
            categoryImage = itemView.findViewById(R.id.category_image);
        }
    }
}
