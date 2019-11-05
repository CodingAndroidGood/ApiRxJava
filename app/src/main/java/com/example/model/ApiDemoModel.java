
package com.example.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiDemoModel implements Parcelable
{

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("info")
    @Expose
    private Info info;
    public final static Creator<ApiDemoModel> CREATOR = new Creator<ApiDemoModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ApiDemoModel createFromParcel(Parcel in) {
            return new ApiDemoModel(in);
        }

        public ApiDemoModel[] newArray(int size) {
            return (new ApiDemoModel[size]);
        }

    }
    ;

    protected ApiDemoModel(Parcel in) {
        in.readList(this.results, (com.example.model.Result.class.getClassLoader()));
        this.info = ((Info) in.readValue((Info.class.getClassLoader())));
    }

    public ApiDemoModel() {
    }

    public List<Result> getResults() { return results; }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(results);
        dest.writeValue(info);
    }

    public int describeContents() {
        return  0;
    }

}
