package com.rq.drama;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * Created by Faydee on 2018/6/27.
 */
public class MyApplication extends Application {
  @SuppressLint("StaticFieldLeak")
  private static Context context;

  @Override
  public void onCreate() {
    super.onCreate();
    context = this;
  }

  public static Context getAppContext() {
    return context;
  }
}
