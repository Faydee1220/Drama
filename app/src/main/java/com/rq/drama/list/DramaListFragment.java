package com.rq.drama.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rq.drama.MyApplication;
import com.rq.drama.R;
import com.rq.drama.model.Drama;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Faydee on 2018/6/27.
 */
public class DramaListFragment extends Fragment implements DramaListContract.View {

  private static final String TAG = DramaListFragment.class.getSimpleName();

  @BindView(R.id.recyclerView_drama_list) RecyclerView recyclerView;

  private DramaListContract.Presenter mPresenter;
  private Unbinder unbinder;
  private DramaListAdapter mAdapter;

  public DramaListFragment() { }

  public static DramaListFragment newInstance() {
    return new DramaListFragment();
  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_dramalist, container, false);
    unbinder = ButterKnife.bind(this, view);
    return view;
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    setRecyclerView();
    mPresenter.start();
  }

  private void setRecyclerView() {
    LinearLayoutManager layoutManager = new LinearLayoutManager(MyApplication.getAppContext());
    recyclerView.setLayoutManager(layoutManager);

    mAdapter = new DramaListAdapter(new ArrayList<>(), mPresenter);
    recyclerView.setAdapter(mAdapter);

    recyclerView.addItemDecoration(new DividerItemDecoration(
        MyApplication.getAppContext(), DividerItemDecoration.VERTICAL));
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }

  @Override public void setPresenter(DramaListContract.Presenter presenter) {
    mPresenter = checkNotNull(presenter);
  }

  @Override public void showDramaList(ArrayList<Drama> dramas) {
    mAdapter.updateDramas(dramas);
  }

  @Override public Fragment getFragment() {
    return this;
  }
}
