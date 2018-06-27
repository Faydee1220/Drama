package com.rq.drama.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.rq.drama.R;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity implements MainContract.View {

  private static final String TAG = MainActivity.class.getSimpleName();

  private MainContract.Presenter mPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override public void setPresenter(MainContract.Presenter presenter) {
    mPresenter = checkNotNull(presenter);
  }
}
