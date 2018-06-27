package com.rq.drama.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
  public String imageUrl;

  @SerializedName("rating")
  @Expose
  public float rating;

  public String getRatingString() {
    NumberFormat format = NumberFormat.getNumberInstance();
    format.setMaximumFractionDigits(1);
    format.setMinimumFractionDigits(0);
    format.setMinimumIntegerDigits(1);
    return format.format(rating);
  }

  public String getCreatedAtString() {
    SimpleDateFormat format = new SimpleDateFormat(
        "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
    try {
      Date date = format.parse(createdAt);
      SimpleDateFormat newFormat = new SimpleDateFormat(
          "yyyy.MM.dd", Locale.getDefault()
      );
      return "出版日期：" + newFormat.format(date);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return "";
  }
}
