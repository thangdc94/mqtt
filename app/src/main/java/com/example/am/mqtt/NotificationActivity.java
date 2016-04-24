package com.example.am.mqtt;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AM on 4/24/2016.
 */
public class NotificationActivity extends AppCompatActivity {
    Button btnLike, btnDislike;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nofitication_event);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.nof_toolbar);
        myToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        btnLike = (Button) findViewById(R.id.btnLike);
        btnDislike = (Button) findViewById(R.id.btnDislike);
        final String s = getIntent().getExtras().getString("message");
        tv = (TextView) findViewById(R.id.tvMess);
        tv.setText(s);

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NotificationActivity.this, ":))", Toast.LENGTH_SHORT).show();
                finish();
            }

        });

        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PushService.publish(PushService.MQTT_TOPIC_FEDDBACK, s);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
