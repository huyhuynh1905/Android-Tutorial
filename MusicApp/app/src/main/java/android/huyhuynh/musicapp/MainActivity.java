package android.huyhuynh.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageButton btnBack, btnNext, btnPlay, btnStop;
    TextView txtNameSong, txtStart, txtEnd;
    SeekBar seekBar;
    ArrayList<Song> arrSong;
    MediaPlayer mMediaPlayer;
    int posison = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        creatMediaInit();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (posison==0){
                    posison=arrSong.size()-1;
                } else posison=posison-1;
                if (mMediaPlayer.isPlaying()) mMediaPlayer.stop();
                creatMediaInit();
                mMediaPlayer.start();
                btnPlay.setImageResource(R.drawable.pause);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (posison==arrSong.size()-1){
                    posison=0;
                } else posison=posison+1;
                if (mMediaPlayer.isPlaying()) mMediaPlayer.stop();
                creatMediaInit();
                mMediaPlayer.start();
                btnPlay.setImageResource(R.drawable.pause);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.stop();
                mMediaPlayer.release();
                btnPlay.setImageResource(R.drawable.play);
                creatMediaInit();
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mMediaPlayer.isPlaying()){
                    mMediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.play);
                } else {
                    mMediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.pause);
                }
            }
        });
    }

    private void creatMediaInit(){
        mMediaPlayer = MediaPlayer.create(MainActivity.this,arrSong.get(posison).getFile());
        txtNameSong.setText(arrSong.get(posison).getNameSong());
    }

    private void init() {
        seekBar = findViewById(R.id.seekBar);
        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);
        btnPlay = findViewById(R.id.btnPlay);
        btnStop = findViewById(R.id.btnStop);
        txtNameSong = findViewById(R.id.txtNameSong);
        txtEnd = findViewById(R.id.txtEnd);
        txtStart = findViewById(R.id.txtStart);

        //
        arrSong = new ArrayList<>();
        arrSong.add(new Song("Con Trai Cưng",R.raw.con_trai_cung));
        arrSong.add(new Song("Đừng Quên Tên Anh",R.raw.dung_quen_ten_anh));
        arrSong.add(new Song("Lỡ Thương Một Người",R.raw.lo_thuong_mot_nguoi));
    }
}
