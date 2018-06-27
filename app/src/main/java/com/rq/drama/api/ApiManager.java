package com.rq.drama.api;

import android.support.annotation.NonNull;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.rq.drama.model.Constant.API_VERSION;
import static com.rq.drama.model.Constant.BASE_URL;

/**
 * Created by Faydee on 2018/6/27.
 */
public class ApiManager {
  private static final ApiManager ourInstance = new ApiManager();

  public static ApiManager getInstance() {
    return ourInstance;
  }

  private ApiManager() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL + API_VERSION)
        .client(getClient())
        .build();
  }

  @NonNull
  private OkHttpClient getClient() {
    OkHttpClient.Builder builder = new OkHttpClient.Builder();

    // 需要查看 Call API 的 Log 時才打開
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    builder.addInterceptor(interceptor);

    return builder.build();
  }
}
