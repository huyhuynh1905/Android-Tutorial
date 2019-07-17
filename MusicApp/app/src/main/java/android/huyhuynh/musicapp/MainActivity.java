package android.huyhuynh.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageButton btnBack, btnNext, btnPlay, btnStop;
    TextView txtNameSong, txtStart, txtEnd;
    SeekBar seekBar;
    ArrayList<Song> arrSong;
    MediaPlayer mMediaPlayer;
    ImageView imgCd;
    Animation mAnimation;
    int posison = 0;
    int curretn = 0;
    SharedPreferences sharedPre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        creatMediaInit();
        seekBarOption();

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
                nextTheSong();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.stop();
                mMediaPlayer.release();
                btnPlay.setImageResource(R.drawable.play);
                creatMediaInit();
                mAnimation.cancel();
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
                updateTimeSong();
                imgCd.startAnimation(mAnimation);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = sharedPre.edit();
        editor.putInt("current",mMediaPlayer.getCurrentPosition());
        editor.putInt("posion",posison);
        editor.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences.Editor editor = sharedPre.edit();
        editor.putInt("current", mMediaPlayer.getCurrentPosition());
        editor.putInt("posion", posison);
        editor.commit();
    }

    private void saveSong() {
        sharedPre = getSharedPreferences("saveSong",MODE_PRIVATE);

        //load
        posison = (int) sharedPre.getInt("posion",0);
        curretn = (int) sharedPre.getInt("current",0);

    }

    private void nextTheSong() {
        if (posison==arrSong.size()-1){
            posison=0;
        } else posison=posison+1;
        if (mMediaPlayer.isPlaying()) mMediaPlayer.stop();
        creatMediaInit();
        mMediaPlayer.start();
        btnPlay.setImageResource(R.drawable.pause);
    }

    private void updateTimeSong(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat format = new SimpleDateFormat("mm:ss");
                txtStart.setText(format.format(mMediaPlayer.getCurrentPosition()));
                seekBar.setProgress(mMediaPlayer.getCurrentPosition());
                //kiểm tra bài hát hoàn tất
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        nextTheSong();
                    }
                });

                handler.postDelayed(this,500);
            }
        },100);
    }
    private void seekBarOption(){
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int current = seekBar.getProgress();
                mMediaPlayer.seekTo(current);
            }
        });
    }
    private void setDurationSong(){
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
        txtEnd.setText(format.format(mMediaPlayer.getDuration()));
        txtStart.setText(format.format(curretn));
        seekBar.setMax(mMediaPlayer.getDuration());
        seekBar.setProgress(curretn);
    }
    private void creatMediaInit(){
        mMediaPlayer = MediaPlayer.create(MainActivity.this,arrSong.get(posison).getFile());
        txtNameSong.setText(arrSong.get(posison).getNameSong());
        setDurationSong();
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
        imgCd = findViewById(R.id.imgCd);

        //
        saveSong();
        arrSong = new ArrayList<>();
        arrSong.add(new Song("Con Trai Cưng",R.raw.con_trai_cung));
        arrSong.add(new Song("Đừng Quên Tên Anh",R.raw.dung_quen_ten_anh));
        arrSong.add(new Song("Lỡ Thương Một Người",R.raw.lo_thuong_mot_nguoi));
        //
        mAnimation = AnimationUtils.loadAnimation(this,R.anim.cd_custom_rotate);
    }
}
