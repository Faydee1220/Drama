package com.rq.drama.api.callback;

import com.rq.drama.model.Drama;
import java.util.List;

/**
 * Created by Faydee on 2018/6/27.
 */
public interface DramaListCallback {
  void success(List<Drama> dramas);
  void failure(String message);
}
