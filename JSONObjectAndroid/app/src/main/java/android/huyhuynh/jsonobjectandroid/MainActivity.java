package android.huyhuynh.jsonobjectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRead = findViewById(R.id.btnRead);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ReadJSONObjectOnAS().execute("http://api.ipinfodb.com/v3/ip-city/?key=b8c77d080bedf7519c4e9eecd9787cf1a0baec8cf8de3934b1692f474dbfd89a&ip=1.54.169.212&format=json");
            }
        });
    }

    protected class ReadJSONObjectOnAS extends AsyncTask<String,Void,String>{
        StringBuilder jsonStr = new StringBuilder();
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while ((line=bufferedReader.readLine())!=null){
                    jsonStr.append(line+"\n");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return jsonStr.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject object = new JSONObject(s);
                String countryName = object.getString("countryName");
                String regionName = object.getString("regionName");
                String zipCode = object.getString("zipCode");
                Toast.makeText(MainActivity.this,countryName+"\n"+
                        regionName+"\n"+zipCode,Toast.LENGTH_LONG).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
