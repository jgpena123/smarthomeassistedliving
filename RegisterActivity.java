package com.example.smarthomeassistedliving;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText str_username, str_password, str_fullname, str_email, str_role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        str_username = (EditText)findViewById(R.id.regUsername);
        str_password = (EditText)findViewById(R.id.regPassword);
        str_fullname = (EditText)findViewById(R.id.regFullname);
        str_email = (EditText)findViewById(R.id.regEmail);
        str_role = (EditText)findViewById(R.id.regRole);
    }

    public void OnReg(View view)
    {
        String strusername = str_username.getText().toString();
        String strpassword = str_password.getText().toString();
        String strfullname = str_fullname.getText().toString();
        String stremail = str_email.getText().toString();
        String strrole = str_role.getText().toString();
        String type = "register";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, strusername, strpassword, strfullname, stremail, strrole);
    }
}
