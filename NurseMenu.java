package com.example.smarthomeassistedliving;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class NurseMenu extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;

    TextView create_appointment;
    TextView setThresholds;
    Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_menu);
        listView = (ListView)findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        new Connection().execute();

        create_appointment = (TextView)findViewById(R.id.createAppointmentButton);
        setThresholds = (TextView)findViewById(R.id.setThresholdsButton);
        logoutButton = (Button)findViewById(R.id.buttonLogOut);

    }

    class Connection extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            String result = "";
            String host = "http://192.168.254.21/currentrate.php";
            try{
                HttpClient client=  new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(host));
                HttpResponse response = client.execute(request);
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                StringBuffer stringBuffer = new StringBuffer("");

                String line = "";
                while((line = reader.readLine()) != null){
                    stringBuffer.append(line);
                    break;
                }
                reader.close();
                result = stringBuffer.toString();
            }
            catch(Exception e){
                return new String("There exception: " + e.getMessage());
            }
            return result;
        }
        @Override
        protected void onPostExecute(String result){
            try {
                JSONObject jsonResult = new JSONObject(result);
                JSONArray rates = jsonResult.getJSONArray("listofrates");
                for(int i=0; i<rates.length(); i++)
                {
                    JSONObject rate = rates.getJSONObject(i);
                    String rateId = rate.getString("heartrate");
                    String motionId = rate.getString("motionrate");
                    String oxygenId = rate.getString("oxygenrate");
                    String line = "   Heart = " + rateId + "            Motion = " + motionId + "            Oxygen = " + oxygenId;
                    adapter.add(line);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
     public void OnCreateAppointment(View view)
{
    startActivity(new Intent(this, enterAppointmentInfo.class));
}

public void OnLogOut(View view)
{
    startActivity(new Intent(this, MainActivity.class));
}

public void OnSetThresholds(View view)
{
    startActivity(new Intent(this, enterThreshold.class));
}


}
