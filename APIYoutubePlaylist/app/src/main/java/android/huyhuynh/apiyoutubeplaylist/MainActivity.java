package android.huyhuynh.apiyoutubeplaylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

import org.json.JSONObject;

public class MainActivity extends YouTubeBaseActivity
                            implements YouTubePlayer.OnInitializedListener {

    String API_KEY = "AIzaSyAYJkqEdb7piE-2hZoSFIvnABbtnCrKfr8";
    String ID_LIST = "PLRjU0Pq1eItgFf1foKbjtwQjGgwEN8BLp";

    /*Get json playlist
    https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId={ID_LIST}&key={YOUR_API_KEY}&maxResults={Số video trả về tối đa là 50}
    */
    String urlGetJson = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLRjU0Pq1eItgFf1foKbjtwQjGgwEN8BLp&key=AIzaSyAYJkqEdb7piE-2hZoSFIvnABbtnCrKfr8&maxResults=30";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getJSONListPlay(urlGetJson);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
    //Get JSON List:
    private void getJSONListPlay(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(objectRequest);
    }
}
