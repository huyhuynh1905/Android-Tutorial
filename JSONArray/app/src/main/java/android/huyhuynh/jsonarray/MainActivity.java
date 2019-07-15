package android.huyhuynh.jsonarray;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
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
                new ReadJSONArray().execute("https://api.myjson.com/bins/owu7f");
            }
        });
    }

    private class ReadJSONArray extends AsyncTask<String,Void,String>{
        StringBuilder json = new StringBuilder();
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while ((line=bufferedReader.readLine())!=null){
                    json.append(line+"\n");
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return json.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject object = new JSONObject(s);
                JSONArray arr = object.getJSONArray("statusCode");
                for (int i=0;i<arr.length();i++){
                    JSONObject arrOb = arr.getJSONObject(i);
                    String status = arrOb.getString("sst");
                    Toast.makeText(MainActivity.this,status,Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
        }
    }
}
