package com.example.apidogpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    String apiResponse;
    JsonNode responseNode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this if condition ignores running http calls on the main thread, risk of error with this present
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy gfgPolicy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(gfgPolicy);
        }


        LinearLayout layout = (LinearLayout)findViewById(R.id.imageLayout);
        ImageView imageView = new ImageView(MainActivity.this);

        // setting the image in the layout
       // imageView.setImageResource("https://media.wired.com/photos/593435045321273fc0f91ad5/master/pass/fry_660.jpg");

            imageView.setImageBitmap(convertUrlToImage("https://media.wired.com/photos/593435045321273fc0f91ad5/master/pass/fry_660.jpg"));

        imageView.setLayoutParams(new android.view.ViewGroup.LayoutParams(400,400));
        imageView.setMaxHeight(200);
        imageView.setMaxWidth(200);
        layout.addView(imageView);

        getDogApi();
        imageArrayCreator();
        ImageView imageView2;
        if(this.responseNode != null) {
            for(int i = 0; i < this.responseNode.size(); i++) {
                System.out.println(this.responseNode.get(i));
                 imageView2  = new ImageView(MainActivity.this);
                imageView2.setImageBitmap(convertUrlToImage(this.responseNode.get(i).asText()));

                imageView2.setLayoutParams(new android.view.ViewGroup.LayoutParams(400,400));
                imageView2.setMaxHeight(200);
                imageView2.setMaxWidth(200);
                layout.addView(imageView2);
            }
        }




//        for(int i=0;i<10;i++)
//        {
//            ImageView image = new ImageView(this);
//
//            image.setLayoutParams(new android.view.ViewGroup.LayoutParams(80,60));
//            image.setMaxHeight(20);
//            image.setMaxWidth(20);
//
//            // Adds the view to the layout
//            layout.addView(image);
//        }
    }

    //method to convert url to image to use in project
    public Bitmap convertUrlToImage(String imageUrl) {
        try {
            return BitmapFactory.decodeStream(new URL(imageUrl).openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void getDogApi() {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://dog.ceo/api/breeds/image/random/3")
                .build();

        try {
            Response response = httpClient.newCall(request).execute();
            this.apiResponse = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void imageArrayCreator() {
        JsonNode node = null;
        ObjectMapper dataMapper = new ObjectMapper();

        try {
            node = dataMapper.readTree(this.apiResponse);
            this.responseNode = node.path("message");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

