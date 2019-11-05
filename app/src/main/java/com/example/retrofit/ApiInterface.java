package com.example.retrofit;


import com.example.model.ApiDemoModel;
import com.example.model.LoginResponce;
import com.example.model.Result;
import com.example.model.RetroData;
import com.example.model.UserResponce;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


import static com.example.retrofit.ApiUrl.LIST;

public interface ApiInterface {

//    @FormUrlEncoded
//    @POST(LOGIN_URL)
//    Observable<LoginResponce> signinParam(@Field("user_type") String user_type,
//                                          @Field("email") String email,
//                                          @Field("password") String password);
//
//
//
//    @FormUrlEncoded
//    @POST(USER_LIST_URL)
//    Observable<UserResponce> userListParam(@Field("UserID") String UserID);
//
//
//    @GET(LIST)
//    Observable<List<RetroData>> data();
//
//    @GET("/")
//    Observable<List<Result>> datas();

    @GET(LIST)
    Observable<ApiDemoModel> userProfileDetailsParam();

}

