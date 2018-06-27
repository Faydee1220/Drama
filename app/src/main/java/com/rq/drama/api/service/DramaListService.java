package com.rq.drama.api.service;

import com.rq.drama.api.response.Result;
import com.rq.drama.model.Drama;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

import static com.rq.drama.model.Constant.PATH_DRAMA_LIST;

/**
 * Created by Faydee on 2018/6/27.
 */
public interface DramaListService {
  @GET(PATH_DRAMA_LIST)
  Call<Result<List<Drama>>> getDramaList();
}
