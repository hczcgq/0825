package com.lawyer.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.lawyer.android.R;
import java.util.ArrayList;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener {
    private int[] images = { R.drawable.nav1, R.drawable.nav2,
            R.drawable.nav3 };

    private ImageView[] points = new ImageView[images.length];

    private ArrayList<ImageView> imageViews = new ArrayList<ImageView>();

    private ViewPager viewPager;

    private LinearLayout mLinearLayout;

    private int current = 0;// 默认在第一页

    private Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.view_guide);
        btn_start=(Button) findViewById(R.id.btn_start);
        viewPager = (ViewPager) findViewById(R.id.s_viewPage);
        viewPager.setOnPageChangeListener(this);
        mLinearLayout = (LinearLayout) this.findViewById(R.id.linearlayout);
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            Integer in = Integer.valueOf(i);
            imageView.setTag(in);
            ImageView.ScaleType type = ImageView.ScaleType.CENTER_CROP;
            imageView.setScaleType(type);
            imageViews.add(imageView);
        }
        ViewPageAdapter adpter = new ViewPageAdapter();
        viewPager.setAdapter(adpter);
        initPoints();

        btn_start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(GuideActivity.this,
                        LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    /**
     * 初始化小圆点
     */
    private void initPoints() {
        for (int i = 0; i < images.length; i++) {
            points[i] = (ImageView) mLinearLayout.getChildAt(i);
            points[i].setImageResource(R.drawable.point_normal);

        }
        current = 0;// 默认在第一页
        points[current].setImageResource(R.drawable.point_select);// 此刻处于第一页，把第一页的小圆圈设置为unenabled
    }

    class ViewPageAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public Object instantiateItem(View container, int position) {
            ((ViewPager) container).addView(imageViews.get(position));
            return imageViews.get(position);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager) container).removeView(imageViews.get(position));
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
        switch (arg0) {
            case ViewPager.SCROLL_STATE_DRAGGING:
                break;
            case ViewPager.SCROLL_STATE_SETTLING:
                break;
            case ViewPager.SCROLL_STATE_IDLE:
                break;
        }
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    @Override
    public void onPageSelected(int arg0) {
        points[arg0].setImageResource(R.drawable.point_select);
        points[current].setImageResource(R.drawable.point_normal);
        current = arg0;

        if (current==images.length-1) {
            btn_start.setVisibility(View.VISIBLE);
        }else {
            btn_start.setVisibility(View.GONE);
        }
    }
}

