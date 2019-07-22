package android.huyhuynh.nodejssocketio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity {
    Button btnConnect;

    Socket mSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        connectIO();
        //Đợi tin nhắn từ server gửi về:
        mSocket.on("server-send-data",onReceiveData);

    }

    //Khởi tạo kết nối server
    private void connectIO(){
        try {
            mSocket = IO.socket("http://192.168.1.102:3000/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //kết nối
        mSocket.connect();

    }

    private void init(){
    }

    private Emitter.Listener onReceiveData = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            //Khởi tạo thread để có thể nhận tin từ server từ iu liên tục
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try {
                        String ten = object.getString("noidung");
                        Toast.makeText(MainActivity.this,ten,Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };
}
