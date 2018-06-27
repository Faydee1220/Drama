package com.rq.drama.main;

import com.rq.drama.BasePresenter;
import com.rq.drama.BaseView;

/**
 * Created by Faydee on 2018/6/27.
 */
public interface MainContract {
  interface Presenter extends BasePresenter {

  }

  interface View extends BaseView<Presenter> {

  }
}
