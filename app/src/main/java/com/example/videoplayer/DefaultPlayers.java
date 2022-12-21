package com.example.videoplayer;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.videoplayer.Client.RetrofitClient;
import com.example.videoplayer.Model.VideoWatchlist;
import com.example.videoplayer.Model.Video_listResponse.Result;
import com.example.videoplayer.Model.Video_listResponse.VideoListResponse;
import com.example.videoplayer.databinding.ActivityDefaultPlayersBinding;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerControlView;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DefaultPlayers extends AppCompatActivity {

    private ActivityDefaultPlayersBinding defaultPlayersBinding;
    private boolean isShowingTrackSelectionDialog;
    private DefaultTrackSelector trackSelector;
    private int currentVideoIdxs=0;
    String[] speed = {"0.25x","0.5x","Normal","1.5x","2x"};
    //demo url
    List<String> myVideoList_that_should_played;
    SimpleExoPlayer simpleExoPlayer;
    String url5 = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        defaultPlayersBinding= ActivityDefaultPlayersBinding.inflate(getLayoutInflater());
        setContentView(defaultPlayersBinding.getRoot());
        myVideoList_that_should_played= new ArrayList<>();

        trackSelector= new DefaultTrackSelector( this);
        myVideoList_that_should_played.add(url5);
        simpleExoPlayer= new SimpleExoPlayer.Builder(this).setTrackSelector(trackSelector).build();
        MediaItem mediaItem= MediaItem.fromUri(myVideoList_that_should_played.get(0));
        simpleExoPlayer.addMediaItem(mediaItem);
        defaultPlayersBinding.playerViewDefaults.setPlayer(simpleExoPlayer);
        simpleExoPlayer.prepare();
        simpleExoPlayer.play();

         ImageView forward_Btn= defaultPlayersBinding.playerViewDefaults.findViewById(R.id.forward_btn);
         ImageView btn_previous= defaultPlayersBinding.playerViewDefaults.findViewById(R.id.btn_backward);
         ImageView btn_next= defaultPlayersBinding.playerViewDefaults.findViewById(R.id.btn_next);
         ImageView play_Btn= defaultPlayersBinding.playerViewDefaults.findViewById(R.id.play_btn);
         ImageView setting_Btn= defaultPlayersBinding.playerViewDefaults.findViewById(R.id.setting_btn);
         ImageView playback_speed_Btn= defaultPlayersBinding.playerViewDefaults.findViewById(R.id.playback_speed_btn);
        TextView tv_playback_speed= defaultPlayersBinding.playerViewDefaults.findViewById(R.id.tv_speed);
        ImageView fullScreen_Btn= defaultPlayersBinding.playerViewDefaults.findViewById(R.id.fullScreen_btn);
        ImageView backward_Btn= defaultPlayersBinding.playerViewDefaults.findViewById(R.id.playback_speed_btn);

        FetchUriDataFromApi();
        playback_speed_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogBuilder= new AlertDialog.Builder(DefaultPlayers.this);
                dialogBuilder.setTitle(" Set Speed ");
                dialogBuilder.setItems(speed, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (i == 0) {
                                    tv_playback_speed.setVisibility(View.VISIBLE);
                                    tv_playback_speed.setText("0.25X");
                                    PlaybackParameters params = new PlaybackParameters(0.25f);
                                    simpleExoPlayer.setPlaybackParameters(params);
                                }
                                if (i == 1) {
                                    tv_playback_speed.setVisibility(View.VISIBLE);
                                    tv_playback_speed.setText("0.5X");
                                    PlaybackParameters parameters = new PlaybackParameters(0.5f);
                                    simpleExoPlayer.setPlaybackParameters(parameters);
                                }
                                if (i == 2) {
                                    tv_playback_speed.setVisibility(View.GONE);
                                    PlaybackParameters parameters = new PlaybackParameters(1f);
                                    simpleExoPlayer.setPlaybackParameters(parameters);
                                }
                                if (i == 3) {
                                    tv_playback_speed.setVisibility(View.VISIBLE);
                                    tv_playback_speed.setText("1.5X");
                                    PlaybackParameters parameters = new PlaybackParameters(1.5f);
                                    simpleExoPlayer.setPlaybackParameters(parameters);
                                }
                                if (i == 4) {
                                    tv_playback_speed.setVisibility(View.VISIBLE);
                                    tv_playback_speed.setText("2X");
                                    PlaybackParameters parameters = new PlaybackParameters(2f);
                                    simpleExoPlayer.setPlaybackParameters(parameters);
                                }
                            }
                        });
                dialogBuilder.show();
            }
        });

        forward_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleExoPlayer.seekTo( simpleExoPlayer.getCurrentPosition() +1000);
            }
        });

        play_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( simpleExoPlayer.isPlaying()){
                    simpleExoPlayer.pause();
                }
                else {
                    simpleExoPlayer.play();
                }
            }
        });

        fullScreen_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 int orientation = DefaultPlayers.this.getResources().getConfiguration().orientation;
                    if( orientation== Configuration.ORIENTATION_PORTRAIT) {
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    }
                    else {

                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    }
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentVideoIdxs++;
                if(currentVideoIdxs== myVideoList_that_should_played.size()) {
                    currentVideoIdxs=1;
                }
                simpleExoPlayer.stop();
                simpleExoPlayer.seekToNext();
            }
        });

        backward_Btn.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                long current_playing_duration = simpleExoPlayer.getCurrentPosition() - 1000;
                                                if (current_playing_duration < 0) {
                                                    current_playing_duration = 0;
                                                }
                                                simpleExoPlayer.seekTo(current_playing_duration);
                                            }
        });
        simpleExoPlayer.addListener(new Player.Listener() {
            @Override
            public void onPlaybackStateChanged(int playbackState) {

            }
        });
        setting_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isShowingTrackSelectionDialog
                        && TrackSelectionDialog.willHaveContent(trackSelector)) {
                    isShowingTrackSelectionDialog = true;
                    TrackSelectionDialog trackSelectionDialog = TrackSelectionDialog.createForTrackSelector(trackSelector, dismissDialog -> isShowingTrackSelectionDialog = false);
                    trackSelectionDialog.show(getSupportFragmentManager(), null);
                }
            }
        });


        defaultPlayersBinding.playerViewDefaults.setControllerVisibilityListener(new PlayerControlView.VisibilityListener() {
            @Override
            public void onVisibilityChange(int visibility) {

            }
        });


    }

    private void FetchUriDataFromApi() {
        Call<VideoListResponse> call=RetrofitClient.getInstance().getMyApis().getVideoListResponse("Bearer " + RetrofitClient.token_id);
        call.enqueue(new Callback<VideoListResponse>() {
            @Override
            public void onResponse(Call<VideoListResponse> call, Response<VideoListResponse> response) {
                if(response.isSuccessful()) {
                    Log.d(TAG, "onResponse: Successfully Fetched. " );
                    VideoListResponse videoListResponse= response.body();
                    for (com.example.videoplayer.Model.Video_listResponse.Result myVideo :videoListResponse.getResults()){
                         myVideoList_that_should_played.add( myVideo.getVideo());
                         myVideoList_that_should_played.add(myVideo.getTrailer());
                    }

                }
            }

            @Override
            public void onFailure(Call<VideoListResponse> call, Throwable t) {
                Toast.makeText(DefaultPlayers.this, " OnFailure: "+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure:"+ t.getMessage(), t);
            }
        });
    }

    private void releasePlayer() {
            if (simpleExoPlayer != null) {
                simpleExoPlayer.release();
                trackSelector = null;
                simpleExoPlayer = null;
            }
        }

    @Override
    protected void onStop() {
        super.onStop();
        releasePlayer();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        releasePlayer();
    }
}