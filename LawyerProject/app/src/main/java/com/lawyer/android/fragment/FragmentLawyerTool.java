package com.lawyer.android.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lawyer.android.R;
import com.lawyer.android.adapter.ToolAdapter;
import com.lawyer.android.activity.WebViewActivity;
import com.lawyer.android.bean.ToolEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class FragmentLawyerTool extends Fragment {
    private ListView mListView;

    private List<ToolEntity> toolEntities;

    public FragmentLawyerTool() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_fragment_tool, null);

        mListView = (ListView) view.findViewById(R.id.toolListView);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDate();
    }

    private void initDate(){
        toolEntities = getToolEntities();
        mListView.setAdapter(new ToolAdapter(getActivity(), toolEntities));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        //点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToolEntity item= toolEntities.get(position);
                Intent intent=new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("item",item);
                startActivity(intent);
            }
        });
    }

    /**
     * 初始化功能列表数据
     * @return
     */
    private List<ToolEntity> getToolEntities(){
        List<ToolEntity> list=new ArrayList<>();
        list.add(new ToolEntity(R.drawable.chagongsi,"查公司","全国公司信息随便查","http://gsxt.saic.gov.cn/"));
        list.add(new ToolEntity(R.drawable.fatiao,"查法条","全国法律法规随便搜","http://m.pkulaw.cn/law/"));
        list.add(new ToolEntity(R.drawable.panjue,"查判决","全国法院判决书轻松找","http://www.court.gov.cn/extension/search.htm"));
        list.add(new ToolEntity(R.drawable.shangbiao,"查商标","全国商标一键搜","http://sbcx.saic.gov.cn:9080/tmois/wszhcx_getZhcx.xhtml"));
        list.add(new ToolEntity(R.drawable.zhuanli,"查专利","全国专利一站查","http://www.pss-system.gov.cn/sipopublicsearch/search/searchHome-searchIndex.shtml?params=991CFE73D4DF553253D44E119219BF31366856FF4B152226CAE4DB031259396A"));
        list.add(new ToolEntity(R.drawable.daimazheng,"查代码证","全国代码证轻松查","http://www.nacao.org.cn/"));
        list.add(new ToolEntity(R.drawable.fayuan,"查法院","全国法院信息汇总","http://baike.baidu.com/court/"));
        list.add(new ToolEntity(R.drawable.laolai,"查老赖","全国老赖信息汇总","http://shixin.court.gov.cn/"));
        return list;
    }
}
