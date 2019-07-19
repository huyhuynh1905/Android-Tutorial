package android.huyhuynh.insertdatafromwebservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ThemSinhVienActivity extends AppCompatActivity {
    Button btnHuy,btnThem;
    EditText edtTen, edtNamsinh,edtDiachi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sinh_vien);
        init();
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themSinhVien("http://192.168.1.102:8080/androidstudio/inserttosinhvien.php");
            }
        });
    }

    private void themSinhVien(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("Success")){
                    Toast.makeText(ThemSinhVienActivity.this,"Success",Toast.LENGTH_LONG).show();
                    finish();
                } else if (response.trim().equals("Error")){
                    Toast.makeText(ThemSinhVienActivity.this,"Error",Toast.LENGTH_LONG).show();
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
                params.put("hoten",edtTen.getText().toString().trim());
                params.put("namsinh",edtNamsinh.getText().toString().trim());
                params.put("diachi",edtDiachi.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void init() {
        btnThem = findViewById(R.id.btnThem);
        btnHuy = findViewById(R.id.btnHuy);
        edtTen = findViewById(R.id.edtTen);
        edtNamsinh = findViewById(R.id.edtNamSinh);
        edtDiachi = findViewById(R.id.edtDiaChi);
    }
}
