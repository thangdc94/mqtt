package com.example.am.mqtt;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private String mDeviceID;
    private boolean isOn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDeviceID = "123";
        /**
         * Very important
         */
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitleTextColor(Color.RED);
        myToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);


    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences p = getSharedPreferences(PushService.TAG, MODE_PRIVATE);
        boolean started = p.getBoolean(PushService.PREF_STARTED, false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        SharedPreferences p = getSharedPreferences(PushService.TAG, MODE_PRIVATE);
        boolean started = p.getBoolean(PushService.PREF_STARTED, false);

        ToggleButton mSwitchShowSecure;
        mSwitchShowSecure = (ToggleButton) menu.findItem(R.id.show_secure).getActionView().findViewById(R.id.ToggleButton0111);

        if (started)
            mSwitchShowSecure.setChecked(true);
        else
            mSwitchShowSecure.setChecked(false);

        mSwitchShowSecure.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    //Your code when checked
                    SharedPreferences.Editor editor = getSharedPreferences(PushService.TAG, MODE_PRIVATE).edit();
                    editor.putString(PushService.PREF_DEVICE_ID, mDeviceID);
                    editor.commit();
                    PushService.actionStart(getApplicationContext());
                } else {
                    //Your code when unchecked
                    PushService.actionStop(getApplicationContext());
                }
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
