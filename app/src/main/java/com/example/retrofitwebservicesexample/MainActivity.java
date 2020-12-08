package com.example.retrofitwebservicesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.covidtracking.com/")//baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Posts>> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if(!response.isSuccessful()){
                    tvResult.setText("Code: "+response.code());
                    return;
                }
                List<Posts> posts = response.body();
                for(Posts post : posts){
                    String content = "";
                    content += "Date: " +post.getDate() + "\n";
                    content += "Positive: " +post.getPositive() + "\n";
                    content += "Negative: " + post.getNegative() + "\n";
                    content += "Recovered: " + post.getRecovered() + "\n";
                    content += "Death: " + post.getDeath() + "\n\n";
                    tvResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                tvResult.setText(t.getMessage());
            }
        });
    }
}