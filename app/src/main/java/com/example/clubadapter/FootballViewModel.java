package com.example.clubadapter;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.logging.Logger;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FootballViewModel extends ViewModel {
    private FootballClient footballClient;


    private MutableLiveData<ArrayList<TeamsItem>> listClub = new MutableLiveData<>();

    public void setListClub(String L) {
        if (this.footballClient == null) {
            footballClient = new FootballClient();
        }
        footballClient.getApiFootball().getClub(L).enqueue(new Callback<Club1Response>() {
            @Override
            public void onResponse(Call<Club1Response> call, Response<Club1Response> response) {
                Club1Response clubResponse = response.body();
                if (clubResponse != null && clubResponse.getTeams() != null) {
                    ArrayList<TeamsItem> listclub = (ArrayList<TeamsItem>) clubResponse.getTeams();
                    listClub.postValue(listclub);
                }
            }

            @Override
            public void onFailure(Call<Club1Response> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    public LiveData<ArrayList<TeamsItem>> getListClub() {
        return listClub;
    }
}
