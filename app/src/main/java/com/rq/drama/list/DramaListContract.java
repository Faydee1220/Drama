package com.rq.drama.list;

import com.rq.drama.BasePresenter;
import com.rq.drama.BaseView;

/**
 * Created by Faydee on 2018/6/27.
 */
public interface DramaListContract {
  interface Presenter extends BasePresenter {
    void loadDramaList();
  }

  interface View extends BaseView<Presenter> {
    void showDramaList();
  }
}
