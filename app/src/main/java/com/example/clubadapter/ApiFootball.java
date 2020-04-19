package com.example.clubadapter;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiFootball {

//?l=English%20Premier%20League
    @GET("api/v1/json/1/search_all_teams.php")
    Call<Club1Response> getClub(@Query("l") String l);
}
