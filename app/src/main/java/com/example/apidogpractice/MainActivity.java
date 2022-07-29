package com.example.apidogpractice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;



public class MainActivity extends AppCompatActivity {
//     ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       ImageView img1=findViewById(R.id.imageView);
        String url = "http://i.imgur.com/DvpvklR.png";
//
//        Picasso.with(this).load(url).into(img1);
        ImageView imageView = findViewById(R.id.imageView);
        Picasso.with(this).load(url).into(img1);


//        Picasso.get()
//                .load("https://i.imgur.com/DvpvklR.png")
//                .into(img1);




        System.out.println("done");

    }

    @Override
    protected void onStart() {

        super.onStart();
//        ImageView img1;
//        img1 = (ImageView) findViewById(R.id.testPicasso);
//
//        Picasso.get()
//                .load("https://images.unsplash.com/photo-1587402092301-725e37c70fd8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cHVwcHklMjBkb2d8ZW58MHx8MHx8&w=1000&q=80")
//                .into(img1);
    }
}