
package com.example.videoplayer.Model.Video_listResponse;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("audio")
    private List<Audio> mAudio;
    @SerializedName("audio_id")
    private String mAudioId;
    @SerializedName("category")
    private List<Category> mCategory;
    @SerializedName("category_id")
    private String mCategoryId;
    @SerializedName("Created_date")
    private String mCreatedDate;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("Downloading")
    private String mDownloading;
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
    @SerializedName("image_promposal")
    private String mImagePromposal;
    @SerializedName("is_favorite")
    private String mIsFavorite;
    @SerializedName("is_play")
    private String mIsPlay;
    @SerializedName("isSubscription")
    private String mIsSubscription;
    @SerializedName("language_code")
    private String mLanguageCode;
    @SerializedName("mode")
    private String mMode;
    @SerializedName("name")
    private String mName;
    @SerializedName("Paused")
    private String mPaused;
    @SerializedName("sub_title")
    private String mSubTitle;
    @SerializedName("subtitle")
    private List<Subtitle> mSubtitle;
    @SerializedName("subtitle_id")
    private String mSubtitleId;
    @SerializedName("trailer")
    private String mTrailer;
    @SerializedName("video")
    private String mVideo;
    @SerializedName("watch_audio")
    private String mWatchAudio;
    @SerializedName("watch_time")
    private String mWatchTime;

    public List<Audio> getAudio() {
        return mAudio;
    }

    public void setAudio(List<Audio> audio) {
        mAudio = audio;
    }

    public String getAudioId() {
        return mAudioId;
    }

    public void setAudioId(String audioId) {
        mAudioId = audioId;
    }

    public List<Category> getCategory() {
        return mCategory;
    }

    public void setCategory(List<Category> category) {
        mCategory = category;
    }

    public String getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(String categoryId) {
        mCategoryId = categoryId;
    }

    public String getCreatedDate() {
        return mCreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        mCreatedDate = createdDate;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDownloading() {
        return mDownloading;
    }

    public void setDownloading(String downloading) {
        mDownloading = downloading;
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

    public String getImagePromposal() {
        return mImagePromposal;
    }

    public void setImagePromposal(String imagePromposal) {
        mImagePromposal = imagePromposal;
    }

    public String getIsFavorite() {
        return mIsFavorite;
    }

    public void setIsFavorite(String isFavorite) {
        mIsFavorite = isFavorite;
    }

    public String getIsPlay() {
        return mIsPlay;
    }

    public void setIsPlay(String isPlay) {
        mIsPlay = isPlay;
    }

    public String getIsSubscription() {
        return mIsSubscription;
    }

    public void setIsSubscription(String isSubscription) {
        mIsSubscription = isSubscription;
    }

    public String getLanguageCode() {
        return mLanguageCode;
    }

    public void setLanguageCode(String languageCode) {
        mLanguageCode = languageCode;
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

    public String getPaused() {
        return mPaused;
    }

    public void setPaused(String paused) {
        mPaused = paused;
    }

    public String getSubTitle() {
        return mSubTitle;
    }

    public void setSubTitle(String subTitle) {
        mSubTitle = subTitle;
    }

    public List<Subtitle> getSubtitle() {
        return mSubtitle;
    }

    public void setSubtitle(List<Subtitle> subtitle) {
        mSubtitle = subtitle;
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
