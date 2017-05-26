package com.bignerdranch.android.fram;


import android.app.Fragment;
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

    private Fragment[] childFragment = new Fragment[]{
            new FrontPageListFragment(),
            new MonitorScreenFragment(),
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                switch (s){
                    case "0":addFragment(childFragment[0],"0");System.out.println(s);break;
                    case "1":addFragment(childFragment[1],"1");System.out.println(s);break;
                    case "2":addFragment(childFragment[2],"2");System.out.println(s);break;
                    case "3":addFragment(childFragment[3],"3");System.out.println(s);break;
                }
            }
        });

        addFragment(childFragment[0],"0");
    }
    private void addFragment(Fragment fragment, String tag){
        android.app.FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragment.isAdded()){
            transaction.replace(R.id.fragment_content,fragment);
            transaction.commit();
        }else {
            transaction.add(R.id.fragment_content,fragment,tag);
            transaction.commit();
        }

    }


}
