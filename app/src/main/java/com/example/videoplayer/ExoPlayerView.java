package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.videoplayer.databinding.ActivityDefaultPlayersBinding;
import com.example.videoplayer.databinding.ActivityExoPlayerViewBinding;
import com.example.videoplayer.databinding.ActivityStylePlayerBinding;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class ExoPlayerView extends AppCompatActivity {

    private ActivityExoPlayerViewBinding exoPlayerViewBinding;
    private SimpleExoPlayer simpleExoPlayer;
    String url1 = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exoPlayerViewBinding= ActivityExoPlayerViewBinding.inflate(getLayoutInflater());
        setContentView(exoPlayerViewBinding.getRoot());
        simpleExoPlayer= new SimpleExoPlayer.Builder(this).build();
        exoPlayerViewBinding.idExoplayer.setPlayer(simpleExoPlayer);



        /* Note
         *
         * In ExoPlayer every piece of media is represented by a MediaItem. To play a piece of media you need to build a corresponding MediaItem, add it to the player, prepare the player, and call play to start the playback:
         *
         * */
//        Now we need media item
        // Build the media item.
        MediaItem mediaItem = MediaItem.fromUri(url1);
// Set the media item to be played.
        simpleExoPlayer.addMediaItem(mediaItem);
// Prepare the player.
        simpleExoPlayer.prepare();
// Start the playback.
        simpleExoPlayer.play();

        exoPlayerViewBinding.buttonPlayDefaultVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseVideos();
                Intent intent=new Intent(getApplicationContext(), DefaultPlayers.class);
                startActivity(intent);
            }
        });

        exoPlayerViewBinding.buttonPlayStylePlayerVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                releaseVideos();
                startActivity(new Intent(getApplicationContext(), StylePlayer.class));
            }
        });
    }

    private void releaseVideos() {
        if(simpleExoPlayer.isPlaying()) {
            simpleExoPlayer.release();
        }
    }

}