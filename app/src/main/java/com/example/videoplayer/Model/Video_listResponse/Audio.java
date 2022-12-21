
package com.example.videoplayer.Model.Video_listResponse;

import com.google.gson.annotations.SerializedName;

public class Audio {

    @SerializedName("language_code")
    private String mLanguageCode;
    @SerializedName("name")
    private String mName;

    public String getLanguageCode() {
        return mLanguageCode;
    }

    public void setLanguageCode(String languageCode) {
        mLanguageCode = languageCode;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
