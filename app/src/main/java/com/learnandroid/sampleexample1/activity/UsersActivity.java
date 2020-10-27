package com.learnandroid.sampleexample1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.learnandroid.sampleexample1.R;
import com.learnandroid.sampleexample1.adapter.UserAdapter;
import com.learnandroid.sampleexample1.apis.ApiClient;
import com.learnandroid.sampleexample1.apis.ApiInterface;
import com.learnandroid.sampleexample1.model.userdata.UsersList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersActivity extends AppCompatActivity {

    private List<UsersList> usersLists;
    private UserAdapter userAdapter;
    private RecyclerView rvUserList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        getUsersData();
    }
    private void getUsersData(){

            ApiInterface apIinterface = ApiClient.getRetrofitClientForAuth(UsersActivity.this).create(ApiInterface.class);
            Call<List<UsersList>> ResultCall = apIinterface.getUsersData();
            ResultCall.enqueue(new Callback<List<UsersList>>() {
                @Override
                public void onResponse(Call<List<UsersList>> call, Response<List<UsersList>> response) {
                    usersLists =  response.body();
                    generateDataList();
                }

                @Override
                public void onFailure(Call<List<UsersList>> call, Throwable t) {
                    Toast.makeText(UsersActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            });
    }

    private void generateDataList() {
        rvUserList = (RecyclerView) findViewById(R.id.rvUserList);
        userAdapter = new UserAdapter(usersLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvUserList.setLayoutManager(mLayoutManager);
        rvUserList.setItemAnimator(new DefaultItemAnimator());
        rvUserList.setAdapter(userAdapter);
    }
}