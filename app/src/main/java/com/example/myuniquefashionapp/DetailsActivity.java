package com.example.myuniquefashionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    ImageView productImage;
    TextView productName, productDesc, productPrice;
    Button backBtn, checkOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //reference for all the text view and image view in activity_details
        productImage = findViewById(R.id.productImage);
        productName = findViewById(R.id.brandName);
        productDesc = findViewById(R.id.productDesc);
        productPrice = findViewById(R.id.productPrice);

        //reference for button
        backBtn = findViewById(R.id.backBtnToDetails);
        checkOutBtn = findViewById(R.id.checkOutBtn);

        Intent intent = getIntent();

        productImage.setImageResource(intent.getIntExtra("productimage",0));
        productName.setText(intent.getStringExtra("productname"));
        productDesc.setText(intent.getStringExtra("productdesc"));
        productPrice.setText(intent.getStringExtra("productprice"));

        //action performed on clicking back button
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickBackButton();
            }
        });

        //action performed on clicking Check Out button
        checkOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickCheckOutButton();
            }
        });

    }
    //working of onClickBackButton
    private void onClickBackButton() {
        //switches from HomeActivity to ProductActivity
        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);
    }

    //working of onClickBackButton
    private void onClickCheckOutButton() {
        //switches from HomeActivity to ProductActivity
        Intent intent = new Intent(this, CheckOutActivity.class);
        startActivity(intent);
    }
}