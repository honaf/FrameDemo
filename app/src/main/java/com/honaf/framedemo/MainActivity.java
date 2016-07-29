package com.honaf.framedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.honaf.hedge.vendor.imageloader.ImageLoader;
import com.honaf.hedge.vendor.imageloader.ScaleType;
import com.honaf.hedge.vendor.imageloader.glide.GlideCircleTransform;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.iv_avatar)
    ImageView mIvAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mTvTitle.setText("ButterKnife");
//        Glide.with(this)
//                .load("http://d.hiphotos.baidu.com/image/pic/item/562c11dfa9ec8a13f075f10cf303918fa1ecc0eb.jpg")
////                .centerCrop()
//                .fitCenter()
//                .placeholder(R.mipmap.ic_launcher)
//                .crossFade()
//                .into(mIvAvatar);
        ImageLoader.load(this,"http://d.hiphotos.baidu.com/image/pic/item/562c11dfa9ec8a13f075f10cf303918fa1ecc0eb.jpg",mIvAvatar, ScaleType.CENTER_CROP,new GlideCircleTransform(this));
    }
}
