package com.rq.drama.main;

import android.support.v4.app.FragmentManager;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Faydee on 2018/6/27.
 */
public class MainPresenter implements MainContract.Presenter {

  private static final String TAG = MainPresenter.class.getSimpleName();

  private MainContract.View mMainView;
  private FragmentManager mFragmentManager;

  public MainPresenter(MainContract.View view, FragmentManager fragmentManager) {
    mMainView = checkNotNull(view, "mainView cannot be null!");
    mMainView.setPresenter(this);
    mFragmentManager = fragmentManager;
  }

  @Override public void start() {

  }
}
