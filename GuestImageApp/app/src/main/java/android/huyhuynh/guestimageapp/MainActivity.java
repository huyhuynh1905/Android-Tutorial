package android.huyhuynh.guestimageapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView imgPic, imgGuess;
    public static List<String> arrNameHinh;
    final int REQUEST_CODE_IMG = 19;
    String hinhGoc = "";
    String hinhDoan = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        imgGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guessImage();
            }
        });

    }

    private void guessImage() {
        Intent intent = new Intent(MainActivity.this,ShowPictureActivity.class);
        startActivityForResult(intent,REQUEST_CODE_IMG);
    }

    private void init() {
        imgPic = findViewById(R.id.imgPic);
        imgGuess = findViewById(R.id.imgGuess);

        String[] arrName = getResources().getStringArray(R.array.listHinh);
        arrNameHinh = new ArrayList<>(Arrays.asList(arrName));
        Collections.shuffle(arrNameHinh);
        int idImgSetUp = getResources().getIdentifier(arrNameHinh.get(1),"drawable",
                getPackageName());
        hinhGoc = arrNameHinh.get(1);
        imgPic.setImageResource(idImgSetUp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option_custom,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.btnChange){
            Collections.shuffle(arrNameHinh);
            int idImgSetUp = getResources().getIdentifier(arrNameHinh.get(1),"drawable",
                    getPackageName());
            hinhGoc = arrNameHinh.get(1);
            imgPic.setImageResource(idImgSetUp);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==REQUEST_CODE_IMG && resultCode==RESULT_OK && data!=null){
            hinhDoan = data.getStringExtra("NameImg");
            int idHinhDoan = getResources().getIdentifier(hinhDoan,"drawable",getPackageName());
            imgGuess.setImageResource(idHinhDoan);
            if (hinhDoan.equals(hinhGoc)){
                Toast.makeText(MainActivity.this,"Exactly!",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this,"Wrong!",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
