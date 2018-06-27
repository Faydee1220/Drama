package com.rq.drama.main;

import com.rq.drama.BasePresenter;
import com.rq.drama.BaseView;
import com.rq.drama.model.Drama;

/**
 * Created by Faydee on 2018/6/27.
 */
public interface MainContract {
  interface Presenter extends BasePresenter {
    void goToDramaList();
    void goToDramaDetail();
  }

  interface View extends BaseView<Presenter> {
    void showDramaDetail(Drama drama);
  }
}
