package com.taobao.detail;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import com.taobao.detail.fragment.MainFragment;
import com.taobao.detail.fragment.MoreServiceFragment;
import com.wuzhong.R;

/**
 * Created by wuzhong on 14-3-13.
 */
public class DetailActivity extends FragmentActivity implements FragmentManager.OnBackStackChangedListener{

    private FragmentManager mFragmentManager;
    private Fragment mMainFragment;
    private int backStackCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.detail_activity);

        mMainFragment = new MainFragment();

        mFragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        fragmentTransaction.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);

        fragmentTransaction.add( R.id.detail_frame, mMainFragment,mMainFragment.getClass().getSimpleName());

        fragmentTransaction.commit();

        mFragmentManager.addOnBackStackChangedListener(this);

        backStackCount = mFragmentManager.getBackStackEntryCount();

//        mMainFragment.getView().startAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_in));



    }

    public void openMoreService(View view){

//        mMainFragment.getView().setVisibility(View.GONE);

        Log.e("[detail]", "open more service");

        if( null == mFragmentManager.findFragmentByTag(MoreServiceFragment.class.getSimpleName())){

            Fragment newFragment = new MoreServiceFragment();

            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

            fragmentTransaction.setCustomAnimations(
                    R.anim.slide_in_top,
                    R.anim.fade_out);

            fragmentTransaction.add(R.id.detail_frame, newFragment,newFragment.getClass().getSimpleName());

            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commitAllowingStateLoss();

//            fragmentTransaction.show(newFragment);

        }else{





        }
    }


    @Override
    public void onBackStackChanged() {
        Log.e("[detail]", "onBackStackChanged");
        mFragmentManager.getBackStackEntryCount();

        if(mFragmentManager.getBackStackEntryCount() < backStackCount){
            mMainFragment.getView().setVisibility(View.VISIBLE);
        }

        ;

        //mMainFragment.getView().startAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_in));


        mMainFragment.getView().startAnimation(getPushForwardAni(this));

        backStackCount = mFragmentManager.getBackStackEntryCount();

    }

    public ScaleAnimation getPushmBackAni(Context mContext) {
        ScaleAnimation mPushBackAni = new ScaleAnimation(1.0f, 0.9f, 1.0f,
                0.9f, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        mPushBackAni.setDuration(700);
        mPushBackAni.setStartOffset(100);
        mPushBackAni.setFillAfter(true);
        mPushBackAni.setInterpolator(AnimationUtils.loadInterpolator(mContext,
                R.anim.detail_pushback_overshoot));
        return mPushBackAni;
    }

    public ScaleAnimation getPushForwardAni(Context mContext) {
        ScaleAnimation mPushForwardAni = new ScaleAnimation(0.9f, 1.0f, 0.9f,
                1.0f, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        mPushForwardAni.setDuration(700);
        mPushForwardAni.setFillAfter(true);
        return mPushForwardAni;
    }

//    @Override
//    public void onBackPressed() {
//
//    }
}
