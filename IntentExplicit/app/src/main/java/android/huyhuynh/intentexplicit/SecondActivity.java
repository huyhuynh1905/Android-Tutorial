package android.huyhuynh.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Button btnSecondAc;
    TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnSecondAc = findViewById(R.id.btnSecondAc);
        txtShow = findViewById(R.id.txtShow);

        //Receive
        Intent receInten = getIntent();
//        String strRece = receInten.getStringExtra("Str");
//        int numRece = receInten.getIntExtra("Num",0);
//
//        txtShow.setText("Text: "+strRece+"\n"+"Number: "+numRece);
//        String[] arrRece = receInten.getStringArrayExtra("Array");
//        txtShow.setText(arrRece.length+" - "+arrRece[0]);
        Student student = (Student) receInten.getSerializableExtra("ObjectSend");
        txtShow.setText(student.getName()+"-"+student.getAge());


        btnSecondAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondIntent = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(secondIntent);
            }
        });
    }
}
