package com.portal.banner_milaoshu;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.milaoshu.convenientbanner.ConvenientBanner;
import com.milaoshu.convenientbanner.holder.CBViewHolderCreator;
import com.milaoshu.convenientbanner.holder.Holder;
import com.milaoshu.convenientbanner.listener.OnItemClickListener;
import com.milaoshu.convenientbanner.transformer.AlphaPageTransformer;
import com.milaoshu.convenientbanner.transformer.NonPageTransformer;
import com.milaoshu.convenientbanner.transformer.RotateDownPageTransformer;
import com.milaoshu.convenientbanner.transformer.RotateUpPageTransformer;
import com.milaoshu.convenientbanner.transformer.RotateYTransformer;
import com.milaoshu.convenientbanner.transformer.ScaleInTransformer;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 轮廓图
 * Created by chengaofu on 2017/4/27.
 * 1104436107@qq.com
 */

public class TakeTurns<T> {
    /**
     * @param mcontext  上下文
     * @param images   图片数组
     * @param convenientBanner  控件
     * @param title      banner 样式
     * @param mOnItemClickListener  item的点击事件
     */
    public TakeTurns(Context mcontext,List<Integer> images, ConvenientBanner convenientBanner, String title, OnItemClickListener mOnItemClickListener) {
        setPageImage((List<T>) images, convenientBanner, title, mOnItemClickListener);
    }
    private void setPageImage(List<T> images, ConvenientBanner convenientBanner, String title, OnItemClickListener mOnItemClickListener) {
        if (images == null) {
            List<Integer> images2 = new ArrayList<>();
            images2.add( R.mipmap.tupian);
            images2.add(R.mipmap.tupian);
            images2.add(R.mipmap.tupian);
            setBannerPage((List<T>) images2, convenientBanner, title, mOnItemClickListener);
        }
        else
        setBannerPage(images, convenientBanner, title, mOnItemClickListener);
    }

    private void setBannerPage(List<T> imagess, ConvenientBanner convenientBanner, String title, OnItemClickListener mOnItemClickListener) {
        convenientBanner.getViewPager().setPageMargin(30);
        convenientBanner.getViewPager().setOffscreenPageLimit(3);
        convenientBanner.setPointViewVisible(true);

        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, imagess).setOnItemClickListener(mOnItemClickListener)
                .setPageIndicator(new int[]{
                        R.mipmap.ic_page_indicator,
                        R.mipmap.ic_page_indicator_focused
                }).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);

        setSelectType(convenientBanner, title);
    }

    private void setSelectType(ConvenientBanner convenientBanner, String title) {
        if ("RotateDown".equals(title)) {
            convenientBanner.getViewPager().setPageTransformer(true, new RotateDownPageTransformer());
        } else if ("RotateUp".equals(title)) {
            convenientBanner.getViewPager().setPageTransformer(true, new RotateUpPageTransformer());
        } else if ("RotateY".equals(title)) {
            convenientBanner.getViewPager().setPageTransformer(true, new RotateYTransformer(45));
        } else if ("Standard".equals(title)) {
//            convenientBanner.getViewPager().setClipChildren(false);
            convenientBanner.getViewPager().setPageTransformer(true, NonPageTransformer.INSTANCE);
            convenientBanner.getViewPager().setPageMargin(0);
        } else if ("Alpha".equals(title)) {
//            convenientBanner.getViewPager().setClipChildren(false);
            convenientBanner.getViewPager().setPageTransformer(true, new AlphaPageTransformer());
        } else if ("ScaleIn".equals(title)) {
            convenientBanner.OpenBanner(false);
            convenientBanner.getViewPager().setPageTransformer(true, new ScaleInTransformer());
        } else if ("RotateDown and Alpha".equals(title)) {
            convenientBanner.getViewPager().setPageTransformer(true, new RotateDownPageTransformer(new AlphaPageTransformer()));
        } else if ("RotateDown and Alpha And ScaleIn".equals(title)) {
            convenientBanner.getViewPager().setPageTransformer(true, new RotateDownPageTransformer(new AlphaPageTransformer(new ScaleInTransformer())));
        }
    }


    class NetworkImageHolderView implements Holder<Integer> {
        private ImageView imageView;
        @Override
        public View createView(Context context) {
            //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }
        @Override
        public void UpdateUI(Context context, int position, Integer data) {
            Glide.with(context).load(data).error(R.mipmap.tupian).placeholder(R.mipmap.tupian).into(imageView);
        }
    }
}
