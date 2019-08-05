package android.huyhuynh.retrofitexample.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Huy Huynh on 08/05/19.
 */
public class RetrofitClient  {
    private static Retrofit sRetrofit = null;
    public static Retrofit getClient(String baseUrl){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                        .readTimeout(5000,TimeUnit.MILLISECONDS) //Thời gian đọc
                                        .writeTimeout(5000,TimeUnit.MILLISECONDS) //thời gian viết
                                        .connectTimeout(10000, TimeUnit.MILLISECONDS) //Thời gian kết nối lại
                                        .retryOnConnectionFailure(true)
                                        .build();
        Gson gson = new GsonBuilder().setLenient().create(); //Hỗ trợ convert gson
        sRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return sRetrofit;
    }
}
