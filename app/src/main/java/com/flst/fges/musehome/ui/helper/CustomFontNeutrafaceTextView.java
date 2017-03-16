package com.flst.fges.musehome.ui.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by LAMOOT Alexandre on 11/03/2017.
 */

public class CustomFontNeutrafaceTextView extends android.support.v7.widget.AppCompatTextView {

    public static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";

    public CustomFontNeutrafaceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context, attrs);
    }

    public CustomFontNeutrafaceTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context, attrs);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {
        int textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", Typeface.NORMAL);

        Typeface customFont = selectTypeface(context, textStyle);
        setTypeface(customFont);
    }

    private Typeface selectTypeface(Context context, int textStyle) {
        /*
        * information about the TextView textStyle:
        * http://developer.android.com/reference/android/R.styleable.html#TextView_textStyle
        */
        switch (textStyle) {
            case Typeface.BOLD: // bold
                return FontCache.getTypeface("Neutra2Cond-Bold.otf", context);

            case Typeface.ITALIC: // italic
                return FontCache.getTypeface("Neutra2Text-LightItalic.otf", context);

            case Typeface.BOLD_ITALIC: // bold italic
                return FontCache.getTypeface("Neutra2Text-BookItalic.otf", context);

            case Typeface.NORMAL: // regular
            default:
                return FontCache.getTypeface("Neutra2Display-Light.otf", context);
        }
    }
}