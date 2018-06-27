package com.rq.drama.database.entry;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Faydee on 2018/6/27.
 */
@Entity(tableName = "drama")
public class DramaEntry {

  @PrimaryKey(autoGenerate = true)
  public long id;

  public String name;

  @ColumnInfo(name = "total_views")
  public long totalViews;

  @ColumnInfo(name = "created_at")
  public String createdAt;

  public String thumb;

  public float rating;
}
