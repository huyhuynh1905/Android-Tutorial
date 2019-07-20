package android.huyhuynh.insertdatafromwebservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        arrSv.clear(); //Clear lại danh sách mỗi lần get
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://juliuskma.000webhostapp.com/getdatasinhvientojson.php";
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
            startActivity(new Intent(MainActivity.this,ThemSinhVienActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    //Phương thức xoá ở MainActivity
    public void deleteSinhVien(final int id){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://juliuskma.000webhostapp.com/deletesinhvien.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("Success")){
                    Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_LONG).show();
                    //get lại data sau khi xoá
                    getData();
                } else if (response.trim().equals("Error")){
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ErrT", "onErrorResponse: "+error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Đoạn map để insert dữ liệu
                Map<String,String> params = new HashMap<>();
                params.put("id",String.valueOf(id));
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getData();
    }

}
