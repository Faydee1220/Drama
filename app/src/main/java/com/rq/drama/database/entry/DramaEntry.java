package com.rq.drama.database.entry;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import com.rq.drama.model.Drama;

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

  @ColumnInfo(name = "image_url")
  public String imageUrl;

  public float rating;

  @ColumnInfo(name = "image_data",
      typeAffinity = ColumnInfo.BLOB)
  public byte[] imageData;

  @Ignore
  public DramaEntry(Drama drama) {
    id = drama.id;
    name = drama.name;
    totalViews = drama.totalViews;
    createdAt = drama.createdAt;
    imageUrl = drama.imageUrl;
    rating = drama.rating;
  }

  public DramaEntry() {
  }
}
