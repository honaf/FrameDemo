package com.honaf.hedge.vendor.imageloader;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by apple on 16/7/29.
 */
public class ImageLoader {

    private static Context sContext;

    public static void init(Context context) {
        sContext = context;
    }

    private static Context getContext() {
        if (sContext == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        return sContext;
    }

    private static RequestManager getRequestManager(Context context) {
        if (context instanceof FragmentActivity) {
            return  Glide.with((FragmentActivity) context);
        } else if (context instanceof Activity) {
            return  Glide.with((Activity) context);
        } else {
            return  Glide.with(context);
        }
    }


    public static void load(String url,ImageView imageView) {
        getRequestManager(getContext()).load(url).into(imageView);
    }

    public static void load(Context context, String url, ImageView imageView) {
        getRequestManager(context).load(url).into(imageView);
    }


    public static void load(String url, ImageView imageView, ScaleType scaleType) {
        switch (scaleType) {
            case CENTER_CROP:
                getRequestManager(getContext()).load(url).centerCrop().into(imageView);
                break;
            case FIT_CENTER:
                getRequestManager(getContext()).load(url).fitCenter().into(imageView);
                break;
        }
    }



    public static void load(Context context,String url, ImageView imageView, ScaleType scaleType) {
        switch (scaleType) {
            case CENTER_CROP:
                getRequestManager(context).load(url).centerCrop().into(imageView);
                break;
            case FIT_CENTER:
                getRequestManager(context).load(url).fitCenter().into(imageView);
                break;
        }
    }

    public static void load(Context context,String url, ImageView imageView, ScaleType scaleType,int drawableId,int errorDrawableId) {
        switch (scaleType) {
            case CENTER_CROP:
                getRequestManager(context).load(url).centerCrop().placeholder(drawableId).error(errorDrawableId).into(imageView);
                break;
            case FIT_CENTER:
                getRequestManager(context).load(url).fitCenter().placeholder(drawableId).error(errorDrawableId).into(imageView);
                break;
        }
    }

    public static void load(Context context, String url, ImageView imageView, ScaleType scaleType, int drawableId, int errorDrawableId, BitmapTransformation bitmapTransformation) {
        switch (scaleType) {
            case CENTER_CROP:
                getRequestManager(context).load(url).centerCrop().placeholder(drawableId).error(errorDrawableId).transform(bitmapTransformation).into(imageView);
                break;
            case FIT_CENTER:
                getRequestManager(context).load(url).fitCenter().placeholder(drawableId).error(errorDrawableId).transform(bitmapTransformation).into(imageView);
                break;
        }
    }

    public static void load(Context context, String url, ImageView imageView, ScaleType scaleType,BitmapTransformation bitmapTransformation) {
        switch (scaleType) {
            case CENTER_CROP:
                getRequestManager(context).load(url).centerCrop().transform(bitmapTransformation).into(imageView);
                break;
            case FIT_CENTER:
                getRequestManager(context).load(url).fitCenter().transform(bitmapTransformation).into(imageView);
                break;
        }
    }






}
