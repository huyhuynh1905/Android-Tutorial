package android.huyhuynh.insertdatafromwebservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ThemSinhVienActivity extends AppCompatActivity {
    Button btnHuy,btnThem;
    EditText edtTen, edtNamsinh,edtDiachi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sinh_vien);
    }
}
