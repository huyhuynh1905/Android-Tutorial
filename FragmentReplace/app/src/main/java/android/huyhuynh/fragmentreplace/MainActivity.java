package android.huyhuynh.fragmentreplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Tạo phương thức chuyển Fragment ở file xml đã khai báo
    public void addFragment(View view) {
        //Khai báo fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //Lây id từng button khi nhấn
        switch (view.getId()){
            //Fragment A
            case R.id.btnFragmentA:
                FragmentA fragmentA = new FragmentA();
                //Gọi phương thức replace để chuyển đổi fragment thay vì add
                fragmentTransaction.replace(R.id.frameLayout,fragmentA);
                break;

            //Fragment B
            case R.id.btnFragmentB:
                FragmentB fragmentB = new FragmentB();
                fragmentTransaction.replace(R.id.frameLayout,fragmentB);
                break;
        }
        //Phải commit
        fragmentTransaction.commit();
    }



}
