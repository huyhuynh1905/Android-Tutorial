package android.huyhuynh.switchandcheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox chkAndroid, chkHcode, chkiOs;
    Switch switchHello;
    Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        control();
    }

    private void init() {
        btnCheck = findViewById(R.id.btnCheck);
        chkAndroid = findViewById(R.id.chkAndroid);
        chkHcode = findViewById(R.id.chkHcode);
        chkiOs = findViewById(R.id.chkiOs);
        switchHello = findViewById(R.id.switchHello);
    }

    private void control() {
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mess  = "";
                if (chkAndroid.isChecked()){
                    mess += chkAndroid.getText() +" ";
                }
                if (chkHcode.isChecked()){
                    mess += chkHcode.getText() +" ";
                }
                if (chkiOs.isChecked()){
                    mess += chkiOs.getText() +" ";
                }
                if (mess.equals("")){
                    Toast.makeText(MainActivity.this,"No Checked",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,mess,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        switchHello.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) { //isChecked == true
                    Toast.makeText(MainActivity.this,"Hello On",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,"Hello Off",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        chkAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) { //isChecked == true
                    Toast.makeText(MainActivity.this,"Android checked",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,"Android non checked",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
