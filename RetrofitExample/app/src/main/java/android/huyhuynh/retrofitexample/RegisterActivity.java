package android.huyhuynh.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.huyhuynh.retrofitexample.service.APIUtils;
import android.huyhuynh.retrofitexample.service.DataClient;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                String email = edtEmail.getText().toString().trim();
                String name = edtName.getText().toString().trim();
                String phone = edtPhone.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();

                DataClient insertdata = APIUtils.getData();
                Call<String> callback = insertdata.insertData(email,name,phone,pass);
                callback.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        String result = response.body();
                        if (result.equals("OK")){
                            Toast.makeText(RegisterActivity.this,"OK",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(RegisterActivity.this,"ERROR",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
            }
        });
    }
}
