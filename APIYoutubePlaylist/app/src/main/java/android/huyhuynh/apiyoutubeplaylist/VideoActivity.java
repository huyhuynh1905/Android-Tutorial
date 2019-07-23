package android.huyhuynh.apiyoutubeplaylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener {

    String idvideoselect;
    int REQUEST_ERR = 12;
    YouTubePlayerView mYouTubePlayerView;
    String API = MainActivity.API_KEY;
    String idVideo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        mYouTubePlayerView = findViewById(R.id.playVideo);
        Intent intent = getIntent();
        idVideo = intent.getStringExtra("ID");
        mYouTubePlayerView.initialize(API,this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(idVideo);
        youTubePlayer.setFullscreen(true);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(VideoActivity.this,REQUEST_ERR);
        } else {
            Toast.makeText(VideoActivity.this,"ERR",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==REQUEST_ERR){
            mYouTubePlayerView.initialize(API,this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
