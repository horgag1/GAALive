package com.example.gerard.gaalive.viewmodel;

import android.arch.lifecycle.ViewModel;

/**
 * Created by gerard on 23/01/2018.
 */

public class MainActivityViewModel extends ViewModel {

    private boolean mIsSigningIn;



    public MainActivityViewModel() {
        mIsSigningIn = false;

    }

    public boolean getIsSigningIn() {
        return mIsSigningIn;
    }

    public void setIsSigningIn(boolean mIsSigningIn) {
        this.mIsSigningIn = mIsSigningIn;
    }


}
