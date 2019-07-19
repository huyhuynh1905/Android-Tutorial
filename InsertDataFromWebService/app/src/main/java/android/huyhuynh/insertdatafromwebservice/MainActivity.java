package android.huyhuynh.insertdatafromwebservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvSv;
    AdapterSinhVien adapterSv;
    List<SinhVien> arrSv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getData();
    }

    private void init() {
        lvSv = findViewById(R.id.lvSv);
        arrSv = new ArrayList<>();
        adapterSv = new AdapterSinhVien(this,R.layout.layout_sinhvien_list,arrSv);
        lvSv.setAdapter(adapterSv);
    }

    private void getData(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "http://192.168.1.102:8080/androidstudio/getdatasinhvientojson.php";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null
                , new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i=0;i<response.length();i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arrSv.add(new SinhVien(
                                        object.getInt("id"),
                                        object.getString("hoten"),
                                        object.getInt("namsinh"),
                                        object.getString("diachi")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapterSv.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Err", "onErrorResponse: "+error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_custom_option_add,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.btnAdd){
            startActivity(new Intent());
        }

        return super.onOptionsItemSelected(item);
    }
}
