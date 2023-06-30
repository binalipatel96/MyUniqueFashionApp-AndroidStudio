package com.example.myuniquefashionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderConfirmedActivity extends AppCompatActivity {

    Button backToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmed);

        backToHome = (Button) findViewById(R.id.backToHome);

        //action on clicking on the Back to home button
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the openProductActivity method
                openHomeActivity();
            }
        });

    }
    //working of openHomeActivity
    private void openHomeActivity() {
        //switches from HomeActivity to ProductActivity
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}