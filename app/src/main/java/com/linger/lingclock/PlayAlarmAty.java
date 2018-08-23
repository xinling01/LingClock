package com.linger.lingclock;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;


/**
 * Created by linger on 2018/8/22.
 */

public class PlayAlarmAty extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mp=MediaPlayer.create(this,R.raw.music);
    }
    private MediaPlayer mp;
}
