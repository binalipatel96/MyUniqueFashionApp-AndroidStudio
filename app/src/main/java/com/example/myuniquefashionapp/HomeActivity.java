package com.example.myuniquefashionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    RecyclerView categoryRecyclerView;

    private Button viewAllButton;
    ImageView imageView;

    //Creating String array for category name and int array for storing images
    String category_name[];
    int category_image[] = { R.drawable.men_category, R.drawable.women_category,R.drawable.kids_category,R.drawable.beauty_category};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //reference to image and button
        imageView = findViewById(R.id.banner_image);
        viewAllButton = (Button) findViewById(R.id.view_all_button);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.banner,options);
        imageView.setImageBitmap(bitmap);

        //action on clicking on the button
        viewAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the openProductActivity method
                openProductActivity();
            }
        });
        

        //reference to Recycler View for the Categories
        categoryRecyclerView = findViewById(R.id.category_recycler_view);

        //storing shopping_category array in category_name
        category_name = getResources().getStringArray(R.array.shopping_category);

        //creating object of CategoryAdapter class
        CategoryAdapter categoryAdapter =  new CategoryAdapter(this,category_name,category_image);
        categoryRecyclerView.setAdapter(categoryAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        categoryRecyclerView.setLayoutManager(layoutManager);
    }

    //working of openProductActivity
    private void openProductActivity() {
        //switches from HomeActivity to ProductActivity
        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);
    }
}