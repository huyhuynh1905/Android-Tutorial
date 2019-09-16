package android.huyhuynh.retrofitadvanced.retrofit2;

import android.huyhuynh.retrofitadvanced.Menu;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Huy Huynh on 09/05/19.
 */
public interface DataClient {

    @Multipart
    @POST("uploadanh")
    Call<String> UploadPhoto(@Part MultipartBody.Part photo);

    @FormUrlEncoded
    @POST("menu/get")
    Call<List<Menu>> getListMenu(@Field("maBan") String maBan);
}
