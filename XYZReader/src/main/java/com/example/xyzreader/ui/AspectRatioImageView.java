package com.example.xyzreader.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.xyzreader.R;

public class AspectRatioImageView extends ImageView {

    private static final float DEFAULT_ASPECT_RATIO = 1f;
    private float aspectRatio;


    public AspectRatioImageView(Context context) {
        this(context, null);
    }

    public AspectRatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AspectRatioImageView);
        aspectRatio = a.getFloat(R.styleable.AspectRatioImageView_aspectRatio, DEFAULT_ASPECT_RATIO);
        a.recycle();
    }

    public float getAspectRatio() {
        return aspectRatio;
    }

   public void setAspectRatio(float aspectRatio) {
        this.aspectRatio = aspectRatio;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int newHeight = (int) (getMeasuredWidth() * getAspectRatio());
        setMeasuredDimension(widthMeasureSpec, newHeight);
    }
}
