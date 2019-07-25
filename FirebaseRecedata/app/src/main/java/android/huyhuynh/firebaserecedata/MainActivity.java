package android.huyhuynh.firebaserecedata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    DatabaseReference mDatabaseReference;
    TextView txtKhoahoc;
    Button btnAndroid, btnIos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtKhoahoc = findViewById(R.id.txtKhoaHoc);
        btnAndroid = findViewById(R.id.btnAndroid);
        btnIos = findViewById(R.id.btnIos);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        //mDatabaseReference.child("PhuongTien").push().setValue(new PhuongTien("Xe Khách",10));
        //mDatabaseReference.child("KhoaHoc").push().setValue("Lập Trình Android");



        //Kiểm tra sự thay đổi dùng
        mDatabaseReference.child("PhuongTien").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //Đọc object về
                PhuongTien phuongTien = dataSnapshot.getValue(PhuongTien.class);
                Toast.makeText(MainActivity.this,phuongTien.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





        /*
        //Kiểm tra sự thay đổi dùng ValueEventListener
        mDatabaseReference.child("KhoaHoc").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtKhoahoc.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btnAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabaseReference.child("KhoaHoc").setValue("Android");
            }
        });
        btnIos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabaseReference.child("KhoaHoc").setValue("Ios");
            }
        });*/
    }
}
