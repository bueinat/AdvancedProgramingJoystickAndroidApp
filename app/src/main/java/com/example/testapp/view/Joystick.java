package com.example.testapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.example.testapp.R;

import androidx.annotation.Nullable;

public class Joystick extends View {
    private boolean mShowText;

    public Joystick(Context context) {
        super(context);
    }

    public Joystick(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.Joystick,
                0, 0);

        try {
            boolean mShowText = a.getBoolean(R.styleable.Joystick_showText, false);
            int textPos = a.getInteger(R.styleable.Joystick_labelPosition, 0);
        } finally {
            a.recycle();
        }
    }

    public boolean isShowText() {
        return mShowText;
    }

    public void setShowText(boolean showText) {
        mShowText = showText;
        invalidate();
        requestLayout();
    }

}
