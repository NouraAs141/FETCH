package p.fetch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.VideoView;

public class splash extends AppCompatActivity {
VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //make video fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();// hide actoin bar

        //start playing video
        videoView =  (VideoView)findViewById(R.id.videoView);
        Uri video = Uri.parse("android.resource://"+ getPackageName()+"/"+ R.raw.fetchlogo );
        videoView.setVideoURI(video);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
              if(isFinishing())
                return;

startActivity(new Intent(splash.this, MainActivity.class));
finish(); // end of the video
            }
        });
        videoView.start();

    }
}
