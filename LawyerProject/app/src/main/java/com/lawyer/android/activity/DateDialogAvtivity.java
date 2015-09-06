package com.lawyer.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.lawyer.android.R;
import com.lawyer.android.date.DatePicker;
import com.lawyer.android.util.AppUtils;
import com.lawyer.android.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDialogAvtivity extends Activity {

    private TextView tv_title;

    private Button btn_done, btn_cancel;

    private String title_name;
    
    private DatePicker datePicker;
    

    @SuppressWarnings({ "deprecation", "static-access" })
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_date);
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        // 设置窗口的大小及透明度
        layoutParams.width = LayoutParams.FILL_PARENT;
        layoutParams.height = layoutParams.FILL_PARENT;
        window.setAttributes(layoutParams);
        String day=getIntent().getStringExtra("day");

        datePicker=(DatePicker) findViewById(R.id.datePicker);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText(title_name);
        btn_done = (Button) findViewById(R.id.btn_done);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        datePicker.setCalendar(getCalendar(day));


        btn_done.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String dayString=datePicker.getYear()+"-"+(datePicker.getMonth()+1)+"-"+datePicker.getDay();
//                Calendar calendar=Calendar.getInstance();
//                calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDay());
                Intent intent=new Intent();
                intent.putExtra("day", dayString);
                setResult(PersonActivity.CODE_DATE, intent);
                finish();
            }
        });

        btn_cancel.setOnClickListener(new OnClickListener() {

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
    
    private Calendar getCalendar(String day) {
        if(StringUtils.isEmpty(day)) {
            day= AppUtils.getSimpleDate();
        }
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = null;
        Date date;
        try {
            date = sdf.parse(day);
            calendar = Calendar.getInstance();
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

}
