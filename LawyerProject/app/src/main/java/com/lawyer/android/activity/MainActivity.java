package com.lawyer.android.activity;

import android.content.DialogInterface;
import android.content.Intent;
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
import com.lawyer.android.fragment.FragmentMain;
import com.lawyer.android.fragment.FragmentMenu;
import com.lawyer.android.fragment.FragmentMessage;
import com.lawyer.android.fragment.FragmentOrder;
import com.lawyer.android.util.Constants;
import com.lawyer.android.util.DialogUtil;
import com.lawyer.android.util.PreferencesUtils;
import com.lawyer.android.util.StringUtils;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class MainActivity extends SlidingFragmentActivity implements FragmentMenu.MenuListOnItemClickListener {
    private Button btMenu,btPerson;

    private TextView titleTextView;

    private SlidingMenu mSlidingMenu;

    public static final int REQUEST_CODE=100;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_main);

        initView();
        initEvent();
    }


    /**
     * 初始化控件
     */
    private void initView(){
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
        fragmentTransaction.replace(R.id.content, new FragmentMain());
        fragmentTransaction.commit();

        // Get menu button
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        btMenu = (Button) findViewById(R.id.menuButton);
        btPerson= (Button) findViewById(R.id.PersonButton);
    }

    /**
     * 初始化事件
     */
    private void initEvent(){
        btMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toggle();
            }
        });
        btPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lawyerId= PreferencesUtils.getString(MainActivity.this, Constants.PRE_LAWYERID, null);
                String mobile=PreferencesUtils.getString(MainActivity.this, Constants.PRE_MOBILE, null);
                if(StringUtils.isEmpty(lawyerId)&&StringUtils.isEmpty(mobile)){
                    DialogUtil.showCustomDialog(MainActivity.this, "提示", "您还没有登录，是否现在等", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    });
                }else{
                    Intent intent=new Intent(MainActivity.this,PersonActivity.class);
                    startActivity(intent);
//                    startActivityForResult(intent,REQUEST_CODE);
                }

            }
        });
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

        if(title == R.string.menu_main) {
            fragment = new FragmentMain();
        }else if (title == R.string.menu_order) {
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE&&resultCode==REQUEST_CODE){

        }
    }
}
