package android.huyhuynh.fragmentremove;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
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


    public void addFragmentA(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.add(R.id.frameLayout,fragmentA,"TagA");
        //Add BackStack để dùng Back and Pop
        fragmentTransaction.addToBackStack("AAA");
        fragmentTransaction.commit();

    }

    public void addFragmentB(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.add(R.id.frameLayout,fragmentB,"TagB");
        fragmentTransaction.addToBackStack("BBB");
        fragmentTransaction.commit();
    }

    public void addFragmentC(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentC fragmentC = new FragmentC();
        fragmentTransaction.add(R.id.frameLayout,fragmentC,"TagC");
        fragmentTransaction.addToBackStack("CCC");
        fragmentTransaction.commit();
    }


    public void removeFragmentA(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = (FragmentA) getSupportFragmentManager().findFragmentByTag("TagA");
        if (fragmentA!=null){
            fragmentTransaction.remove(fragmentA);
            fragmentTransaction.commit();
        }
    }

    public void removeFragmentB(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentByTag("TagB");
        if (fragmentB!=null){
            fragmentTransaction.remove(fragmentB);
            fragmentTransaction.commit();
        }
    }

    public void removeFragmentC(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentC fragmentC = (FragmentC) getSupportFragmentManager().findFragmentByTag("TagC");
        if (fragmentC!=null){
            fragmentTransaction.remove(fragmentC);
            fragmentTransaction.commit();
        }
    }

    public void popFragmentA(View view) {
        //Tương tự back nhưng mà lấy về cái fragment A
        getSupportFragmentManager().popBackStack("AAA",0);
    }

    public void eventBack(View view) {
        //Trở về fragment trước
        getSupportFragmentManager().popBackStack();
    }

}
