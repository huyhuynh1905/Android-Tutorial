package android.huyhuynh.fragmenteventcommunity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnChange;
    TextView txtMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        //Giao tiếp giữa Activity qua FragmenA (Set text lại cho A)
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //R.id.fragmentA : là id khai báo ở activity.xml
                FragmentA fragmentA = (FragmentA) getSupportFragmentManager().findFragmentById(R.id.fragmentA);
                //Gọi phương thức có sắn trong A
                fragmentA.ganTextViewFragA("Đang gọi tới Fragment A");
            }
        });
    }

    private void init() {
        btnChange = findViewById(R.id.btnChange);
        txtMain = findViewById(R.id.txtMain);
    }
}
