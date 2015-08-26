package com.lawyer.android.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.lawyer.android.R;
import com.lawyer.android.adapter.MenuAdapter;
import com.lawyer.android.bean.MenuItem;
import com.lawyer.android.fragment.FragmentAboutUs;
import com.lawyer.android.fragment.FragmentHelpCenter;
import com.lawyer.android.fragment.FragmentLawyerTool;
import com.lawyer.android.fragment.FragmentOrder;
import com.lawyer.android.fragment.FragmentMessage;
import com.lawyer.android.view.MainLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class MainActivity extends FragmentActivity{
    private MainLayout mainLayout;
    private ListView mListView;
    private List<MenuItem> menuItems;

    private Button btMenu;

    private TextView titleTextView;

    private ImageView imageTitle;

    private View menuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainLayout = (MainLayout)this.getLayoutInflater().inflate(R.layout.view_main, null);
        setContentView(mainLayout);

        menuView=findViewById(R.id.menuView);

        menuItems =getMenuItems();
        mListView = (ListView) menuView.findViewById(R.id.activity_main_menu_listview);
        mListView.setAdapter(new MenuAdapter(this,menuItems));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onMenuItemClick(parent, view, position, id);
            }

        });


        // Get menu button
        btMenu = (Button) findViewById(R.id.activity_main_content_button_menu);
        btMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toggleMenu(v);
            }
        });
        titleTextView = (TextView) findViewById(R.id.titleTextView);


        FragmentManager fm = MainActivity.this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        FragmentOrder fragment = new FragmentOrder();
        ft.add(R.id.activity_main_content_fragment, fragment);
        ft.commit();
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

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    public void toggleMenu(View v){
        mainLayout.toggleMenu();
    }

    // Perform action when a menu item is clicked
    private void onMenuItemClick(AdapterView<?> parent, View view, int position, long id) {
        int selectedItem =menuItems.get(position).getName();
        String currentItem = titleTextView.getText().toString();

        if(getString(selectedItem).compareTo(currentItem) == 0) {
            mainLayout.toggleMenu();
            return;
        }
        FragmentManager fm = MainActivity.this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = null;

        if(selectedItem == R.string.menu_order) {
            fragment = new FragmentOrder();
        } else if(selectedItem == R.string.menu_tool) {
            fragment = new FragmentLawyerTool();
        } else if(selectedItem == R.string.menu_message) {
            fragment = new FragmentMessage();
        } else if(selectedItem == R.string.menu_help) {
            fragment = new FragmentHelpCenter();
        } else if(selectedItem == R.string.menu_about) {
            fragment = new FragmentAboutUs();
        }

        if(fragment != null) {
            ft.replace(R.id.activity_main_content_fragment, fragment);
            ft.commit();
            titleTextView.setText(selectedItem);
        }
        mainLayout.toggleMenu();
    }

    @Override
    public void onBackPressed() {
        if (mainLayout.isMenuShown()) {
            mainLayout.toggleMenu();
        }
        else {
            super.onBackPressed();
        }
    }

}
