package com.rq.drama.list;

import com.rq.drama.api.ApiDramaListManager;
import com.rq.drama.api.callback.DramaListCallback;
import com.rq.drama.model.Drama;
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
    ApiDramaListManager.getInstance().getDramaList(new DramaListCallback() {
      @Override public void success(List<Drama> dramas) {

      }

      @Override public void failure(String message) {

      }
    });
  }
}
