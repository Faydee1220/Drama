package com.rq.drama.list;

import android.support.v4.app.Fragment;
import android.widget.ImageView;
import com.rq.drama.BasePresenter;
import com.rq.drama.BaseView;
import com.rq.drama.model.Drama;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faydee on 2018/6/27.
 */
public interface DramaListContract {
  interface Presenter extends BasePresenter {
    void loadDramaList();
    void loadThumb(Drama drama, ImageView imageView);
  }

  interface View extends BaseView<Presenter> {
    void showDramaList(ArrayList<Drama> dramas);
    void showDramaDetail(Drama drama);
    Fragment getFragment();
  }
}
