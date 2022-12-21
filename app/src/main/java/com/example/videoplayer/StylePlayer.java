package com.example.videoplayer;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.videoplayer.Client.RetrofitClient;
import com.example.videoplayer.Model.Result;
import com.example.videoplayer.Model.VideoWatchlist;
import com.example.videoplayer.databinding.ActivityStylePlayerBinding;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.StyledPlayerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StylePlayer extends AppCompatActivity {

    private ActivityStylePlayerBinding stylePlayerBinding;
    StyledPlayerView styledPlayerView;
    SimpleExoPlayer simpleExoPlayer;
    List<String> myWatListVideos=new ArrayList<>();

    String url1 = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stylePlayerBinding= ActivityStylePlayerBinding.inflate(getLayoutInflater());
        setContentView(stylePlayerBinding.getRoot());
        simpleExoPlayer= new SimpleExoPlayer.Builder(this).build();
        stylePlayerBinding.styledPlayerView.setPlayer(simpleExoPlayer);

        FetchUriFromApi();
        if(myWatListVideos.size() ==0) {
            MediaItem mediaItem = MediaItem.fromUri(url1);
            simpleExoPlayer.addMediaItem(mediaItem);
        }
        else {
            for (String Uri: myWatListVideos) {
                MediaItem mediaItem = MediaItem.fromUri(Uri);
                simpleExoPlayer.addMediaItem(mediaItem);
            }
        }
        simpleExoPlayer.prepare();
        simpleExoPlayer.play();


    }

    private void FetchUriFromApi() {
        Call<VideoWatchlist> call= RetrofitClient.getInstance().getMyApis().getWatchLIstVideos( "Bearer "+RetrofitClient.token_id);
        call.enqueue(new Callback<VideoWatchlist>() {
            @Override
            public void onResponse(Call<VideoWatchlist> call, Response<VideoWatchlist> response) {
                if(response!=null && response.isSuccessful()) {
                    Log.d(TAG, "onResponse: "+response );
                    VideoWatchlist myVideos= response.body();
                    if (myVideos != null && myVideos.getResults() !=null) {
                        for (Result myvideo : myVideos.getResults()) {
                            if (myvideo != null) {
                                myWatListVideos.add(myvideo.getVideo());
                                myWatListVideos.add(myvideo.getTrailer());
                            }
                        }
                    }
                    else {
                        Log.d(TAG, "onResponse: myVideos -"+ myVideos.getResults() );
                    }
                }
                else {
                    Log.d(TAG, "onResponse: "+response+" .");
                }
            }

            @Override
            public void onFailure(Call<VideoWatchlist> call, Throwable t) {
                Log.e(TAG, "onFailure:"+ t.getMessage(), t);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        simpleExoPlayer.release();
    }
}