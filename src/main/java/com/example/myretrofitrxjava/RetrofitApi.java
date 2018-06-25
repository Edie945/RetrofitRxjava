package com.example.myretrofitrxjava;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitApi {
    @GET("product/getCatagory")
    Observable<Beans> Sudoku();
}
