package com.example.faiaz.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ListView;

import com.example.faiaz.retrofitexample.adapter.MainAdapter;
//import com.example.faiaz.retrofitexample.model.DataModel;
//import com.example.faiaz.retrofitexample.model.FinalModel;
//import com.example.faiaz.retrofitexample.model.ParentModel;
import com.example.faiaz.retrofitexample.pojo.MultipleResource;
import com.example.faiaz.retrofitexample.rest.ApiClient;
import com.example.faiaz.retrofitexample.rest.ApiInterface;
import com.example.faiaz.retrofitexample.util.MyConstants;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LOG_CHAT_MAINACTIVITY";
    private ListView listview;

    private ApiInterface apiInterface = null;
    private Retrofit retrofit = null;
    private HashMap<String, String> params = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview);

//        Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
//                .addConverterFactory(GsonConverterFactory.create());
//
//
//        Retrofit retrofit = builder.build();
//
//        //instance of our github client
//        ApiInterface client = retrofit.create(ApiInterface.class);
//        Call<List<GitHubRepo>> call =   client.repoForUser("faiazhossen");
//
//        //get data asynchronously
//        call.enqueue(new Callback<List<GitHubRepo>>() {
//            @Override
//            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
//                List<GitHubRepo> repos = response.body();
//                listview.setAdapter(new GithubRepoAdapter(MainActivity.this, repos));
//            }
//
//            @Override
//            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
//
//            }
//        });


        if(retrofit == null)
            retrofit = ApiClient.getRetroClient(MyConstants.BASE_URL);
        if(apiInterface == null)
            apiInterface = retrofit.create((ApiInterface.class));
        if(params == null)
            params = new HashMap<>();
        params.put("api_token", "9tHTR5Up1cVeK171D56uvZH4UfOEnnk00vaHoZyiIfnf3le3jF9BIGYHyKwJ");


//        Call<ParentModel> call = apiInterface.getLastLocation(params);
//
//        call.enqueue(new Callback<ParentModel>() {
//            @Override
//            public void onResponse(Call<ParentModel> call, Response<ParentModel> response) {
//                if(response.isSuccessful()){
//                    DataModel data = response.body().data;
//
//                    Double lat = data.getLat();
//                    Double lng = data.getLng();
//                    int time = data.getTime();
//                    Log.i(TAG, lat + " :lat--lng: " + lng);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ParentModel> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });


        Call<MultipleResource> call = apiInterface.getFinalDistrictList(params);

        call.enqueue(new Callback<MultipleResource>() {
            @Override
            public void onResponse(Call<MultipleResource> call, Response<MultipleResource> response) {
                if(response.isSuccessful()){
                    MultipleResource res = response.body();

                    listview.setAdapter(new MainAdapter(MainActivity.this, res));

//                    Log.d(TAG, "onResponse: "+status);
                }
            }

            @Override
            public void onFailure(Call<MultipleResource> call, Throwable t) {
                t.printStackTrace();
            }
        });







    }
}
