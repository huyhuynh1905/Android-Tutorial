package android.huyhuynh.apiyoutube;


import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;

public class MainActivity extends YouTubeBaseActivity {

    String API_KEY = "AIzaSyAUD_hrm-ZxChtofp4ORCYzImx38NQm61Q";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
