package com.example.retrofit;

import com.example.model.ApiDemoModel;
import com.example.model.Result;
import com.example.model.RetroData;

import java.util.List;

public interface ApiResponseInterface {

    public void isError(boolean errorCode, Object response, int serviceCode);
   // public void isSuccess(List<Result> response, int serviceCode);
    public void isSuccess(Object response, int serviceCode);

}
