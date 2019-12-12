package com.ayy.xframe.ui;


import androidx.fragment.app.Fragment;

import com.ayy.xframe.R;
import com.ayy.xframe.base.BaseFragment;
import com.ayy.xframe.databinding.FragmentMeBinding;
import com.ayy.xframe.util.ImageLoadUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends BaseFragment<FragmentMeBinding> {
    private String path = "http://g.hiphotos.baidu.com/image/h%3D300/sign=b5e4c905865494ee982209191df4e0e1/c2cec3fdfc03924590b2a9b58d94a4c27d1e2500.jpg";


    public MeFragment() {
        // Required empty public constructor
    }

    public static MeFragment getInstance() {
        return new MeFragment();
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initData() {
        ImageLoadUtil.fitCenter(context, path, binding.iv1);
        ImageLoadUtil.centerCrop(context, path, binding.iv2);
        ImageLoadUtil.load(context, path, binding.iv3);
        ImageLoadUtil.load(context, path, binding.iv4);

    }

}
