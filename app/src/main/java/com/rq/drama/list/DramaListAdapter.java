package com.rq.drama.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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

  public DramaListAdapter(ArrayList<Drama> dramas) {
    mDramas = dramas;
  }

  class DramaListViewHolder extends RecyclerView.ViewHolder {

    private ItemDramaListBinding mBinding;

    DramaListViewHolder(ItemDramaListBinding binding) {
      super(binding.getRoot());
      mBinding = binding;
    }

    private void bind(Drama drama) {
      mBinding.setDrama(drama);
      mBinding.executePendingBindings();
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
