package com.example.apidogpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy gfgPolicy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(gfgPolicy);
        }


        LinearLayout layout = (LinearLayout)findViewById(R.id.imageLayout);
        ImageView imageView = new ImageView(MainActivity.this);

        // setting the image in the layout
       // imageView.setImageResource("https://media.wired.com/photos/593435045321273fc0f91ad5/master/pass/fry_660.jpg");
        try {
            imageView.setImageBitmap(BitmapFactory.decodeStream(new URL("https://media.wired.com/photos/593435045321273fc0f91ad5/master/pass/fry_660.jpg").openConnection().getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageView.setLayoutParams(new android.view.ViewGroup.LayoutParams(400,400));
        imageView.setMaxHeight(200);
        imageView.setMaxWidth(200);
        layout.addView(imageView);


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
}