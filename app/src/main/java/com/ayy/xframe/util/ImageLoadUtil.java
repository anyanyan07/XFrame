package com.ayy.xframe.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageLoadUtil {
    /**
     * 默认fitCenter,ImageView设置了scaleType则按照scaleType来缩放和裁剪图片
     */
    public static void load(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }

    /**
     * 等比例缩放，不裁剪，两边可能留白
     */
    public static void fitCenter(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).fitCenter().into(imageView);
    }

    /**
     * 不缩放，从中间裁剪，填充布局
     */
    public static void centerCrop(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).centerCrop().into(imageView);
    }

    /**
     * 不缩放，从中间裁剪，填充布局
     */
    public static void circleCrop(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).circleCrop().into(imageView);
    }

}
