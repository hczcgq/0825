package com.lawyer.android.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.lawyer.android.R;
import com.lawyer.android.activity.PersonActivity;
import com.lawyer.android.adapter.MenuAdapter;
import com.lawyer.android.bean.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hm-soft on 2015/8/27.
 */
public class FragmentMenu extends Fragment {

    private ListView mListView;
    private List<MenuItem> menuItems;
    private ImageView avaterImageView;
    public FragmentMenu() {

    }

    @Override
    public void onAttach(Activity activity) {
        try {
            mCallback = (MenuListOnItemClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()+ " must implement OnResolveTelsCompletedListener");
        }
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_fragment_main_menu, null);
        mListView = (ListView) view.findViewById(R.id.activity_main_menu_listview);
        avaterImageView= (ImageView) view.findViewById(R.id.avaterImageView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView(){
        menuItems=getMenuItems();
        mListView.setAdapter(new MenuAdapter(getActivity(),menuItems));
        //列表点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCallback.onMenuItemClick(position,menuItems.get(position).getName());
            }
        });

        //点击头像
        avaterImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent(getActivity(),PersonActivity.class);
                startActivity(inten);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mCallback.onMenuItemClick(-1,-1);
                    }
                }, 1000);
            }
        });
    }

    /**
     * 初始化功能列表数据
     * @return
     */
    private List<MenuItem> getMenuItems(){
        List<MenuItem> list=new ArrayList<>();
        list.add(new MenuItem(R.drawable.order,R.string.menu_order));
        list.add(new MenuItem(R.drawable.tool,R.string.menu_tool));
        list.add(new MenuItem(R.drawable.message,R.string.menu_message));
        list.add(new MenuItem(R.drawable.help,R.string.menu_help));
        list.add(new MenuItem(R.drawable.aboutus,R.string.menu_about));
        return list;
    }


    private MenuListOnItemClickListener mCallback;

    public interface MenuListOnItemClickListener{
        public void onMenuItemClick(int position,int title);
    }
}
