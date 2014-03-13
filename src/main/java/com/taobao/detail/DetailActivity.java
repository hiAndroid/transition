package com.taobao.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
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

        fragmentTransaction.add( R.id.detail_frame, mMainFragment,mMainFragment.getClass().getSimpleName());

        fragmentTransaction.commit();

        mFragmentManager.addOnBackStackChangedListener(this);

        backStackCount = mFragmentManager.getBackStackEntryCount();

    }

    public void openMoreService(View view){

        mMainFragment.getView().setVisibility(View.GONE);

        Log.e("[detail]", "open more service");

        if( null == mFragmentManager.findFragmentByTag(MoreServiceFragment.class.getSimpleName())){

            Fragment newFragment = new MoreServiceFragment();

            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.detail_frame, newFragment,newFragment.getClass().getSimpleName());

            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commitAllowingStateLoss();

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

        backStackCount = mFragmentManager.getBackStackEntryCount();

    }

//    @Override
//    public void onBackPressed() {
//
//    }
}
