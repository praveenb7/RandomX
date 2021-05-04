package com.example.randomnumbergenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.MenuItem;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Toss extends AppCompatActivity {

    private ImageView htimg;
    private Button flip;
    private static final int FLIP_ANIMATION_DURATION = 1500;
    private static final int FLIP_ANIMATION_ROTATION_BY = 14400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("Toss Simulator");

        htimg = (ImageView) findViewById(R.id.coinimg);
        flip = (Button) findViewById(R.id.flipbtn);


        flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = 0;
                int b = 1;
                int res = (int) Math.floor(Math.random()*(b-a+1)+a);

                htimg.animate().setDuration(FLIP_ANIMATION_DURATION)
                        .rotationXBy(FLIP_ANIMATION_ROTATION_BY)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationStart(Animator arg0) {
                                flip.setVisibility(View.GONE);
                                Context context;
                                MediaPlayer sound = MediaPlayer.create(Toss.this, R.raw.coinflip);
                                sound.start();
                            }

                            @Override
                            public void onAnimationEnd(Animator arg0) {
                                if (res == 0) {
                                    htimg.setImageResource(R.drawable.heads);
                                } else {
                                    htimg.setImageResource(R.drawable.tails);
                                }
                                flip.setVisibility(View.VISIBLE);
                            }
                        });

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}