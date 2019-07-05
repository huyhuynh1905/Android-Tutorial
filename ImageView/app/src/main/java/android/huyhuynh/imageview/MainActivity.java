package android.huyhuynh.imageview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imgView;
    Button btnChange;
    ConstraintLayout layoutBackgr;
    List<Integer> ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        control();

    }

    private void init() {
        btnChange = findViewById(R.id.btnBackground);
        layoutBackgr = findViewById(R.id.layoutBack);
        ls = new ArrayList<>();
        ls.add(R.drawable.ha1);
        ls.add(R.drawable.ha2);
        ls.add(R.drawable.ha3);
        ls.add(R.drawable.ha4);
    }

    private void control() {
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int red = new Random().nextInt(255);
                int green = new Random().nextInt(255);
                int blue = new Random().nextInt(255);
                layoutBackgr.setBackgroundColor(Color.rgb(red,green,blue));
            }
        });
    }
}
