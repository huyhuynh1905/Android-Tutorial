package android.huyhuynh.randomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtShowNum;
    Button btnRandom;
    EditText edtNum1,edtNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        control();
    }

    private void control() {
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1Str = edtNum1.getText().toString().trim();
                String num2Str = edtNum2.getText().toString().trim();
                if (num1Str.length()==0|num2Str.length()==0){
                    Toast.makeText(MainActivity.this,"Error! Enter your number!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    int min = Integer.parseInt(num1Str);
                    int max = Integer.parseInt(num2Str);
                    Random rd = new Random();
                    int num = rd.nextInt(max-min+1)+min;
                    txtShowNum.setText(String.valueOf(num));
                }
            }
        });
    }

    private void init() {
        txtShowNum = findViewById(R.id.txtNumshow);
        btnRandom = findViewById(R.id.btnRandom);
        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
    }
}
