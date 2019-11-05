package com.example.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.example.model.UserLoginDetails;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponce implements Parcelable {

    @SerializedName("Status")
    @Expose
    private Boolean status;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("UserLoginDetails")
    @Expose
    private UserLoginDetails userLoginDetails;
    public final static Parcelable.Creator<LoginResponce> CREATOR = new Creator<LoginResponce>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LoginResponce createFromParcel(Parcel in) {
            return new LoginResponce(in);
        }

        public LoginResponce[] newArray(int size) {
            return (new LoginResponce[size]);
        }

    };

    protected LoginResponce(Parcel in) {
        this.status = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.userLoginDetails = ((UserLoginDetails) in.readValue((UserLoginDetails.class.getClassLoader())));
    }

    public LoginResponce() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserLoginDetails getUserLoginDetails() {
        return userLoginDetails;
    }

    public void setUserLoginDetails(UserLoginDetails userLoginDetails) {
        this.userLoginDetails = userLoginDetails;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(message);
        dest.writeValue(userLoginDetails);
    }

    public int describeContents() {
        return 0;
    }

}