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

public class EditSinhVienActivity extends AppCompatActivity {

    Button btnHuyUp,btnEditUp;
    EditText edtTenUp, edtNamsinhUp,edtDiachiUp;
    int id =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sinh_vien);
        init();
        Intent intent = getIntent();
        SinhVien sv = (SinhVien) intent.getSerializableExtra("sinhvien");
        id = sv.getId();
        edtTenUp.setText(sv.getHoten());
        edtDiachiUp.setText(sv.getDiachi());
        edtNamsinhUp.setText(sv.getNamsinh()+"");
        btnHuyUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnEditUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://juliuskma.000webhostapp.com/updatessinhvien.php";
                updateSinhVien(url);
            }
        });
    }

    private void init() {
        btnEditUp = findViewById(R.id.btnEditUp);
        btnHuyUp = findViewById(R.id.btnHuyUp);
        edtTenUp = findViewById(R.id.edtTenUp);
        edtNamsinhUp = findViewById(R.id.edtNamSinhUp);
        edtDiachiUp = findViewById(R.id.edtDiaChiUp);
    }
    private void updateSinhVien(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("Success")){
                    Toast.makeText(EditSinhVienActivity.this,"Success",Toast.LENGTH_LONG).show();
                    finish();
                } else if (response.trim().equals("Error")){
                    Toast.makeText(EditSinhVienActivity.this,"Error",Toast.LENGTH_LONG).show();
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
                params.put("hoten",edtTenUp.getText().toString().trim());
                params.put("namsinh",edtNamsinhUp.getText().toString().trim());
                params.put("diachi",edtDiachiUp.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
