package com.wuzhong;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import com.wuzhong.frag.MyFragmentPageAdapter;

public class HelloAndroidActivity extends FragmentActivity {

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after 
     * previously being shut down then this Bundle contains the data it most 
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        ViewPager mViewPager = (ViewPager) findViewById(R.id);
//
//        mViewPager.setOffscreenPageLimit(0);
//
//        //这里因为是3.0一下版本，所以需继承FragmentActivity，通过getSupportFragmentManager()获取FragmentManager
//        //3.0及其以上版本，只需继承Activity，通过getFragmentManager获取事物
//        FragmentManager fm = this.getSupportFragmentManager();
//        //初始化自定义适配器
//        MyFragmentPageAdapter mAdapter =  new MyFragmentPageAdapter(fm);
//        //绑定自定义适配器
//        mViewPager.setAdapter(mAdapter);



    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//	// Inflate the menu; this adds items to the action bar if it is present.
//	getMenuInflater().inflate(com.wuzhong.R.menu.main, menu);
//	return true;
//    }

}

