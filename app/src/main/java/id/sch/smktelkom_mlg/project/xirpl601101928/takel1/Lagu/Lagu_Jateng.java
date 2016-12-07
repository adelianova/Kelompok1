package id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Lagu;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class Lagu_Jateng extends AppCompatActivity {

    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;
    private MediaPlayer mp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = new MediaPlayer();

        btnPlay = (Button) findViewById(R.id.btnPLAY);
        btnPause = (Button) findViewById(R.id.btnPAUSE);
        btnStop = (Button) findViewById(R.id.btnSTOP);

        stateAwal();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
                btnPlay.setEnabled(false);
                btnPause.setEnabled(true);
                btnStop.setEnabled(true);
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
            }
        });
    }

    public void stateAwal() {
        btnPlay.setEnabled(true);
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);
    }

    private void play() {
        mp = MediaPlayer.create(this, R.raw.bali);

        try {
            mp.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mp.start();

        mp.setOnCompletionListener(new OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    public void pause() {
        if (mp.isPlaying()) {
            if (mp != null) {
                mp.pause();

            }
        } else {
            if (mp != null) {
                mp.start();

            }
        }
    }

    public void stop() {
        mp.stop();

        try {
            mp.prepare();
            mp.seekTo(0);
        } catch (Throwable t) {
            t.printStackTrace();
        }

        stateAwal();
    }
}