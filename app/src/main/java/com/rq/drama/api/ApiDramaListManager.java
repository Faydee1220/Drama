package com.rq.drama.api;

import android.util.Log;
import com.rq.drama.api.callback.DramaListCallback;
import com.rq.drama.api.response.Result;
import com.rq.drama.database.AppDatabase;
import com.rq.drama.database.AppExecutors;
import com.rq.drama.model.Drama;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Faydee on 2018/6/27.
 */
public class ApiDramaListManager {

  private static final String TAG = ApiDramaListManager.class.getSimpleName();

  private static final ApiDramaListManager ourInstance = new ApiDramaListManager();

  public static ApiDramaListManager getInstance() {
    return ourInstance;
  }

  private ApiDramaListManager() {
  }

  // region - Request
  public void getDramaList(DramaListCallback callback) {
    Call<Result<List<Drama>>> call = ApiManager.getInstance()
        .dramaListService
        .getDramaList();

    call.enqueue(new Callback<Result<List<Drama>>>() {
      @Override
      public void onResponse(Call<Result<List<Drama>>> call,
          Response<Result<List<Drama>>> response) {
        //Log.d(TAG, "getDramaList onResponse");
        if (!response.isSuccessful()) {
          Log.d(TAG, "response is not successful, code: " + response.code());
        } else {
          //Log.d(TAG, "getDramaList success");
          Result<List<Drama>> result = response.body();
          if (result != null && result.data != null) {
            checkDatabase(result.data, callback);
          }
        }
      }

      @Override public void onFailure(Call<Result<List<Drama>>> call, Throwable t) {
        Log.d(TAG, "getDramaList onFailure: " + t.getLocalizedMessage());
        callback.failure(t.getLocalizedMessage());
      }
    });
  }
  // endregion

  // region - Response
  private void checkDatabase(List<Drama> dramas, DramaListCallback callback) {
    AppExecutors.getInstance().diskIO().execute(new Runnable() {
      @Override public void run() {
        for (Drama drama : dramas) {
          Drama dramaFromDb = AppDatabase.getInstance().dramaDao().loadDramaById(drama.id);
          if (dramaFromDb == null) {
            //Log.d(TAG, "new drama");
            AppDatabase.getInstance().dramaDao().insertDrama(drama);
          } else {
            //Log.d(TAG, "old drama");
            if (drama.imageUrl.equals(dramaFromDb.imageUrl)) {
              drama.imageData = dramaFromDb.imageData;
            }
            AppDatabase.getInstance().dramaDao().updateDrama(drama);
          }
        }
        callback.success(new ArrayList<>(AppDatabase.getInstance().dramaDao().loadAllDramas()));
      }
    });

  }
  // endregion
}
