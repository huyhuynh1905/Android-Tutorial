package android.huyhuynh.firebasedemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
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

        //TH4: Use push
        SinhVien sv1 = new SinhVien("Hùng",20,"Huế");
        SinhVien sv2 = new SinhVien("Nam",18,"Hà Nội");
        mDatabaseReference.child("HocVien").push().setValue(sv2);

        //Bắt sự kiện hoàn thành khi set value
        mDatabaseReference.child("SuKien").setValue("Test Sự Kiện", new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (databaseError==null){
                    Toast.makeText(MainActivity.this,"Lưu thành công",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,"Lưu thất bại",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
