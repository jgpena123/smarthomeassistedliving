package com.example.smarthomeassistedliving;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SetOxygenRateThreshold extends AppCompatActivity {

    EditText strMaxOxygen, strMinOxygen;
    Button setOxygenRateButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_oxygen_rate_threshold);
        strMaxOxygen = (EditText)findViewById(R.id.oxygenRateMax);
        strMinOxygen = (EditText)findViewById(R.id.oxygenRateMin);
        setOxygenRateButton = (Button)findViewById(R.id.setOxygenRate);
    }

    public void OnSetO(View view){
        String stromax = strMaxOxygen.getText().toString();
        String stromin = strMinOxygen.getText().toString();
        String type = "Change Oxygen Rate";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, stromax, stromin);
    }
}
