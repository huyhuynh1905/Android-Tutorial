package android.huyhuynh.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    CheckBox chkRemember;
    EditText edtUser, edtPass;

    SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUser.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                if (user.equals("hcode")&&pass.equals("123")){
                    Toast.makeText(MainActivity.this,"Connected",Toast.LENGTH_SHORT).show();
                    if (chkRemember.isChecked()){
                        SharedPreferences.Editor editor = mSharedPreferences.edit();
                        editor.putString("user",user);
                        editor.putString("pass",pass);
                        editor.putBoolean("remember",true);
                        editor.commit(); //Note
                    } else {
                        SharedPreferences.Editor editor = mSharedPreferences.edit();
                        editor.remove("user");
                        editor.remove("pass");
                        editor.remove("remember");
                        editor.commit(); //Note
                    }
                } else {
                    Toast.makeText(MainActivity.this,"Disconected",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        chkRemember = findViewById(R.id.chkRemember);
        btnLogin = findViewById(R.id.btnLogin);

        mSharedPreferences = getSharedPreferences("saveData",MODE_PRIVATE);

        String user = mSharedPreferences.getString("user","");
        String pass = mSharedPreferences.getString("pass","");
        boolean check = mSharedPreferences.getBoolean("remember",false);

        edtUser.setText(user);
        edtPass.setText(pass);
        chkRemember.setChecked(check);
    }
}
