package com.rq.drama.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.rq.drama.databinding.ItemDramaListBinding;

/**
 * Created by Faydee on 2018/6/27.
 */
public class DramaListAdapter extends RecyclerView.Adapter<DramaListAdapter.DramaListViewHolder> {

  private static final String TAG = DramaListAdapter.class.getSimpleName();

  public class DramaListViewHolder extends RecyclerView.ViewHolder {

    private ItemDramaListBinding mBinding;

    public DramaListViewHolder(ItemDramaListBinding binding) {
      super(binding.getRoot());
      mBinding = binding;
    }
  }

  @NonNull @Override
  public DramaListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,
      int i) {
    return null;
  }

  @Override
  public void onBindViewHolder(@NonNull DramaListViewHolder dramaListViewHolder,
      int i) {

  }

  @Override public int getItemCount() {
    return 0;
  }

}
