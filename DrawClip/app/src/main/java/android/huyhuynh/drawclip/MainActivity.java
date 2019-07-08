package android.huyhuynh.drawclip;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnUp;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        btnUp = findViewById(R.id.btnUp);
        imgView = findViewById(R.id.imgView);
        //
        final ClipDrawable clipDrawable = (ClipDrawable) imgView.getDrawable();
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int time = clipDrawable.getLevel();
                        if (time>=10000){
                            time=0;
                        }
                        imgView.setImageLevel(time+1000);
                        handler.postDelayed(this,500);
                    }
                },1000);

            }
        });
    }
}
