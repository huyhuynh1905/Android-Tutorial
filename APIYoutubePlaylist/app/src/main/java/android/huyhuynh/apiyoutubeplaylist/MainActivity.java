package android.huyhuynh.apiyoutubeplaylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends YouTubeBaseActivity
                            implements YouTubePlayer.OnInitializedListener {
    ListView lvVideo;
    AdapterVideo mAdapterVideo;
    List<VideoYouTube> arrVideo;

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
        init();
        getJSONListPlay(urlGetJson);
    }

    private void init() {
        //Khởi tạo
        lvVideo = findViewById(R.id.lvVideo);
        arrVideo = new ArrayList<>();
        mAdapterVideo = new AdapterVideo(this,R.layout.item_video_list,arrVideo);
        lvVideo.setAdapter(mAdapterVideo);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
    //Get JSON List:
    private void getJSONListPlay(final String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray arrJSONItem = response.getJSONArray("items");
                    String tittle = "";
                    String urlImage = "";
                    String idvideo = "";
                    for (int i=0;i<arrJSONItem.length();i++){
                        JSONObject objectItem = arrJSONItem.getJSONObject(i);
                        JSONObject objectSnippet = objectItem.getJSONObject("snippet");
                        tittle = objectSnippet.getString("title");
                        //Lấy ảnh nằm trong thumnails
                        JSONObject objectThumbnails = objectSnippet.getJSONObject("thumbnails");
                        JSONObject objectMedium = objectThumbnails.getJSONObject("medium");
                        urlImage = objectMedium.getString("url");
                        //Lấy id video
                        JSONObject objectResourceId = objectSnippet.getJSONObject("resourceId");
                        idvideo = objectResourceId.getString("videoId");
                        arrVideo.add(new VideoYouTube(tittle,urlImage,idvideo));
                    }
                    mAdapterVideo.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(objectRequest);
    }
}
