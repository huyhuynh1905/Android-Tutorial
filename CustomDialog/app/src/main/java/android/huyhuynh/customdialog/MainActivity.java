package android.huyhuynh.customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom);
        dialog.setTitle("Login");

        final EditText edtUser = dialog.findViewById(R.id.edtUser);
        final EditText edtPass = dialog.findViewById(R.id.edtPass);
        Button btnAc = dialog.findViewById(R.id.btnAc);
        Button btnCancel = dialog.findViewById(R.id.btnHuy);

        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUser.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                if (user.equals("hcode")&&pass.equals("123")){
                    Toast.makeText(MainActivity.this,"Connected",Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else Toast.makeText(MainActivity.this,"Disconnected",Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
