package android.huyhuynh.languageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
    Button btnVn,btnEn;
    TextView txtShow;
    String jsonLanguage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnVn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readJSONLanguage("vn");
            }
        });
        btnEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readJSONLanguage("en");
            }
        });
    }

    private void init() {
        btnVn = findViewById(R.id.btnVn);
        btnEn = findViewById(R.id.btnEn);
        txtShow = findViewById(R.id.txtShow);
        //
        new ReadJSONApp().execute("https://api.myjson.com/bins/gj20b");
    }

    private class ReadJSONApp extends AsyncTask<String,Void,String>{
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
            Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            jsonLanguage = s;
            readJSONLanguage("vn");
        }
    }
    private void readJSONLanguage(String lang){
        try {
            JSONObject object = new JSONObject(jsonLanguage);
            JSONObject languageOb = object.getJSONObject("language");
            JSONObject language = languageOb.getJSONObject(lang);
            String name = language.getString("name");
            String classed = language.getString("class");
            String adress = language.getString("adress");
            String teacher = language.getString("teacher");
            String show = "Name: "+name+"\n"+
                            "Class: "+classed+"\n"+
                            "Adress: "+adress+"\n"+
                            "Teach: "+teacher;
            txtShow.setText(show);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
