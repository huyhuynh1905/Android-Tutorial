package android.huyhuynh.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Khởi tạo
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mDatabaseReference.child("HoTen").setValue("Huỳnh Bảo Huy");
    }
}
