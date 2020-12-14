package com.androidmaterialdesign.view;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by lk on 2017/11/29.
 */

public class MyTextWatch implements TextWatcher {
    android.support.design.widget.TextInputLayout mTextInputLayout;
    String mErrorTip;

    public MyTextWatch(android.support.design.widget.TextInputLayout textInputLayout, String errorTip) {
        mTextInputLayout = textInputLayout;
        mErrorTip = errorTip;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (mTextInputLayout.getEditText().getText().toString().trim().length() > 6) {
            mTextInputLayout.setErrorEnabled(true);
            mTextInputLayout.setError(mErrorTip);
        } else {
            mTextInputLayout.setErrorEnabled(false);
        }
    }
}
