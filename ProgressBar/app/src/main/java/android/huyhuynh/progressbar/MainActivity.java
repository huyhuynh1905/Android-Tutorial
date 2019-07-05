package android.huyhuynh.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnStart;
    ProgressBar progress2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        progress2 = findViewById(R.id.progressBar3);
        progress2.setProgress(0);
        progress2.setSecondaryProgress(0);

        //
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountDownTimer countDownTimer = new CountDownTimer(10000,1000) {
                    @Override
                    public void onTick(long l) {
                        int current = progress2.getProgress() + 10;
                        if (current > progress2.getMax()) current = 0;
                        progress2.setProgress(current);
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity.this,"End!",Toast.LENGTH_SHORT).show();
                    }
                }.start();
            }
        });
    }
}
