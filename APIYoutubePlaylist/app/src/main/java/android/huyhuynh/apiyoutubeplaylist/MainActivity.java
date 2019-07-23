package android.huyhuynh.apiyoutubeplaylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

public class MainActivity extends YouTubeBaseActivity
                            implements YouTubePlayer.OnInitializedListener {

    String API_KEY = "AIzaSyAYJkqEdb7piE-2hZoSFIvnABbtnCrKfr8";
    String ID_LIST = "PLRjU0Pq1eItgFf1foKbjtwQjGgwEN8BLp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
