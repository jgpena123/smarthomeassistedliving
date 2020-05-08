package com.example.smarthomeassistedliving;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.etUsername);
        password = (EditText)findViewById(R.id.etPassword);
        loginButton = (Button)findViewById(R.id.btnLogin);
    }

public void OnLogin(View view)
{
    String user_name = username.getText().toString();
    String pass_word = password.getText().toString();
    String type = "login";

    BackgroundWorker backgroundWorker = new BackgroundWorker(this);
    backgroundWorker.execute(type, user_name, pass_word);
}

public void OpenReg(View view)
{
    startActivity(new Intent(this, RegisterActivity.class));
}

}
