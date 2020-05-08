package com.example.smarthomeassistedliving;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SetMotionRateThreshold extends AppCompatActivity {

    EditText strMaxMotion, strMinMotion;
    Button setMotionRateButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_motion_rate_threshold);
        strMaxMotion = (EditText)findViewById(R.id.motionRateMax);
        strMinMotion = (EditText)findViewById(R.id.motionRateMin);
        setMotionRateButton = (Button)findViewById(R.id.setMotionRate);
    }

    public void OnSetM(View view){
        String strmmax = strMaxMotion.getText().toString();
        String strmmin = strMinMotion.getText().toString();
        String type = "Change Motion Rate";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, strmmax, strmmin);
    }
}
