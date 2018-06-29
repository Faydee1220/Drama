package com.rq.drama.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.rq.drama.databinding.ItemDramaListBinding;
import com.rq.drama.model.Drama;
import java.util.ArrayList;

/**
 * Created by Faydee on 2018/6/27.
 */
public class DramaListAdapter extends RecyclerView.Adapter<DramaListAdapter.DramaListViewHolder> {

  private static final String TAG = DramaListAdapter.class.getSimpleName();

  private ArrayList<Drama> mDramas;
  private DramaListContract.Presenter mPresenter;
  private DramaListContract.View mView;

  public DramaListAdapter(ArrayList<Drama> dramas,
      DramaListContract.Presenter presenter,
      DramaListContract.View view) {
    mDramas = dramas;
    mPresenter = presenter;
    mView = view;
  }

  public void updateDramas(ArrayList<Drama> dramas) {
    mDramas = dramas;
    notifyDataSetChanged();
  }

  class DramaListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ItemDramaListBinding mBinding;
    private SparseArray<String> binds = new SparseArray<>();

    DramaListViewHolder(ItemDramaListBinding binding) {
      super(binding.getRoot());
      mBinding = binding;
      mBinding.getRoot().setOnClickListener(this);
    }

    private void bind(Drama drama) {
      mBinding.setDrama(drama);
      if (binds.get(getAdapterPosition()) == null
          || !binds.get(getAdapterPosition()).equals(drama.imageUrl)) {
        binds.put(getAdapterPosition(), drama.imageUrl);
        mPresenter.loadThumb(drama, mBinding.imageViewDramaList);
      }
      mBinding.executePendingBindings();
    }

    @Override public void onClick(View view) {
      Log.d(TAG, "onClick: " + getAdapterPosition());
      mView.showDramaDetail(mDramas.get(getAdapterPosition()));
    }
  }

  @NonNull @Override
  public DramaListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,
      int i) {
    LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
    ItemDramaListBinding binding = ItemDramaListBinding
        .inflate(inflater, viewGroup, false);
    return new DramaListViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull DramaListViewHolder dramaListViewHolder,
      int i) {
    dramaListViewHolder.bind(mDramas.get(i));
  }

  @Override public int getItemCount() {
    return mDramas.size();
  }

}
