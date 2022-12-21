
package com.example.videoplayer.Model;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("audio_id")
    private String mAudioId;
    @SerializedName("category_id")
    private String mCategoryId;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("duration_hours")
    private String mDurationHours;
    @SerializedName("duration_minutes")
    private String mDurationMinutes;
    @SerializedName("duration_second")
    private String mDurationSecond;
    @SerializedName("id")
    private String mId;
    @SerializedName("image")
    private String mImage;
    @SerializedName("is_play")
    private String mIsPlay;
    @SerializedName("mode")
    private String mMode;
    @SerializedName("name")
    private String mName;
    @SerializedName("subtitle_id")
    private String mSubtitleId;
    @SerializedName("trailer")
    private String mTrailer;
    @SerializedName("type")
    private String mType;
    @SerializedName("video")
    private String mVideo;
    @SerializedName("watch_audio")
    private String mWatchAudio;
    @SerializedName("watch_time")
    private String mWatchTime;

    public String getAudioId() {
        return mAudioId;
    }

    public void setAudioId(String audioId) {
        mAudioId = audioId;
    }

    public String getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(String categoryId) {
        mCategoryId = categoryId;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDurationHours() {
        return mDurationHours;
    }

    public void setDurationHours(String durationHours) {
        mDurationHours = durationHours;
    }

    public String getDurationMinutes() {
        return mDurationMinutes;
    }

    public void setDurationMinutes(String durationMinutes) {
        mDurationMinutes = durationMinutes;
    }

    public String getDurationSecond() {
        return mDurationSecond;
    }

    public void setDurationSecond(String durationSecond) {
        mDurationSecond = durationSecond;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getIsPlay() {
        return mIsPlay;
    }

    public void setIsPlay(String isPlay) {
        mIsPlay = isPlay;
    }

    public String getMode() {
        return mMode;
    }

    public void setMode(String mode) {
        mMode = mode;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSubtitleId() {
        return mSubtitleId;
    }

    public void setSubtitleId(String subtitleId) {
        mSubtitleId = subtitleId;
    }

    public String getTrailer() {
        return mTrailer;
    }

    public void setTrailer(String trailer) {
        mTrailer = trailer;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getVideo() {
        return mVideo;
    }

    public void setVideo(String video) {
        mVideo = video;
    }

    public String getWatchAudio() {
        return mWatchAudio;
    }

    public void setWatchAudio(String watchAudio) {
        mWatchAudio = watchAudio;
    }

    public String getWatchTime() {
        return mWatchTime;
    }

    public void setWatchTime(String watchTime) {
        mWatchTime = watchTime;
    }

}
