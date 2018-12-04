package br.com.caina_bonfiglioli.a4read.controller;

import br.com.caina_bonfiglioli.a4read.model.Result;
import br.com.caina_bonfiglioli.a4read.model.ResultBook;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("login/{email}")
    Call<Result> getUserByEmail(@Path("email") String email);
    @GET("/titulo/{bookTitle}")
    Call<ResultBook> getBookByTitle(@Path("bookTitle") String bookTitle);
}
