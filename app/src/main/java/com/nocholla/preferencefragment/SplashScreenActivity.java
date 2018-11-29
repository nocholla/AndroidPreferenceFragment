package com.nocholla.preferencefragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;

public class SplashScreenActivity extends Activity {
    private TextView tViewUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Begin Lock Screen Orientation for Phones to Portrait Mode
        if (!isTablet()) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        // Begin Lock Screen Orientation for Tablets to Landscape Mode
        if (isTablet()) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent splashScreenIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(splashScreenIntent);
                }
            }
        };

        timerThread.start();

        // Shared Preference
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String username = SP.getString("username", "NA");
        Log.d("DEBUG USERNAME", username);

        String tintColor = SP.getString("tintColor","1");
        Log.d("DEBUG USERNAME", tintColor);

        // Widget
        tViewUsername = findViewById(R.id.tview_username);
        tViewUsername.setText(username);

    }

    private boolean isTablet() {
        return (this.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}



