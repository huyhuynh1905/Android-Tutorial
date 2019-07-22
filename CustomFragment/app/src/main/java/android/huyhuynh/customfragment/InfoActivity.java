package android.huyhuynh.customfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class InfoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent intent = getIntent();
        SinhVien sv = (SinhVien) intent.getSerializableExtra("dataSV");

        FragmentInfo fragmentInfo = (FragmentInfo) getSupportFragmentManager().findFragmentById(R.id.fragmentInfoSV);
        fragmentInfo.setInfoSinhVien(sv);
    }
}
