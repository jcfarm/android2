package com.bignerdranch.android.fram;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends FragmentActivity{

    private Class[] fragment = new Class[]{
            FrontPageFragment.class,
            MonitorFragment.class,
            ControlFragment.class,
            DataFragment.class
    };


    //右边fragment
    private Fragment[] childFragment = new Fragment[]{
            new FrontPageListFragment(),//添加了一个videoview
            new MonitorScreenFragment(),//添加了一个recyclerView
            new FrontControlFragment(),
            new FrontDataFragment()
    };
    private int[] imgSelector = new int[]{
            R.drawable.frontpage,
            R.drawable.monitoring,
            R.drawable.control,
            R.drawable.data,
    };
    private String[] name = new String[]{
            "首页",
            "监控",
            "控制",
            "数据",
    };

    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_content,childFragment[0]).commit();

        FragmentTabHost tabHost = (FragmentTabHost)findViewById(R.id.tabHost);
        tabHost.setup(MainActivity.this,getSupportFragmentManager(),android.R.id.tabcontent);

        for(int i=0;i<fragment.length;i++){

            View inflater = getLayoutInflater().inflate(R.layout.tab_item,null);
            ImageView tab_img = (ImageView) inflater.findViewById(R.id.iv);
            TextView tab_text = (TextView) inflater.findViewById(R.id.tv);

            tab_img.setImageResource(imgSelector[i]);
            tab_text.setText(name[i]);
            tabHost.addTab(tabHost.newTabSpec(""+ i).setIndicator("tab1").setIndicator(inflater),fragment[i],null);
        }


        //切换fragment，解决视图重叠
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                switch (s){
                    case "0":
                        transaction = manager.beginTransaction();
                        transaction.replace(R.id.fragment_content,childFragment[0]).commit();
                        break;
                    case "1":
                        transaction = manager.beginTransaction();
                        transaction.replace(R.id.fragment_content,childFragment[1]).commit();
                        break;
                    case "2":
                        transaction = manager.beginTransaction();
                        transaction.replace(R.id.fragment_content,childFragment[2]).commit();
                        break;
                    case "3":
                        transaction = manager.beginTransaction();
                        transaction.replace(R.id.fragment_content,childFragment[3]).commit();
                        break;
                }
            }
        });

    }

}
