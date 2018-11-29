package com.nocholla.preferencefragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnPreferenceFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button
        btnPreferenceFragment = findViewById(R.id.btn_preference_fragment);
        btnPreferenceFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MyPreferencesActivity.class));
            }
        });

        // Shared Preference
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String username = SP.getString("username", "NA");
        Log.d("DEBUG USERNAME", username);

        String tintColor = SP.getString("tintColor","1");
        Log.d("DEBUG USERNAME", tintColor);

    }
}
