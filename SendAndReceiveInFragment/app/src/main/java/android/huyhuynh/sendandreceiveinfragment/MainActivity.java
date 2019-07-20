package android.huyhuynh.sendandreceiveinfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMain = findViewById(R.id.btnSend);
        //Khai báo 2 đối tượng không thể thiếu của Fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //Bắt sự kiện gửi dữ liệu qua fragment bằng bundle
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Khai báo fragment
                FragmentA fragmentA = new FragmentA();
                //Gửi dữ liệu (khỏi tạo trước khi gán fragment vào layout nào đó)
                Bundle bundle = new Bundle();
                bundle.putString("dataString","Đây là dữ liệu được gửi");
                //set để gửi
                fragmentA.setArguments(bundle);
                //vì là LinearLayout nên xắp xếp xuống có thể gán trực tiếp thay vì dùng framelayout
                fragmentTransaction.add(R.id.layoutMain,fragmentA);
                fragmentTransaction.commit();
            }
        });
    }
}
