package android.huyhuynh.customfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements DataSendSinhVien{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void senData(SinhVien sv) {
        FragmentInfo fragmentInfo = (FragmentInfo)
                getSupportFragmentManager().findFragmentById(R.id.fragmentInfo);
        if (fragmentInfo!=null && fragmentInfo.isInLayout()) {
            fragmentInfo.setInfoSinhVien(sv);
        } else {
            Intent intent = new Intent(MainActivity.this,InfoActivity.class);
            intent.putExtra("dataSV",sv);
            startActivity(intent);
        }
    }
}
