package com.lawyer.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lawyer.android.R;
import com.lawyer.android.util.Constants;
import com.lawyer.android.wheel.WheelView;
import com.lawyer.android.wheel.adapter.ArrayWheelAdapter;


/**
 * Created by hm-soft on 2015/8/31.
 */
public class WheelDialogAvtivity extends Activity {
    private TextView tv_title;

    private WheelView mWheelView;

    private Button btn_done, btn_cancel;

    private String[] array;

    private String title_name;

    private int tag;

    @SuppressWarnings({ "deprecation", "static-access" })
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_wheel);
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        // 设置窗口的大小及透明度
        layoutParams.width = LinearLayout.LayoutParams.FILL_PARENT;
        layoutParams.height = layoutParams.FILL_PARENT;
        window.setAttributes(layoutParams);

        tag = getIntent().getIntExtra("Tag", 0);

        if (tag == Constants.WHEEL_SEX) {
            title_name=getString(R.string.lawyer_gender);
            array = getResources()
                    .getStringArray(R.array.sex_items);
        }else if (tag == Constants.WHEEL_EDU) {
            title_name = getString(R.string.lawyer_edu);
            array = getResources().getStringArray(R.array.edu_items);
        }
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText(title_name);
        btn_done = (Button) findViewById(R.id.btn_done);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        mWheelView = (WheelView) findViewById(R.id.id_province);
        mWheelView.setViewAdapter(new ArrayWheelAdapter<String>(
                WheelDialogAvtivity.this, array));
        // 设置可见条目数量
        mWheelView.setVisibleItems(7);

        btn_done.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String name = array[mWheelView.getCurrentItem()];
                Intent intent = new Intent();
                intent.putExtra("name", name);
                if (tag == Constants.WHEEL_SEX) {
                    setResult(PersonActivity.CODE_GENDER, intent);
                }else if (tag == Constants.WHEEL_EDU) {
                    setResult(PersonActivity.CODE_EDU, intent);
                }
                onfinish();
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                onfinish();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int height = findViewById(R.id.pop_layout).getTop();
        int y = (int) event.getY();
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (y < height) {
                onfinish();
            }
        }
        return true;
    }

    private void onfinish() {
        finish();
        overridePendingTransition(R.anim.push_bottom_in, R.anim.push_bottom_out);
    }
}
