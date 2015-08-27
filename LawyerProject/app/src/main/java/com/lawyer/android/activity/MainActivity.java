package com.lawyer.android.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.lib.SlidingFragmentActivity;
import com.lawyer.android.R;
import com.lawyer.android.fragment.FragmentAboutUs;
import com.lawyer.android.fragment.FragmentHelpCenter;
import com.lawyer.android.fragment.FragmentLawyerTool;
import com.lawyer.android.fragment.FragmentMenu;
import com.lawyer.android.fragment.FragmentMessage;
import com.lawyer.android.fragment.FragmentOrder;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class MainActivity extends SlidingFragmentActivity implements FragmentMenu.MenuListOnItemClickListener {
    private Button btMenu;

    private TextView titleTextView;

    private SlidingMenu mSlidingMenu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_main);
        setBehindContentView(R.layout.frame_left_menu);
        mSlidingMenu = getSlidingMenu();
        mSlidingMenu.setMode(SlidingMenu.LEFT);//设置左右都可以划出SlidingMenu菜单
        mSlidingMenu.setShadowDrawable(R.drawable.drawer_shadow);//设置阴影图片
        mSlidingMenu.setShadowWidthRes(R.dimen.shadow_width); //设置阴影图片的宽度
        mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset); //SlidingMenu划出时主页面显示的剩余宽度
        mSlidingMenu.setFadeDegree(0.35f);
        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.left_menu, new FragmentMenu());
        fragmentTransaction.replace(R.id.content, new FragmentOrder());
        fragmentTransaction.commit();

        // Get menu button
        btMenu = (Button) findViewById(R.id.activity_main_content_button_menu);
        btMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toggle();
            }
        });
        titleTextView = (TextView) findViewById(R.id.titleTextView);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onMenuItemClick(int position, int title) {

        if(position==-1||title==-1){
            toggle();
            return;
        }

        String currentItem = titleTextView.getText().toString();

        if (getString(title).compareTo(currentItem) == 0) {
            toggle();
            return;
        }
        FragmentManager fm = MainActivity.this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = null;

        if (title == R.string.menu_order) {
            fragment = new FragmentOrder();
        } else if (title == R.string.menu_tool) {
            fragment = new FragmentLawyerTool();
        } else if (title == R.string.menu_message) {
            fragment = new FragmentMessage();
        } else if (title == R.string.menu_help) {
            fragment = new FragmentHelpCenter();
        } else if (title == R.string.menu_about) {
            fragment = new FragmentAboutUs();
        }

        if (fragment != null) {
            ft.replace(R.id.content, fragment);
            ft.commit();
            titleTextView.setText(title);
        }
        toggle();
    }
}
