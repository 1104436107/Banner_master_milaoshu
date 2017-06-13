/**
 * des: 无线轮番图
 * Created by chengaofu
 * on 2016.09.16:45  QQ 1104436107
 */
//是利用https://github.com/DreaminginCodeZH/Douya  +  com.bigkoo.convenientbanner   整合

       convenientBanner.getViewPager().setPageMargin(30);
        convenientBanner.getViewPager().setOffscreenPageLimit(3);

        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, networkImages).setOnItemClickListener(this)
                .setPageIndicator(new int[]{
                        R.mipmap.ic_page_indicator,
                        R.mipmap.ic_page_indicator_focused
                }).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
             convenientBanner.getViewPager().setPageTransformer(true, new ScaleInTransformer());

              //  String title = item.getTitle().toString();
              //  mViewPager.setAdapter(mAdapter);



               //  mViewPager.setPageTransformer(true, new RotateDownPageTransformer());


               //  mViewPager.setPageTransformer(true, new RotateUpPageTransformer());


               //  mViewPager.setPageTransformer(true, new RotateYTransformer(45));



               //  mViewPager.setClipChildren(false);
              //   mViewPager.setPageTransformer(true, NonPageTransformer.INSTANCE);

              //   mViewPager.setClipChildren(false);
              //   mViewPager.setPageTransformer(true, new AlphaPageTransformer());

              //   mViewPager.setPageTransformer(true, new ScaleInTransformer());

                // mViewPager.setPageTransformer(true, new RotateDownPageTransformer(new AlphaPageTransformer()));

              //   mViewPager.setPageTransformer(true, new RotateDownPageTransformer(new AlphaPageTransformer(new ScaleInTransformer())));


