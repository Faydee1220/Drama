package com.rq.drama.list;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rq.drama.R;
import com.rq.drama.api.ApiDramaListManager;
import com.rq.drama.api.callback.DramaListCallback;
import com.rq.drama.database.AppDatabase;
import com.rq.drama.database.AppExecutors;
import com.rq.drama.model.Drama;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Faydee on 2018/6/27.
 */
public class DramaListPresenter implements DramaListContract.Presenter {

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
    AppExecutors.getInstance().diskIO().execute(new Runnable() {
      @Override public void run() {
        List<Drama> dramas = AppDatabase.getInstance().dramaDao().loadAllDramas();
        if (dramas.size() > 0) {
          mDramaListView.showDramaList(new ArrayList<>(dramas));
        }
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

  @Override public void loadThumb(String url, ImageView imageView) {
    RequestOptions options = new RequestOptions();
    options = options.placeholder(R.drawable.ic_live_tv);
    Glide.with(mDramaListView.getFragment())
        .load(url)
        .apply(options)
        .into(imageView);
  }
}
