package com.ju.common;

import android.app.Service;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextPaint;
import android.util.Log;
import android.view.Choreographer;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;


@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class FpsView extends View implements Choreographer.FrameCallback {

    private static final int MAX_LENGTH=4;
    private static final int FRAME_TIME_LENGTH=100;
    private static final String TAG ="FpsView" ;
    private final TextPaint mTp;
    
    
    private long[] mFrameTime = new long[FRAME_TIME_LENGTH];
    private int mFrameTimeIndex=0;
    private int mLastFrameIndex=0;
    private char[] mInstantFpsChar;
    private int mInstantFpsCharIndex;
    
    
    private char[] mAvgFpsChar;
    private int mAvgFpsCharIndex;

    public static int FRAME_NO=0;
    public FpsView(Context context) {
        super(context);
        mTp = new TextPaint();
        mTp.setColor(Color.LTGRAY);
        mTp.setTextSize(20);
        mAvgFpsChar = new char[MAX_LENGTH];
        mInstantFpsChar = new char[MAX_LENGTH];
        mAvgFpsCharIndex =0;
        mInstantFpsCharIndex=0;

        Choreographer.getInstance().postFrameCallback(this);
    }
    
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        canvas.drawColor(Color.TRANSPARENT);
        long currentTime =  AnimationUtils.currentAnimationTimeMillis();
        calcInstantFps(currentTime);
        canvas.drawText(mAvgFpsChar,MAX_LENGTH- mAvgFpsCharIndex, mAvgFpsCharIndex,0,18,mTp);
        canvas.drawText(mInstantFpsChar,MAX_LENGTH- mInstantFpsCharIndex, mInstantFpsCharIndex,0,40,mTp);
        invalidate();
    }
    
    private void calcInstantFps(long currentTime){
        mFrameTime[mFrameTimeIndex] = currentTime;
        while(true){
            long lastTime = mFrameTime[mLastFrameIndex];
            if(currentTime - lastTime>1000){
                mLastFrameIndex = (++mLastFrameIndex)%FRAME_TIME_LENGTH;
            }else{
                break;
            }
        }
        int fps =0;
        if(mFrameTimeIndex >= mLastFrameIndex){
            fps = mFrameTimeIndex - mLastFrameIndex;
        }else{
            fps = FRAME_TIME_LENGTH + mFrameTimeIndex - mLastFrameIndex;
        }
        
        mFrameTimeIndex = (++mFrameTimeIndex)%FRAME_TIME_LENGTH;
    
        mInstantFpsCharIndex =0;
        do{
            int num = fps %10;
            fps /=10;
            mInstantFpsChar[MAX_LENGTH-1- mInstantFpsCharIndex]=(char)(num+48);
            mInstantFpsCharIndex++;
        }while(fps>0 && mInstantFpsCharIndex <MAX_LENGTH);
    }
    public void show(){
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Service.WINDOW_SERVICE);
        WindowManager.LayoutParams paramsF = new WindowManager.LayoutParams(
                50,
                50,
                WindowManager.LayoutParams.TYPE_TOAST,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        // configure starting coordinates
        paramsF.x = 0;
        paramsF.y = 0;
        paramsF.gravity = Gravity.LEFT|Gravity.BOTTOM;

        // add view to the window
        windowManager.addView(this, paramsF);

    }
    private long mLastFrameStartTime=0;

    @Override
    public void doFrame(long frameTimeNanos) {
        FRAME_NO++;
        if (mLastFrameStartTime != 0) {
            long delta = frameTimeNanos-mLastFrameStartTime;
            int tempFps = (int) (1000000000 / (delta));
            if(delta >23000000){
                Log.d(TAG, "doFrame time=" + delta + " frameNo=" + (FRAME_NO-1));//这个时间是上一帧的时间
            }
            mAvgFpsCharIndex = 0;
            do {
                int num = tempFps % 10;
                tempFps /= 10;
                mAvgFpsChar[MAX_LENGTH - 1 - mAvgFpsCharIndex] = (char) (num + 48);
                mAvgFpsCharIndex++;
            } while (tempFps > 0 && mAvgFpsCharIndex < MAX_LENGTH);
        }
        Choreographer.getInstance().postFrameCallback(this);
        mLastFrameStartTime = frameTimeNanos;
    }
}
