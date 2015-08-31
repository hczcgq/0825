package com.lawyer.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lawyer.android.R;
import com.lawyer.android.base.BaseUIActivity;

/**
 * Created by hm-soft on 2015/8/31.
 */
public class UpdatePersonActivity extends BaseUIActivity{

    private int tag=-1;

    private TextView nameTextView;

    @Override
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.view_update_person);
        tag=getIntent().getIntExtra("tag",-1);
        initView();
    }

    private void initView() {
        nameTextView= (TextView) findViewById(R.id.nameTextView);

        if(tag==PersonActivity.CODE_NAME){
            setHeadTitle("修改律师姓名");
        }else if(tag==PersonActivity.CODE_FIRM){
            setHeadTitle("修改执业律所");
        }
        showLeftButton();
        addLeftButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        showRightButton(getString(R.string.save));
        addRightButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameTextView.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("name",name);
                setResult(tag,intent);
                finish();
            }
        });
    }
}
