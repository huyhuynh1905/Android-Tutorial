package android.huyhuynh.retrofitadvanced.retrofit2;

import okhttp3.MultipartBody;
import retrofit2.Call;
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
}
