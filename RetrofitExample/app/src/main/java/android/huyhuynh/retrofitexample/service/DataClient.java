package android.huyhuynh.retrofitexample.service;

import android.huyhuynh.retrofitexample.UserJetty;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Huy Huynh on 08/05/19.
 */
public interface DataClient {

    @FormUrlEncoded
    @POST("insertuser.php")
    Call<String> insertData(@Field("email") String email,
                            @Field("name") String name,
                            @Field("phone") String phone,
                            @Field("pass") String pass);


    @FormUrlEncoded
    @POST("login.php")
    Call<List<UserJetty>> getData(@Field("email") String email, @Field("pass") String pass);

    @GET("delete.php")
    Call<String> deleteData(@Query("id") String id);
}
