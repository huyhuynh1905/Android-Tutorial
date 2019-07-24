package android.huyhuynh.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Khởi tạo
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        //TH1: Thêm chuỗi
        mDatabaseReference.child("HoTen").setValue("Huỳnh Bảo Huy");
        //TH2: Set Object
        SinhVien sv = new SinhVien("Hao",19,"Thừa Thiên Huế");
        mDatabaseReference.child("SinhVien").setValue(sv);
        //TH3: Set map
        Map<String,Integer> myMap = new HashMap<>();
        myMap.put("Xe04",4);
        mDatabaseReference.child("XeBus").setValue(myMap);
    }
}
