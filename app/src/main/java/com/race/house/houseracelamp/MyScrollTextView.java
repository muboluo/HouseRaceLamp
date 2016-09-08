package com.race.house.houseracelamp;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyScrollTextView extends TextView implements Runnable {

    private int mTextWidth;
    private boolean mStartPlay;

    public MyScrollTextView(Context context) {
        super(context);
    }

    public MyScrollTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        getTextWidth();
    }

    public void getTextWidth() {
        Paint paint = getPaint();
        mTextWidth = (int) paint.measureText(getText().toString());

    }

    /**
     * 开始播放跑马灯
     */
    public void startPlay() {
        mStartPlay = true;
        post(this);
    }


    /**
     * 停止播放
     */
    public void stopPlay() {
        mStartPlay = false;
    }

    @Override
    public void run() {

        if (mStartPlay) {

            scrollBy(15, 0);
            //如果全部滚出，则设置到最右边开始滚动
            if (getScrollX() >= mTextWidth) {
                scrollTo(-mTextWidth, 0);
            }


        } else {
            //回到原来的位置
            scrollTo(0, 0);
            return;
        }


        postDelayed(this, 100);

    }
}
