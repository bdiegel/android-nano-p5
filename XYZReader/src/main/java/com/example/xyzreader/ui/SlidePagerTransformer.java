package com.example.xyzreader.ui;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Custom page transformer slides next pager on/off previous page depending on swipe direction.
 */
class SlidePagerTransformer implements ViewPager.PageTransformer {

    private static final float SCALE_FACTOR = 0.85f;
    private static final float MIN_ALPHA = 0.2f;

    public SlidePagerTransformer() {
    }

    public void transformPage(View page, float position) {
        final float alpha;
        final float scale;
        final float translationX;

        // the page to the left
        if (position < 0 && position > -1) {
            scale = Math.abs(Math.abs(position) - 1) * (1.0f - SCALE_FACTOR) + SCALE_FACTOR;
            alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position));
            float tx = page.getWidth() * position;
            translationX = tx < page.getWidth() ? -tx : 0;
        } else {
            alpha = 1;
            scale = 1;
            translationX = 0;
        }

        page.setAlpha(alpha);
        page.setTranslationX(translationX);
        page.setScaleX(scale);
        page.setScaleY(scale);
    }
}
