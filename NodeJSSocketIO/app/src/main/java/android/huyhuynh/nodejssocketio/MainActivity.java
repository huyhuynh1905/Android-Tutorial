package android.huyhuynh.nodejssocketio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity {
    Button btnAdd,btnSend;
    ListView lvUser,lvChat;
    ArrayList<String> arrUser, arrChat;
    ArrayAdapter<String> adapterUser, adapterChat;
    EditText edtChat;

    Socket mSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        connectIO();
        //Thread chạy nhận thông tin từ server
        mSocket.on("server-register",onReceiveRegister);
        //Thread lấy danh sách user
        mSocket.on("server-send-user",onReceiveUsers);
        //Thread lấy tin nhắn về:
        mSocket.on("server-send-message",onReceiveMessage);
        //Đăng kí user
        registerUser();
        //gửi tin nhắn
        sendMessage();

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
        edtChat = findViewById(R.id.edtContent);
        btnAdd = findViewById(R.id.btnAdd);
        btnSend = findViewById(R.id.btnSend);
        lvChat = findViewById(R.id.lvChat);
        lvUser = findViewById(R.id.lvUser);
        arrUser = new ArrayList<>();
        arrChat = new ArrayList<>();
        adapterChat = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1
        ,arrChat);
        adapterUser = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1
        ,arrUser);
        lvUser.setAdapter(adapterUser);
        lvChat.setAdapter(adapterChat);
    }

    private Emitter.Listener onReceiveRegister = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            //Khởi tạo thread để có thể nhận tin từ server từ iu liên tục
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try {
                        boolean kiemtra = object.getBoolean("ketqua");
                        if (kiemtra){
                            Toast.makeText(MainActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Đăng kí thất bại", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    };
    //Cập nhật danh sách user
    private  Emitter.Listener onReceiveUsers = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try {
                        arrUser.clear();
                        JSONArray jsonArr = object.getJSONArray("users");
                        for (int i =0 ;i<jsonArr.length();i++){
                            String userGet = jsonArr.getString(i);
                            arrUser.add(userGet);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    adapterUser.notifyDataSetChanged();
                }
            });
        }
    };
    //Cập nhật tin nhắn các user từ server:
    private Emitter.Listener onReceiveMessage = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject object = (JSONObject) args[0];
                    try {
                        String mess = object.getString("content");
                        arrChat.add(mess);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    adapterChat.notifyDataSetChanged();
                }
            });
        }
    };
    //event đăng kí user:
    public void registerUser(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtChat.getText().toString().trim().length()==0){
                    Toast.makeText(MainActivity.this,"Nhập user!",Toast.LENGTH_SHORT).show();
                } else {
                    mSocket.emit("client-register",edtChat.getText().toString().trim());
                }
                edtChat.setText("");
            }
        });
    }
    //event gửi tin nhắn chat
    private void sendMessage(){
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtChat.getText().toString().trim().length()==0){
                    Toast.makeText(MainActivity.this,"Nhập user!",Toast.LENGTH_SHORT).show();
                } else {
                    mSocket.emit("client-chat",edtChat.getText().toString().trim());
                }
                edtChat.setText("");
            }
        });
    }
}
