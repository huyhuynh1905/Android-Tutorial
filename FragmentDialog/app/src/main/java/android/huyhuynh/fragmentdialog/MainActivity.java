package android.huyhuynh.fragmentdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements InterDelete {
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentDialog fragmentDialog = new FragmentDialog();
                //để show dialog fragmrnt thì
                fragmentDialog.show(getSupportFragmentManager(),"AAAA");
            }
        });
    }
    @Override
    public void giaTriXoa(boolean value) {
        if (value==true){
            Toast.makeText(MainActivity.this,"Có",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this,"Không",Toast.LENGTH_SHORT).show();
        }
    }
}
