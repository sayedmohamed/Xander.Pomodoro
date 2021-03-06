package com.xanderframework.pomodoro;

import android.os.SystemClock;

public class RunnableTimer implements Runnable {

    public RunnableTimer(MainActivity parentActivity) {
        this.parent = parentActivity;
    }

    private MainActivity parent;

    @Override
    public void run() {
        parent.currentProgress = SystemClock.elapsedRealtime()
                - parent.startTime;
        parent.setProgressText(String.format("Time so far: %d",
                parent.currentProgress));
        parent.setProgressBarValue((int)parent.currentProgress);

        parent.timeHandler.postDelayed(this, 500);
    }
}
