package com.example.smarthomeassistedliving;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SetHeartRateThreshold extends AppCompatActivity {

    EditText strMaxHeart, strMinHeart;
    Button setHeartRateButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_heart_rate_threshold);
        strMaxHeart = (EditText)findViewById(R.id.heartRateMax);
        strMinHeart = (EditText)findViewById(R.id.heartRateMin);
        setHeartRateButton = (Button)findViewById(R.id.setHeartRate);
    }

    public void OnSetHR(View view){
        String strhrmax = strMaxHeart.getText().toString();
        String strhrmin = strMinHeart.getText().toString();
        String type = "Change Heart Rate";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, strhrmax, strhrmin);
    }
}
