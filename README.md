github 地址https://github.com/1104436107/Banner_master_milaoshu

这里写图片描述

1主要有两种模式 
convenientBanner.OpenBanner(false); 普通模式 
convenientBanner.OpenBanner(true); banner模式

 /**
     * @param model true 打开banner模式  false 普通模式 默认打开
     */
    public void OpenBanner(boolean model) {
        if (model == false) {
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams
            (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0, 0, 0, 0);
            viewPager.setLayoutParams(lp);
        }
    }
1
2
3
4
5
6
7
8
9
10
11
这里写图片描述

2 主MainActivity Activity 中 主要调用代码

 /**
     * @param mcontext  上下文
     * @param imagess   图片数组
     * @param convenientBanner  控件
     * @param title      banner 样式
     * @param mOnItemClickListener  item的点击事件
     */
  new TakeTurns(this, null, convenientBanner,"RotateDown", new OnItemClickListener() {
            @Override
            public void onItemClick(int position){

            }
        });
1
2
3
4
5
6
7
8
9
10
11
12
13
 @Override
    public void onResume() {
        super.onResume();
        //开始自动翻页
        convenientBanner.startTurning(1000);
    }


    @Override
    public void onPause() {
        super.onPause();
        //停止翻页
        convenientBanner.stopTurning();
    }
1
2
3
4
5
6
7
8
9
10
11
12
13
14
3 标红的间距

 <com.milaoshu.convenientbanner.view.CBLoopViewPager
            android:id="@+id/cbLoopViewPager"
            android:layout_width="match_parent"
            android:clipChildren="false"
            android:layout_marginRight="60dp"
            android:layout_marginLeft="60dp"
            android:layout_height="match_parent" />
1
2
3
4
5
6
7
android:layout_marginRight="60dp"
android:layout_marginLeft="60dp"   设置margin就可以。。。
1
2
convenientBanner.getViewPager().setPageMargin(30);  设置图中白色部分的距离
1
这里写图片描述

4 
依赖库依赖就行，，，

这里写图片描述

github 地址https://github.com/1104436107/Banner_master_milaoshu 
欢迎下载代码查看 为开源贡献自己的一份力 欢迎 start ，死啦死啦地fork 哈哈哈。。。
