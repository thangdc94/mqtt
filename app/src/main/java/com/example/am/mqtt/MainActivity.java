package com.example.am.mqtt;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private boolean isOn=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitleTextColor(Color.RED);
        myToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem img=menu.findItem(R.id.action_home);
        final Drawable drawable = img.getIcon();
        if (drawable != null) {
            // If we don't mutate the drawable, then all drawable's with this id will have a color
            // filter applied to it.
            drawable.mutate();
            drawable.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
            //drawable.setAlpha(alpha);
        }
        
        img.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(isOn)
                {
                    Toast.makeText(MainActivity.this, "OKe", Toast.LENGTH_SHORT).show();
                    drawable.mutate();
                    drawable.setColorFilter(Color.BLACK,PorterDuff.Mode.SRC_ATOP);
                    isOn=false;
                    return false;
                }
                else
                {
                    Toast.makeText(MainActivity.this, "OKe", Toast.LENGTH_SHORT).show();
                    drawable.mutate();
                    drawable.setColorFilter(Color.RED,PorterDuff.Mode.SRC_ATOP);
                    return false;
                }
            }
        });
        ToggleButton mSwitchShowSecure;
        mSwitchShowSecure = (ToggleButton) menu.findItem(R.id.show_secure).getActionView().findViewById(R.id.ToggleButton0111);
        mSwitchShowSecure.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    //Your code when checked

                } else {
                    //Your code when unchecked
                }
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
