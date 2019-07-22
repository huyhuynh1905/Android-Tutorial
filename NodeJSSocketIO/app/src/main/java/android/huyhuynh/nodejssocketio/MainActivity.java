package android.huyhuynh.nodejssocketio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class MainActivity extends AppCompatActivity {

    Socket mSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectIO();
    }
    private void connectIO(){
        try {
            mSocket = IO.socket("http://192.168.1.102:3000/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        mSocket.connect();

    }
}
