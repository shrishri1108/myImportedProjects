
package com.example.videoplayer.Model.Video_listResponse;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("name")
    private String mName;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
