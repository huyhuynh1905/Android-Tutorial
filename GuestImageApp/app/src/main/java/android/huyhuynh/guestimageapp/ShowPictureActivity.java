package android.huyhuynh.guestimageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.Collections;

public class ShowPictureActivity extends Activity {

    TableLayout layoutTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_picture);
        layoutTable = findViewById(R.id.layoutTable);

        Collections.shuffle(MainActivity.arrNameHinh);
        int soDong = 5;
        int soCot = 3;
        for (int i=1;i<=soDong;i++){

            TableRow tableRow = new TableRow(this);

            for (int j=1;j<=soCot;j++){
                ImageView imageView = new ImageView(this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(180,180);
                imageView.setLayoutParams(layoutParams);

                final int vitri = soCot * (i-1) + j-1;
                int idHinh = getResources().getIdentifier(MainActivity.arrNameHinh.get(vitri),
                        "drawable",getPackageName());
                imageView.setImageResource(idHinh);
                tableRow.addView(imageView);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("NameImg",MainActivity.arrNameHinh.get(vitri));
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });
            }
            layoutTable.addView(tableRow);
        }
    }
}
