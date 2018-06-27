package com.rq.drama.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rq.drama.R;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Faydee on 2018/6/27.
 */
public class DramaDetailFragment extends Fragment implements DramaDetailContract.View {

  private static final String TAG = DramaDetailFragment.class.getSimpleName();

  private DramaDetailContract.Presenter mPresenter;
  private Unbinder unbinder;

  public DramaDetailFragment() { }

  public static DramaDetailFragment newInstance() {
    return new DramaDetailFragment();
  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_drama_detail, container, false);
    unbinder = ButterKnife.bind(this, view);
    return view;
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }

  @Override public void setPresenter(DramaDetailContract.Presenter presenter) {
    mPresenter = checkNotNull(presenter);
  }
}
