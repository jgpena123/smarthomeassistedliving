package com.example.smarthomeassistedliving;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class enterThreshold extends AppCompatActivity {
    Button heartButton, oxygenButton, motionButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_threshold);
        heartButton = (Button) findViewById(R.id.heartRateButton);
        oxygenButton = (Button) findViewById(R.id.oxygenRateButton);
        motionButton = (Button) findViewById(R.id.motionRateButton);
    }

    public void OnHeartRate(View view) {
        startActivity(new Intent(this, SetHeartRateThreshold.class));
    }

    public void OnOxygenRate(View view) {
        startActivity(new Intent(this, SetOxygenRateThreshold.class));
    }

    public void OnMotionRate(View view) {
        startActivity(new Intent(this, SetMotionRateThreshold.class));
    }
}

