package android.huyhuynh.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    Button btnConfirm;
    EditText edtEmail, edtName, edtPhone, edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnConfirm = findViewById(R.id.btnConfirmRs);
        edtEmail = findViewById(R.id.edtEmailRs);
        edtName = findViewById(R.id.edtNameRs);
        edtPhone = findViewById(R.id.edtPhoneRs);
        edtPass = findViewById(R.id.edtPassRs);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
