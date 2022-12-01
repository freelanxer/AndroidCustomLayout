package com.example.androidcustomlayout.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import com.example.androidcustomlayout.R;

public class IconButton extends LinearLayout {

    private Drawable imgSrc = ResourcesCompat.getDrawable(getResources(), android.R.drawable.alert_dark_frame, null);
    private String textString= getResources().getString(R.string.func_01);
    private int backgroundColor = ResourcesCompat.getColor(getResources(), R.color.icon_button_01, null);

    public IconButton(Context context) {
        super(context);
    }

    public IconButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.IconButton);
        getValues(typedArray);
        initViews();
    }

    public IconButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.IconButton, defStyleAttr, 0);
        getValues(typedArray);
        initViews();
    }

    private void getValues(TypedArray typedArray) {
        imgSrc = typedArray.getDrawable(R.styleable.IconButton_imgSrc) == null ?
                ResourcesCompat.getDrawable(getResources(), android.R.drawable.alert_dark_frame, null) :
                typedArray.getDrawable(R.styleable.IconButton_imgSrc);
        textString = typedArray.getString(R.styleable.IconButton_textString) == null ?
                getResources().getString(R.string.func_01) :
                typedArray.getString(R.styleable.IconButton_textString);
        backgroundColor = typedArray.getColor(R.styleable.IconButton_backgroundColor, ResourcesCompat.getColor(getResources(), R.color.icon_button_01, null));
        typedArray.recycle();
    }

    private void initViews() {
        View view = inflate(getContext(), R.layout.component_icon_button, this);
        setOrientation(HORIZONTAL);

        Drawable background = ResourcesCompat.getDrawable(getResources(), R.drawable.bg_icon_button, null);
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(backgroundColor);
        }
        setBackground(background);

        setPadding(dpToPx(10), dpToPx(10), dpToPx(10), dpToPx(10));

        ImageView img = view.findViewById(R.id.img);
        TextView text = view.findViewById(R.id.text);

        img.setImageDrawable(imgSrc);
        text.setText(textString);

    }

    public int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    public int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

}
