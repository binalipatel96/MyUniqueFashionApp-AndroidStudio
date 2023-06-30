package com.example.myuniquefashionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CheckOutActivity extends AppCompatActivity {
    //initialization of EditText, RadioGroup ,Button and String
    EditText name, email, address, noOfItems;
    RadioGroup radioGroup;
    String emailPattern;
    Button backBtn, confirmOrderBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        //references for EditText, RadioGroup, Button
        name=(EditText) findViewById(R.id.name);
        email=(EditText) findViewById(R.id.email);
        address=(EditText) findViewById(R.id.address);
        noOfItems=(EditText) findViewById(R.id.quantity);
        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        backBtn = (Button) findViewById(R.id.backBtnToDetails);
        confirmOrderBtn = (Button) findViewById(R.id.confirmOrderBtn);

        //setting default borders in Input box
        name.setBackgroundResource(R.drawable.defaultborder);
        address.setBackgroundResource(R.drawable.defaultborder);
        email.setBackgroundResource(R.drawable.defaultborder);
        noOfItems.setBackgroundResource(R.drawable.defaultborder);

        //getting the email address and converting it to string and trim it
        email.getText().toString().trim();

        //pattern to follow for validation of the email address
        emailPattern= "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        //action performed on clicking back button
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickBackButton();
            }
        });

        //action performed on clicking Confirm button
        confirmOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmOrder();
            }
        });

    }

    //working of onClickBackButton
    private void onClickBackButton() {
        //switches to ProductActivity
        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);
    }

    //working of confirm button
    public void confirmOrder()
    {
        //check if the string is empty
        if(name.getText().toString().equalsIgnoreCase("")
                &&address.getText().toString().equalsIgnoreCase("")&&
                email.getText().toString().equalsIgnoreCase("")
                &&noOfItems.getText().toString().equalsIgnoreCase("")
        )
        {
            Toast.makeText(this,"Text Fields can not be Empty",Toast.LENGTH_SHORT).show();
            name.setBackgroundResource(R.drawable.bordercolor);
            address.setBackgroundResource(R.drawable.bordercolor);
            email.setBackgroundResource(R.drawable.bordercolor);
            noOfItems.setBackgroundResource(R.drawable.bordercolor);
        }
        //check if the name field is empty
        else if(name.getText().toString().equalsIgnoreCase(""))
        {
            Toast.makeText(this,"Text Fields can not be Empty",Toast.LENGTH_SHORT).show();
            name.setBackgroundResource(R.drawable.bordercolor);
        }
        //check if the address field is empty
        else if(address.getText().toString().equalsIgnoreCase(""))
        {
            Toast.makeText(this,"Text Fields can not be Empty",Toast.LENGTH_SHORT).show();
            address.setBackgroundResource(R.drawable.bordercolor);
        }
        //check if the email field is empty
        else if(email.getText().toString().equalsIgnoreCase(""))
        {
            Toast.makeText(this,"Text Fields can not be Empty",Toast.LENGTH_SHORT).show();
            email.setBackgroundResource(R.drawable.bordercolor);
        }
        //check if the number of items field is empty
        else if(noOfItems.getText().toString().equalsIgnoreCase(""))
        {
            Toast.makeText(this,"Text Fields can not be Empty",Toast.LENGTH_SHORT).show();
            noOfItems.setBackgroundResource(R.drawable.bordercolor);
        }
        //check if the number of items value is 0
        else if(noOfItems.getText().toString().equalsIgnoreCase("0"))
        {
            Toast.makeText(this,"No of Items can not be Zero",Toast.LENGTH_SHORT).show();
            noOfItems.setBackgroundResource(R.drawable.bordercolor);
        }
        //check if the radio button is selected
        else if (radioGroup.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(this,"Please Select Payment Method",Toast.LENGTH_SHORT).show();
            radioGroup.setBackgroundResource(R.drawable.bordercolor);
        }
        //check if the email pattern is correct
        else if(email.getText().toString().trim().matches(emailPattern)!=true) {

            Toast.makeText(this,"Invalid Email Pattern",Toast.LENGTH_SHORT).show();
            email.setBackgroundResource(R.drawable.bordercolor);
        }

        else {
            Toast.makeText(this, "Congratulations! Your Order is Confirmed", Toast.LENGTH_SHORT).show();
            //switches from HomeActivity to DetailsActivity
            Intent intent = new Intent(this, OrderConfirmedActivity.class);
            startActivity(intent);

            name.setBackgroundResource(R.drawable.defaultborder);
            address.setBackgroundResource(R.drawable.defaultborder);
            email.setBackgroundResource(R.drawable.defaultborder);
            noOfItems.setBackgroundResource(R.drawable.defaultborder);
            radioGroup.setBackgroundResource(0);

        }
    }
}