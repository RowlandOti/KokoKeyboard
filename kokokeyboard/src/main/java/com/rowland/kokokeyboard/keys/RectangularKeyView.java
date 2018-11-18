package com.rowland.kokokeyboard.keys;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;
import com.rowland.kokokeyboard.R;

import androidx.appcompat.widget.AppCompatButton;


public class RectangularKeyView extends AppCompatButton {

    private float screenWidthPercentage = 0.3f;

    public RectangularKeyView(Context context) {
        super(context);
    }

    public RectangularKeyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RectangularKeyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.KeyPadView);
        try {
            this.screenWidthPercentage = a.getFloat(R.styleable.KeyPadView_screen_width_percent, 0.30f);
        } finally {
            a.recycle();
        }
    }


    public float getScreenWidthPercentage() {
        return this.screenWidthPercentage;
    }
}
