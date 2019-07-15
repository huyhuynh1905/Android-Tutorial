package android.huyhuynh.medialocalvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button btnPlay;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPlay = findViewById(R.id.btnPlay);
        videoView = findViewById(R.id.videoView);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+
                        R.raw.intro));
                videoView.start();
            }
        });
    }
}
