package com.rq.drama.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
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
@Entity(tableName = "drama")
public class Drama {

  @PrimaryKey(autoGenerate = true)
  @SerializedName("drama_id")
  @Expose
  public long id;

  @SerializedName("name")
  @Expose
  public String name;

  @ColumnInfo(name = "total_views")
  @SerializedName("total_views")
  @Expose
  public long totalViews;

  @ColumnInfo(name = "created_at")
  @SerializedName("created_at")
  @Expose
  public String createdAt;

  @ColumnInfo(name = "image_url")
  @SerializedName("thumb")
  @Expose
  public String imageUrl;

  @SerializedName("rating")
  @Expose
  public float rating;

  @ColumnInfo(name = "image_data",
      typeAffinity = ColumnInfo.BLOB)
  public byte[] imageData;

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

  public Drama() {

  }
}
