package com.example.videoplayer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;

import com.example.videoplayer.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {

    private ActivityMainBinding mainBinding;
    private ArrayList<Integer> myVideoList= new ArrayList<>();
    int currVideo=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        MediaController mec=new MediaController(this);
        mec.setPadding( 93, 150,  93,  1039);
        mec.setAnchorView(mainBinding.vidvw);
        mainBinding.vidvw.setMediaController(mec);
        mainBinding.vidvw.setOnCompletionListener(this);
        myVideoList.add(R.raw.vid1);
        myVideoList.add(R.raw.vids2);
        setVideoToPlayer(myVideoList.get(0));

        mainBinding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToExoPlayerView();
            }
        });
    }

    private void moveToExoPlayerView() {
        Intent intent=new Intent(MainActivity.this, ExoPlayerView.class);
        startActivity(intent);
        finish();
    }

    private void setVideoToPlayer(int video_Id) {
        String uriPath= "android.resource://"+getPackageName()+ "/"+ video_Id;
        Uri uri= Uri.parse(uriPath);
        mainBinding.vidvw.setVideoURI(uri);
        mainBinding.vidvw.start();
    }


    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        AlertDialog.Builder albB= new AlertDialog.Builder(this  );
        albB.setTitle(" Playback finished!");
        albB.setIcon(R.mipmap.ic_launcher);
        MyLauncher myLauncher=new MyLauncher();
        albB.setPositiveButton("Replay", myLauncher);
        albB.setNegativeButton("Next",myLauncher);
        albB.setMessage(" Want to Replay or play  music videos ");
        albB.show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    class MyLauncher implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            if(which== -1){
                mainBinding.vidvw.seekTo(0);
                mainBinding.vidvw.start();
            }
            else {
                ++currVideo;
                if(currVideo== myVideoList.size()){
                    currVideo=0;
                }
                setVideoToPlayer(myVideoList.get(currVideo));
            }
        }

    }
}