package com.rq.drama.list;

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

  }
}
