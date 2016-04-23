package com.example.am.mqtt;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by AM on 4/24/2016.
 */
public class Notification extends Activity {
    Button btnLike,btnDislike;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nofitication_event);
        btnLike=(Button)findViewById(R.id.btnLike);
        btnDislike=(Button)findViewById(R.id.btnDislike);

    }
}
