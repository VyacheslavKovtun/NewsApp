package com.example.newsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newsapp.business.services.models.Hit;
import com.squareup.picasso.Picasso;

public class ViewHitActivity extends AppCompatActivity {

    ImageView imgVPicture;
    TextView tvTitle, tvPubDate, tvContent, tvCountry, tvSource, tvWatches;

    Hit hit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_hit);

        imgVPicture = findViewById(R.id.imgVPicture);

        tvTitle = findViewById(R.id.tVTitle);
        tvPubDate = findViewById(R.id.tVPubDate);
        tvContent = findViewById(R.id.tVContent);
        tvCountry = findViewById(R.id.tVCountry);
        tvSource = findViewById(R.id.tVSource);
        tvWatches = findViewById(R.id.tVWatches);

        Bundle bundle = getIntent().getExtras();
        hit = (Hit) bundle.getSerializable(Hit.class.getSimpleName());

        loadData();
    }

    private void loadData() {
        Picasso.get().load(hit.getImageUrl()).into(imgVPicture);
        tvTitle.setText(hit.getTitle());
        tvPubDate.setText(hit.getPubDate());
        tvContent.setText(hit.getContent());
        tvCountry.setText(hit.getCountry());
        tvSource.setText(hit.getSource());

        tvWatches.setText("Watches: " + hit.getWatches());
    }

    public void btnBackClick(View view) {
        finish();
    }
}