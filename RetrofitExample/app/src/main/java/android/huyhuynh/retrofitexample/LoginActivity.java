package android.huyhuynh.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.huyhuynh.retrofitexample.service.APIUtils;
import android.huyhuynh.retrofitexample.service.DataClient;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button btnConfirm;
    EditText edtEmail, edtPass;
    List<UserJetty> arrUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnConfirm = findViewById(R.id.btnConfirm);
        edtEmail = findViewById(R.id.edtEmailRs);
        edtPass = findViewById(R.id.edtPass);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                DataClient dataClient = APIUtils.getData();
                Call<List<UserJetty>> callback = dataClient.getData(email,pass);
                callback.enqueue(new Callback<List<UserJetty>>() {
                    @Override
                    public void onResponse(Call<List<UserJetty>> call, Response<List<UserJetty>> response) {
                        arrUser = response.body();
                        if (arrUser.size()>0){
                            Toast.makeText(LoginActivity.this,arrUser.get(0).getEmail()
                                    ,Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(LoginActivity.this,"Không tồn tại!"
                                    ,Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserJetty>> call, Throwable t) {
                        Toast.makeText(LoginActivity.this,"ERR"
                                ,Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
    private void deleteUser(){
        String id = arrUser.get(0).getId();
        DataClient dataClient = APIUtils.getData();
        Call<String> callback = dataClient.deleteData(id);
        callback.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.body().equals("OK")){
                    Toast.makeText(LoginActivity.this,"Xoá thành công"
                            ,Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(LoginActivity.this,"Xoá không thành công"
                            ,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("ERR",t.getLocalizedMessage());
            }
        });
    }
}
