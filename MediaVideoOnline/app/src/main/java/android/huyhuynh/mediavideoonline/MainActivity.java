package android.huyhuynh.mediavideoonline;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button btnVideo;
    VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVideo = findViewById(R.id.btnVideo);
        mVideoView = findViewById(R.id.videoView);
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://khoapham.vn/download/vuoncaovietnam.mp4");
                mVideoView.setVideoURI(uri);
                //Set bảng điều khiển
                mVideoView.setMediaController(new MediaController(MainActivity.this));
                mVideoView.start();
            }
        });
    }
}
