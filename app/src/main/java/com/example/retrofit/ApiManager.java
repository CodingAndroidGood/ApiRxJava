package com.example.retrofit;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;


import com.example.Utlis.DialogPopup;
import com.example.model.ApiDemoModel;
import com.example.model.LoginResponce;

import com.example.model.Result;
import com.example.model.RetroData;
import com.example.model.UserResponce;
import com.example.retrofitdemopro.R;

import java.io.File;
import java.util.List;

import io.reactivex.Observer;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static com.example.retrofit.ApiServiceCode.LOGIN_REQUEST_CODE;
import static com.example.retrofit.ApiServiceCode.REQUEST_CODE;


public class ApiManager {
    private Context mContext;
    private ApiResponseInterface apiResponseInterface;
    DialogPopup dialogPopup;
    String mesasge = "Loading";
    ApiInterface apiInterface;
    ProgressDialog progressDialog;
    Activity activity;

    public ApiManager(Context context, ApiResponseInterface responseInterface) {
        this.mContext = context;
        activity = (Activity) context;
        this.apiResponseInterface = responseInterface;
        apiInterface = ApiClient.getClient();
        dialogPopup = new DialogPopup(context);
    }


    private MultipartBody.Part createMultipartBody(String filePath) {
        File file = new File(filePath); // -- 1 --
        RequestBody requestBody = createRequestBody(file);
        return MultipartBody.Part.createFormData("Image", file.getName(), requestBody);
    }

    private RequestBody createRequestBody(File file) {
        return RequestBody.create(MediaType.parse("image*//*"), file);
    }


//    public void signinRequest(String user_type, String email, String password) {
//
//        apiInterface.signinParam(user_type, email, password)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<LoginResponce>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        dialogPopup.showLoadingDialog(mContext, mContext.getString(R.string.processing));
//                    }
//
//                    @Override
//                    public void onNext(LoginResponce loginResponse) {
//
//                        dialogPopup.dismissLoadingDialog();
//                        if(loginResponse.getStatus())
//                        {
//                            apiResponseInterface.isSuccess(loginResponse,LOGIN_REQUEST_CODE);
//                        }
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                        dialogPopup.dismissLoadingDialog();
//                        String error = e.getMessage();
//                        Toast.makeText(mContext, error, Toast.LENGTH_LONG).show();
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        dialogPopup.dismissLoadingDialog();
//                    }
//                });
//    }

//    public void Data() {
//
//        apiInterface.data()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<List<RetroData>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        dialogPopup.showLoadingDialog(mContext, mContext.getString(R.string.processing));
//                    }
//
//
//                    @Override
//                    public void onNext(List<RetroData> retroData) {
//                        Toast.makeText(mContext, "hello", Toast.LENGTH_SHORT).show();
//                        apiResponseInterface.isSuccess(retroData,REQUEST_CODE);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                        dialogPopup.dismissLoadingDialog();
//                        String error = e.getMessage();
//                        Toast.makeText(mContext, error, Toast.LENGTH_LONG).show();
//                    }
//
//
//
//
//
//
//                    @Override
//                    public void onComplete() {
//                        dialogPopup.dismissLoadingDialog();
//                    }
//                });
//    }

//
//        public void Data() {
//
//        apiInterface.datas()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<List<Result>>() {
//
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(List<Result> apiDemoModels) {
//                        Log.d("hello",apiDemoModels.toString());
//                        apiResponseInterface.isSuccess(apiDemoModels,REQUEST_CODE);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        dialogPopup.dismissLoadingDialog();
//                    }
//                });
//    }
public void userProfileDetailsRequest() {
    apiInterface.userProfileDetailsParam()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<ApiDemoModel>() {
                @Override
                public void onSubscribe(Disposable d) {
                    dialogPopup.showLoadingDialog(mContext, mContext.getString(R.string.processing));
                }

                @Override
                public void onNext(ApiDemoModel apiResponse) {

                    dialogPopup.dismissLoadingDialog();

                        apiResponseInterface.isSuccess(apiResponse, 2);

                }

                @Override
                public void onError(Throwable e) {

                    e.printStackTrace();
                    dialogPopup.dismissLoadingDialog();
                    String error = e.getMessage();
                    Toast.makeText(mContext, "error", Toast.LENGTH_SHORT).show();
                    Toast.makeText(mContext, error, Toast.LENGTH_LONG).show();

                }

                @Override
                public void onComplete() {
                    dialogPopup.dismissLoadingDialog();
                }
            });


}


}
