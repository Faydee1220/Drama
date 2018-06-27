package com.rq.drama.detail;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Faydee on 2018/6/27.
 */
public class DramaDetailPresenter implements DramaDetailContract.Presenter {

  private DramaDetailContract.View mDramaDetailView;

  public DramaDetailPresenter(DramaDetailContract.View dramaDetailView) {
    mDramaDetailView = checkNotNull(dramaDetailView, "dramaDetailView cannot be null!");
    mDramaDetailView.setPresenter(this);
  }

  @Override public void start() {

  }
}
