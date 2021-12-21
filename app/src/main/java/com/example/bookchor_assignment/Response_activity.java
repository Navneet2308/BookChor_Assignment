package com.example.bookchor_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Response_activity extends AppCompatActivity {
    ImageView image_view;
    TextView img_url, user_lng, user_lat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
        initUtils();
        getandsetIntentValues();
        img_url.setPaintFlags(img_url.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        img_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(img_url.getText().toString()));
                startActivity(browserIntent);
            }
        });

    }

    private void getandsetIntentValues() {
        user_lat.setText(getIntent().getExtras().getString("lat"));
        user_lng.setText(getIntent().getExtras().getString("lng"));
        Picasso.with(Response_activity.this).load(getIntent().getExtras().getString("img_url").replace("\\","")).into(image_view);
        img_url.setText(getIntent().getExtras().getString("img_url").replace("\\",""));
    }

    private void initUtils() {
        img_url = findViewById(R.id.img_url);
        user_lng = findViewById(R.id.user_lng);
        user_lat = findViewById(R.id.user_lat);
        image_view = findViewById(R.id.image_view);
    }


    }
