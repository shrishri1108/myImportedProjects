
package com.example.videoplayer.Model.Video_listResponse;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class VideoListResponse {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("results")
    private List<Result> mResults;
    @SerializedName("status")
    private Boolean mStatus;

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public List<Result> getResults() {
        return mResults;
    }

    public void setResults(List<Result> results) {
        mResults = results;
    }

    public Boolean getStatus() {
        return mStatus;
    }

    public void setStatus(Boolean status) {
        mStatus = status;
    }

}
