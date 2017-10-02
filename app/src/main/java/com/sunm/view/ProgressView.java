package com.sunm.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.sunm.AppConfig;
import com.sunm.bolts.R;

/**
 * progress view
 */

public class ProgressView extends View{

    private static final boolean DEBUG = AppConfig.DEBUG;
    private static final String TAG = "ProgressView";

    private Paint mCirclePaint;
    private Paint mTextPaint;
    private float mCircleRadius;

    private float mStartAngle = -90;
    private float mSweepAngle;
    private String mTextValue = "";

    private ValueAnimator mProgressAnim;

    public ProgressView(Context context) {
        this(context, null);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray array = getResources().obtainAttributes(attrs, R.styleable.ProgressView);
        int circleColor = array.getColor(R.styleable.ProgressView_circleColor, Color.BLACK);
        float circleWidth = array.getFloat(R.styleable.ProgressView_circleWidth, 4f);
        float textSize = array.getDimension(R.styleable.ProgressView_circleTextSize, 16);
        mCircleRadius = array.getDimension(R.styleable.ProgressView_circleRadius, 40f);

        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setColor(circleColor);
        mCirclePaint.setStrokeWidth(circleWidth);

        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(textSize);
        mTextPaint.setColor(Color.GRAY);

        array.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int x = getWidth() / 2;
        int y = getHeight() / 2;

        RectF rectF = new RectF(x - mCircleRadius,
                y - mCircleRadius,
                x + mCircleRadius,
                y + mCircleRadius);
        float v = mTextPaint.measureText(mTextValue);
        canvas.drawText(mTextValue, x - v/2, y + mTextPaint.getTextSize() / 2, mTextPaint);
        canvas.drawArc(rectF, mStartAngle, mSweepAngle, false, mCirclePaint);
    }

    public void startProgress() {
        if (mProgressAnim != null && mProgressAnim.isRunning()) {
            return;
        }
        if (mProgressAnim != null && !mProgressAnim.isRunning()) {
            mProgressAnim.start();
        }
        mProgressAnim = ValueAnimator.ofFloat(0, 360);
        mProgressAnim.setDuration(8000);
        mProgressAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mSweepAngle = ((Float) animation.getAnimatedValue());
                float fraction = animation.getAnimatedFraction();
                String value = String.valueOf(fraction * 100);
                mTextValue = value.substring(0, value.indexOf(".") + 2) + "%";
                invalidate();
            }
        });
        mProgressAnim.start();
    }
}
