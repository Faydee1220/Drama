package com.rq.drama.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.rq.drama.model.Drama;
import java.util.List;

/**
 * Created by Faydee on 2018/6/27.
 */
@Dao
public interface DramaDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  long[] insertDramas(List<Drama> dramaEntries);

  @Query("SELECT * FROM drama")
  List<Drama> loadAllDramas();

  @Query("SELECT * FROM drama WHERE id = :id")
  Drama loadDramaById(long id);

  @Query("DELETE FROM drama")
  void deleteAllDramas();
}
