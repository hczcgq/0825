package com.lawyer.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.lawyer.android.R;
import com.lawyer.android.base.BaseUIActivity;

/**
 * Created by hm-soft on 2015/8/31.
 */
public class UpdatePersonActivity extends BaseUIActivity{

    private int tag=-1;

    private EditText nameTextView;

    private String name="";

    @Override
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.view_update_person);
        tag=getIntent().getIntExtra("tag",-1);
        name=getIntent().getStringExtra("name");
        initView();
    }

    private void initView() {
        nameTextView= (EditText) findViewById(R.id.nameTextView);
        nameTextView.setText(name);
        nameTextView.setSelection(name.length());
        if(tag==PersonActivity.CODE_NAME){
            setHeadTitle("修改律师姓名");
        }else if(tag==PersonActivity.CODE_EXPERTH){
            setHeadTitle("修改擅长领域");
        }else if(tag==PersonActivity.CODE_MOBILE){
            setHeadTitle("修改联系手机");
        }else if(tag==PersonActivity.CODE_TEL){
            setHeadTitle("修改联系电话");
        }else if(tag==PersonActivity.CODE_CERTIFICATENO){
            setHeadTitle("修改执业证书编号");
        }else if(tag==PersonActivity.CODE_IDCARD){
            setHeadTitle("修改身份证号码");
        }else if(tag==PersonActivity.CODE_FIRMNAME){
            setHeadTitle("修改律所名称");
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
                name=nameTextView.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("name",name);
                setResult(tag,intent);
                finish();
            }
        });
    }
}
