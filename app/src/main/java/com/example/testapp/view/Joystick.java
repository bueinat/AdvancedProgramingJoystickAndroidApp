package com.example.testapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.example.testapp.R;

import androidx.annotation.Nullable;

/* Writing this component I used some youtube video which explained most of this */

@FunctionalInterface
/**
 * Functional interface used for updating joystick using strategy pattern
 */
interface Changeable
{
    void onChange(float a, float e);
}


public class Joystick extends View {

    private Paint joystickPaint;
    private int mCircleRadius;
    private float mCircleX, mCircleY;
    public Changeable setEA;


    // constructors - all of them are needed for layouts stuff
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

    /**
     * initialize the Joystick component - pick colors and sized via given set
     * @param set: set of attributes passed for creating the joystick
     */
    private void init(@Nullable AttributeSet set) {
        joystickPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        if (set == null)
            return;
        TypedArray ta = getContext().obtainStyledAttributes(set, R.styleable.Joystick);
        int mCircleColor = ta.getColor(R.styleable.Joystick_circle_color, Color.GREEN);
        mCircleRadius = ta.getDimensionPixelSize(R.styleable.Joystick_circle_radius, 100);

        joystickPaint.setColor(mCircleColor);
        ta.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // draw the circle on the canvas
        if (mCircleX == 0f || mCircleY == 0f) {
            mCircleX = (float)getWidth() / 2;
            mCircleY = (float)getWidth() / 2;
        }
        canvas.drawCircle(mCircleX, mCircleY, mCircleRadius, joystickPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // treat touch event
        // if no action eas caught, the returned value will be returned
        boolean value = super.onTouchEvent(event);

        // pick an action
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                return true;
            }
            // move the joystick and update aileron, elevation
            case MotionEvent.ACTION_MOVE: {
                // get (x, y) of the touch
                float x = event.getX();
                float y = event.getY();
                double dx = Math.pow(x - mCircleX, 2);
                double dy = Math.pow(y - mCircleY, 2);

                // if the touch is inside the circle
                if (dx + dy < Math.pow(mCircleRadius, 2)) {

                    x = Math.max(1, Math.min(x, getWidth())); // x in [0, width]
                    y = Math.max(1, Math.min(y, getHeight())); // x in [0, height]
                    // move the circle to the touched point
                    mCircleX = x;
                    mCircleY = y;

                    // send elevator and aileron values
                    float a = 2 * x / getWidth()  - 1;  // aileron
                    float e = 2 * y / getHeight() - 1;  // elevator
                    setEA.onChange(a, -e);              // update the joystick
                    postInvalidate();                   // re-draw
                    return true;
                }
            }
        }
        return value;
    }
}