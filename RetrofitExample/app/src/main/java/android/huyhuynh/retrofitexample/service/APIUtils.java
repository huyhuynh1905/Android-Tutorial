package android.huyhuynh.retrofitexample.service;

/**
 * Created by Huy Huynh on 08/05/19.
 */
public class APIUtils {
    public final static String baseUrl = "http://192.168.1.102:8080/retrofit/";

    public static DataClient getData(){

        return RetrofitClient.getClient(baseUrl).create(DataClient.class);
    }
}
