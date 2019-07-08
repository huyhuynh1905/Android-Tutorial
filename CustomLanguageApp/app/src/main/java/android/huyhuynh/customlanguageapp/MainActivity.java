package android.huyhuynh.customlanguageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnConfirm;
    EditText edtName, edtEmail, edtPhone;
    TextView txtHienthi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String phone = edtPhone.getText().toString();
                String txtTen = getResources().getString(R.string.txt_Name);
                String txtphone = getResources().getString(R.string.txt_Phone);
                txtHienthi.setText(txtTen+name+"\n"+"Email: "+email+"\n"+txtphone+phone);
            }
        });
    }

    private void init() {
        btnConfirm = findViewById(R.id.btnConfirm);
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        txtHienthi = findViewById(R.id.txtHienThi);
    }
}
