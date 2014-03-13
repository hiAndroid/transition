package com.wuzhong.frag;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by luu on 14-3-12.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这里我只是简单的用num区别标签，其实具体应用中可以使用真实的fragment对象来作为叶片

    }
    /**为Fragment加载布局时调用**/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        View view = inflater.inflate(R.layout.fragment_pager_list, null);
        TextView tv = new TextView(this.getActivity());
        tv.setText("main fragment");
        container.addView(tv);
        return container;
    }


}
