package com.taobao.detail.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.wuzhong.R;

/**
 * Created by wuzhong on 14-3-13.
 */
public class MoreServiceFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_more_service_fragment, container, false);

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.close_layout);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
//        this.getView().bringToFront();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("[detail]", "destroy more service fragment");
    }
}
