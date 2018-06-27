package com.rq.drama.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.rq.drama.R;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Faydee on 2018/6/27.
 */
public class DramaListFragment extends Fragment implements DramaListContract.View {

  private DramaListContract.Presenter mPresenter;

  public DramaListFragment() {}

  public static DramaListFragment newInstance() {
    return new DramaListFragment();
  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_dramalist, container, false);
    return view;
  }

  @Override public void setPresenter(DramaListContract.Presenter presenter) {
    mPresenter = checkNotNull(presenter);
  }
}
