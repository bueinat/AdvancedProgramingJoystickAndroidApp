package com.example.testapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.example.testapp.R;

import androidx.annotation.Nullable;

@FunctionalInterface
interface Changeable
{
    void onChange(float a, float e);
}


public class Joystick extends View {

    private Paint joystickPaint;
    private int mCircleColor;
    private int mCircleRadius;
    private float mCircleX, mCircleY;
    public Changeable service;

//    public void onChange(float a, float e);

    public Joystick(Context context) {
        super(context);
        init(null);
    }

    public Joystick(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public Joystick(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

//    public Joystick(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//        init(attrs);
//    }

    private void init(@Nullable AttributeSet set) {
        joystickPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        if (set == null)
            return;
        TypedArray ta = getContext().obtainStyledAttributes(set, R.styleable.Joystick);
        mCircleColor = ta.getColor(R.styleable.Joystick_circle_color, Color.GREEN);
        mCircleRadius = ta.getDimensionPixelSize(R.styleable.Joystick_circle_radius, 100);

        joystickPaint.setColor(mCircleColor);
        ta.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        if (mCircleX == 0f || mCircleY == 0f) {
            mCircleX = (float)getWidth() / 2; // (float)(getWidth() - mCircleRadius * 1.5);
            mCircleY = (float)getWidth() / 2; // (float) (getHeight() - mCircleRadius * 1.5);
        }
        canvas.drawCircle(mCircleX, mCircleY, mCircleRadius, joystickPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                return true;
            }
            case MotionEvent.ACTION_MOVE: {
                float x = event.getX();
                float y = event.getY();
                double dx = Math.pow(x - mCircleX, 2);
                double dy = Math.pow(y - mCircleY, 2);

                if (dx + dy < Math.pow(mCircleRadius, 2)) {
                    // touched
                    mCircleX = x;
                    mCircleY = y;

                    // send elevator and aileron values
                    float a = x / (getWidth() - 2 * mCircleRadius) - 0.5f;  // aileron
                    float e = y / (getHeight() - 2 * mCircleRadius) - 0.5f; // elevator
                    service.onChange(a, e);
                    postInvalidate();
                    return true;
                }
            }
        }
        return value;
    }
}
