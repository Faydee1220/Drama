package com.rq.drama.main;

import android.support.annotation.StringDef;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.rq.drama.R;
import com.rq.drama.detail.DramaDetailFragment;
import com.rq.drama.detail.DramaDetailPresenter;
import com.rq.drama.list.DramaListContract;
import com.rq.drama.list.DramaListFragment;
import com.rq.drama.list.DramaListPresenter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Faydee on 2018/6/27.
 */
public class MainPresenter implements MainContract.Presenter {

  private static final String TAG = MainPresenter.class.getSimpleName();

  private MainContract.View mMainView;
  private FragmentManager mFragmentManager;

  @Retention(RetentionPolicy.SOURCE)
  @StringDef({
      DRAMA_LIST, DRAMA_DETAIL
  })
  public @interface FragmentType {
  }
  static final String DRAMA_LIST = "DRAMA_LIST";
  static final String DRAMA_DETAIL = "DRAMA_DETAIL";

  private DramaListFragment mDramaListFragment;
  private DramaListContract.Presenter mDramaListPresenter;

  MainPresenter(MainContract.View view, FragmentManager fragmentManager) {
    mMainView = checkNotNull(view, "mainView cannot be null!");
    mMainView.setPresenter(this);
    mFragmentManager = fragmentManager;
  }

  @Override public void start() {
    goToDramaList();
  }

  @Override public void goToDramaList() {
    FragmentTransaction transaction = mFragmentManager.beginTransaction();
    if (mDramaListFragment == null) {
      mDramaListFragment = DramaListFragment.newInstance();
    }
    if (mDramaListPresenter == null) {
      mDramaListPresenter = new DramaListPresenter(mDramaListFragment);
    }
    if (!mDramaListFragment.isAdded()) {
      transaction.add(R.id.frameLayout_main_container, mDramaListFragment, DRAMA_LIST);
    } else {
      transaction.show(mDramaListFragment);
    }
    transaction.commit();
  }

  @Override public void goToDramaDetail() {
    FragmentTransaction transaction = mFragmentManager.beginTransaction();
    addSlideAnimation(transaction);
    if (mDramaListFragment != null && !mDramaListFragment.isHidden()) {
      transaction.hide(mDramaListFragment);
      transaction.addToBackStack(DRAMA_LIST);
    }
    DramaDetailFragment dramaDetailFragment = DramaDetailFragment.newInstance();
    DramaDetailPresenter presenter = new DramaDetailPresenter(dramaDetailFragment);
    transaction.add(R.id.frameLayout_main_container, dramaDetailFragment, DRAMA_DETAIL);
    transaction.commit();
  }

  private void addSlideAnimation(FragmentTransaction transaction) {
    transaction.setCustomAnimations(
        R.animator.slide_right_in,
        R.animator.slide_left_out,
        R.animator.slide_left_in,
        R.animator.slide_right_out
    );
  }
}
