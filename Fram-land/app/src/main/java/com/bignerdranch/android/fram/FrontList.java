package com.bignerdranch.android.fram;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by apple on 17/5/18.
 */

public class FrontList {

    private TextView mTextView;
    private ImageView mImageView;

    public FrontList(){

    }

    public TextView getTextView() {
        return mTextView;
    }

    public void setTextView(TextView textView) {
        mTextView = textView;
    }

    public ImageView getImageView() {
        return mImageView;
    }

    public void setImageView(ImageView imageView) {
        mImageView = imageView;
    }
}
