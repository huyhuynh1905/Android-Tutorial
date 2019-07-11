package android.huyhuynh.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnMainAc;
    EditText edtNum, edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMainAc = findViewById(R.id.btnMainAc);
        edtText = findViewById(R.id.edtText);
        edtNum = findViewById(R.id.edtNum);

        btnMainAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(MainActivity.this,SecondActivity.class);

                String text = "Hello This Bundle";
                int num = 1231;

                //mainIntent.putExtra("Str",text);
                //mainIntent.putExtra("Num",num);
                String[] arrStr = {"Hcode","Java","Android"};
                //mainIntent.putExtra("Array",arrStr);
                Student student = new Student("Hcode",19);
                //mainIntent.putExtra("ObjectSend",student);
                Bundle bundle = new Bundle();
                bundle.putString("Str",text);
                bundle.putInt("num",num);
                bundle.putStringArray("arr",arrStr);
                bundle.putSerializable("obj",student);

                mainIntent.putExtra("data",bundle); //

                startActivity(mainIntent);
            }
        });
    }
}
