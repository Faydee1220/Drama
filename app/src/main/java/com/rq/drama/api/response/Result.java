package com.rq.drama.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Faydee on 2018/6/27.
 */
public class Result<T> {
  @SerializedName("data")
  @Expose
  public T data;
}
