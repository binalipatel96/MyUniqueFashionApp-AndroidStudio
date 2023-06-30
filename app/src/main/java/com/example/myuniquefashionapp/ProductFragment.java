package com.example.myuniquefashionapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class ProductFragment extends Fragment {

//    ImageView imageView1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    //arraylist of type ProductModel class
    ArrayList<ProductModel> productModelArrayList;

    public ProductFragment() {
        // Required empty public constructor
    }

    public static ProductFragment newInstance(String param1, String param2) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_product, container, false);
        //storing reference of recycler view in the RecyclerView object
        recyclerView = view.findViewById(R.id.product_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //initializing the array list
        productModelArrayList = new ArrayList<>();

        //creating objects of ProductModel class
        ProductModel product1 = new ProductModel(R.drawable.yellow_dress, "Midi Dress", "Yellow Long Sleeve","CAD 90");
        productModelArrayList.add(product1);
        ProductModel product2 = new ProductModel(R.drawable.denim_wear, "Denim Wear", "Blue Denim Jeans","CAD 120");
        productModelArrayList.add(product2);
        ProductModel product3 = new ProductModel(R.drawable.men_coat, "Coat Wear", "Brown Long Coat","CAD 125");
        productModelArrayList.add(product3);
        ProductModel product4 = new ProductModel(R.drawable.coat_blazer, "Men's Blazer", "Grey Coat Set","CAD 200");
        productModelArrayList.add(product4);
        ProductModel product5 = new ProductModel(R.drawable.kids_wear, "Kids Wear", "Unique Designer Wear","CAD 20");
        productModelArrayList.add(product5);
        ProductModel product6 = new ProductModel(R.drawable.eye_shadow, "Eye Shadow", "Ultimate Fusion Colors","CAD 20");
        productModelArrayList.add(product6);

        recyclerView.setAdapter(new ProductAdapter(getContext(),productModelArrayList));
        return view;
    }
}