package com.rq.drama.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.rq.drama.R;
import com.rq.drama.model.Drama;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity implements MainContract.View {

  private static final String TAG = MainActivity.class.getSimpleName();

  private MainContract.Presenter mPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mPresenter = new MainPresenter(this, getSupportFragmentManager());
    mPresenter.start();
  }

  @Override public void setPresenter(MainContract.Presenter presenter) {
    mPresenter = checkNotNull(presenter);
  }

  @Override public void showDramaDetail(Drama drama) {
    mPresenter.goToDramaDetail();
  }

  @Override public void popBackStack() {
    mPresenter.popBack();
  }
}
