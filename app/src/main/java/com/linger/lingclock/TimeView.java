package com.linger.lingclock;

import android.content.Context;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by linger on 2018/8/21.
 */

public class TimeView extends LinearLayout {


    public TimeView(Context context) {
        super(context);
    }

    public TimeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TimeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvTime.setText("Hello");
        timerHandler.sendEmptyMessage(0);
    }

    @Override
    protected void onVisibilityChanged(@NonNull View changedView,int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if(visibility==View.VISIBLE){
            timerHandler.sendEmptyMessage(0);
        }else {
            timerHandler.removeMessages(0);
        }
    }

    private TextView tvTime;

    private void refreshTime() {
        Calendar c=Calendar.getInstance();
        tvTime.setText(String.format("%d年%d月%d日  %d:%d:%d",c.get(Calendar.YEAR),c.get(Calendar.MONTH),
                c.get(Calendar.DATE),c.get(Calendar.HOUR_OF_DAY),c.get
                (Calendar.MINUTE),c.get(Calendar.SECOND)));
    }

    private Handler timerHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            refreshTime();
            if (getVisibility() == View.VISIBLE) {
                timerHandler.sendEmptyMessageDelayed(0, 1000);
            }
        }

        ;
    };

}
