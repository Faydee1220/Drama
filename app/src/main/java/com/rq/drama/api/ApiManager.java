package com.rq.drama.api;

import android.support.annotation.NonNull;
import com.rq.drama.api.service.DramaListService;
import okhttp3.OkHttpClient;
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
  public DramaListService dramaListService;

  private ApiManager() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL + API_VERSION)
        .addConverterFactory(GsonConverterFactory.create())
        .client(getClient())
        .build();

    dramaListService = retrofit.create(DramaListService.class);
  }

  @NonNull
  private OkHttpClient getClient() {
    OkHttpClient.Builder builder = new OkHttpClient.Builder();

    // 需要查看 Call API 的 Log 時才打開
    //HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    //interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    //builder.addInterceptor(interceptor);

    return builder.build();
  }
}
