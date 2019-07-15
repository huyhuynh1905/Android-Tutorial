package android.huyhuynh.jsonarrayobject;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvView;
    ArrayList<String> arrStr;
    ArrayAdapter<String> adapterArr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        lvView = findViewById(R.id.lvView);
        arrStr = new ArrayList<>();
        adapterArr = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,
                arrStr);
        lvView.setAdapter(adapterArr);

        new JSONArrayObject().execute("https://api.myjson.com/bins/mwlwb");
    }

    private class JSONArrayObject extends AsyncTask<String,Void,String>{
        StringBuilder json = new StringBuilder();
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line ="";
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
                JSONArray array = new JSONArray(s);
                for (int i=0;i<array.length();i++){
                    JSONObject object = array.getJSONObject(i);
                    String course = object.getString("course");
                    String price = object.getString("price");
                    String text = course+" - "+price;
                    arrStr.add(text);
                }
                adapterArr.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
