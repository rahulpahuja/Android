package com.rahul.toolbarnotificationapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class NotificationMenuItem {

    private static final String EMPTY_STRING = "";
    private static final int ZERO = 0;
    private View item;
    private Context context;
    private MenuItem menuItem;
    private int icon;
    private int count = 0;

    public NotificationMenuItem(Context context, MenuItem menuItem, @DrawableRes int icon) {

        this.context = context;
        this.menuItem = menuItem;
        this.icon = icon;
        LayoutInflater inflater = LayoutInflater.from(context);
        //this.item = inflater.inflate(R.layout.cart_layout, null);
        this.item = inflater.inflate(R.layout.cart_layout, null, false);
        updateNotificationIcon();
    }

    private int getIcon() {
        return icon;
    }

    private int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void incrementCount() {
        count++;
        updateNotificationIcon();
    }

    public void decrementCount() {
        if (validateCount(getCount())) {
            count--;
        }
        updateNotificationIcon();
    }

    private boolean validateCount(int count) {
        boolean validationResult;
        validationResult = count > ZERO;
        return validationResult;

    }

    private void updateNotificationIcon() {
        this.menuItem.setIcon(generateCounterDrawable());
    }

    private Drawable generateCounterDrawable() {
        item.setBackgroundResource(getIcon());
        TextView counterTextView = (TextView) item.findViewById(R.id.tv_count);
        autoControlVisibility(counterTextView);
        item.measure(View.MeasureSpec.makeMeasureSpec(ZERO, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(ZERO, View.MeasureSpec.UNSPECIFIED));

        item.layout(ZERO, ZERO, item.getMeasuredWidth(), item.getMeasuredHeight());
        item.setDrawingCacheEnabled(true);
        item.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        Bitmap notifierIcon = Bitmap.createBitmap(item.getDrawingCache());
        item.setDrawingCacheEnabled(false);
        return new BitmapDrawable(context.getResources(), notifierIcon);
    }

    private void autoControlVisibility(TextView counterTextView) {
        if (validateCount(getCount())) {
            counterTextView.setVisibility(View.VISIBLE);
            counterTextView.setText(EMPTY_STRING + getCount());
        } else {
            counterTextView.setVisibility(View.GONE);
        }
    }
}
