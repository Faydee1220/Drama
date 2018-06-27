package com.rq.drama.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.util.Log;
import com.rq.drama.MyApplication;
import com.rq.drama.database.entry.DramaEntry;

/**
 * Created by Faydee on 2018/6/27.
 */
@Database(entities = {
    DramaEntry.class},
    version = 1,
    exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

  private static final String TAG = AppDatabase.class.getSimpleName();
  private static final Object LOCK = new Object();
  private static final String DATABASE_NAME = "myDrama";
  private static AppDatabase sInstance;

  public static AppDatabase getInstance() {
    if (sInstance == null) {
      synchronized (LOCK) {
        //Log.d(TAG, "Creating new database instance");
        sInstance = Room.databaseBuilder(
            MyApplication.getAppContext(),
            AppDatabase.class,
            AppDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build();
      }
    }
    //Log.d(TAG, "Getting the database instance");
    return sInstance;
  }
}
