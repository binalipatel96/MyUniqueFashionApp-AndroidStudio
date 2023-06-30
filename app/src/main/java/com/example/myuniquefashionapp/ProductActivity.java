package com.example.myuniquefashionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //replace the product page with the ProductFragment
        getSupportFragmentManager().beginTransaction().replace(R.id.product_page,new ProductFragment()).commit();
    }
}