package com.example.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.CustomAdapter;
import com.example.model.ApiDemoModel;
import com.example.model.Info;
import com.example.model.Result;
import com.example.model.RetroData;
import com.example.model.UserResponce;
import com.example.retrofit.ApiManager;
import com.example.retrofit.ApiResponseInterface;
import com.example.retrofitdemopro.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.retrofit.ApiServiceCode.LOGIN_REQUEST_CODE;
import static com.example.retrofit.ApiServiceCode.REQUEST_CODE;

public class MainActivity extends AppCompatActivity implements ApiResponseInterface {
    CustomAdapter adapter;
    Context context;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.recycle)
    RecyclerView recyclerView;
    ProgressDialog progressDoalog;
    ApiManager apiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        ButterKnife.bind(this);

        apiManager = new ApiManager(MainActivity.this, MainActivity.this);

        onRequest();
    }

    void onRequest() {

        apiManager.userProfileDetailsRequest();
    }

    @Override
    public void isError(boolean errorCode, Object response, int serviceCode) {
        String msg = (String) response;
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void isSuccess(Object response, int serviceCode) {
        ApiDemoModel Response = (ApiDemoModel) response;
        Info info;

        Log.d("hello",Response.toString());
        info = Response.getInfo();
        System.out.print(info.toString());
        tv.setText(info.getSeed());


        ArrayList<Result> preference_info_response = (ArrayList<Result>) Response.getResults();
System.out.print(preference_info_response.size());
Log.d("data",preference_info_response.toString());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new CustomAdapter(this, preference_info_response);
        recyclerView.setAdapter(adapter);
    }

}



