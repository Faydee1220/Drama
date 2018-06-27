package com.rq.drama.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Faydee on 2018/6/27.
 */
public class Drama {

  @SerializedName("drama_id")
  @Expose
  public long id;

  @SerializedName("name")
  @Expose
  public String name;

  @SerializedName("total_views")
  @Expose
  public long totalViews;

  @SerializedName("created_at")
  @Expose
  public String createdAt;

  @SerializedName("thumb")
  @Expose
  public String thumb;

  @SerializedName("rating")
  @Expose
  public float rating;
}
