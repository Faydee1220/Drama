package com.rq.drama.list;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestOptions;
import com.rq.drama.MyApplication;
import com.rq.drama.R;
import com.rq.drama.api.ApiDramaListManager;
import com.rq.drama.api.callback.DramaListCallback;
import com.rq.drama.database.AppDatabase;
import com.rq.drama.database.AppExecutors;
import com.rq.drama.model.Drama;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Faydee on 2018/6/27.
 */
public class DramaListPresenter implements DramaListContract.Presenter {

  private static final String TAG = DramaListPresenter.class.getSimpleName();

  private DramaListContract.View mDramaListView;

  public DramaListPresenter(DramaListContract.View dramaListView) {
    mDramaListView = checkNotNull(dramaListView, "dramaListView cannot be null!");
    mDramaListView.setPresenter(this);
  }

  @Override public void start() {
    loadDramaList();
  }

  @Override public void loadDramaList() {
    dbGetDramaList();
    apiGetDramaList();
  }

  private void dbGetDramaList() {
    AppExecutors.getInstance().diskIO().execute(() -> {
      List<Drama> dramas = AppDatabase.getInstance().dramaDao().loadAllDramas();
      if (dramas.size() > 0) {
        mDramaListView.showDramaList(new ArrayList<>(dramas));
      }
    });
  }

  private void apiGetDramaList() {
    ApiDramaListManager.getInstance().getDramaList(new DramaListCallback() {
      @Override public void success(ArrayList<Drama> dramas) {
        mDramaListView.showDramaList(dramas);
      }

      @Override public void failure(String message) {

      }
    });
  }

  @Override public void loadThumb(Drama drama, ImageView imageView) {
    RequestOptions options = new RequestOptions();
    options = options.placeholder(R.drawable.ic_live_tv);
    options = options.centerInside();

    if (drama.imageData == null) {
      //Log.d(TAG, "no imageData");
      Glide.with(mDramaListView.getFragment())
          .load(drama.imageUrl)
          .thumbnail(0.25f)
          .apply(options)
          .into(imageView);

      saveImageData(drama);
    } else {
      //Log.d(TAG, "has imageData");
      Glide.with(mDramaListView.getFragment())
          .load(drama.imageData)
          .thumbnail(0.25f)
          .apply(options)
          .into(imageView);
    }
  }

  private void saveImageData(Drama drama) {
    AppExecutors.getInstance().diskIO().execute(() -> {
      FutureTarget<Bitmap> futureTarget = Glide
          .with(MyApplication.getAppContext())
          .asBitmap()
          .load(drama.imageUrl)
          .submit();

      try {
        Bitmap bitmap = futureTarget.get();
        drama.imageData = getBytesFromBitmap(bitmap);
        AppDatabase.getInstance().dramaDao().updateDrama(drama);
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }

      Glide.with(MyApplication.getAppContext()).clear(futureTarget);
    });
  }

  private byte[] getBytesFromBitmap(Bitmap bitmap) {
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
    return stream.toByteArray();
  }

}
