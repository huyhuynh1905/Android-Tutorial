package android.huyhuynh.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    Button btnConfirm;
    EditText edtEmail, edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnConfirm = findViewById(R.id.btnConfirm);
        edtEmail = findViewById(R.id.edtEmailRs);
        edtPass = findViewById(R.id.edtPass);
    }
}
