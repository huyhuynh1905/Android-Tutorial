package android.huyhuynh.startfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Thêm fragment bằng code:
        //2 dòng mặc định phải có
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //Thêm fragment vào
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.add(R.id.frameLayout,fragmentA);
        fragmentTransaction.commit(); //Xác nhận
    }
}
