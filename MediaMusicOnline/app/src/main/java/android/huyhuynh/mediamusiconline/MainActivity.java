package android.huyhuynh.mediamusiconline;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.rtp.AudioStream;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btnMusic;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMusic = findViewById(R.id.btnMusic);
        mProgressBar = findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.GONE);
        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String url = "https://upload.wikimedia.org/wikipedia/commons/transcoded/7/73/United_States_Navy_Band_-_Ti%E1%BA%BFn_Qu%C3%A2n_Ca.ogg/United_States_Navy_Band_-_Ti%E1%BA%BFn_Qu%C3%A2n_Ca.ogg.mp3";
                String url = "https://khoapham.vn/download/vietnamoi.mp3";
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                try {
                    mediaPlayer.setDataSource(url);
                    mediaPlayer.prepareAsync();
                    mProgressBar.setVisibility(View.VISIBLE);
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mProgressBar.setVisibility(View.GONE);
                            mediaPlayer.start();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
