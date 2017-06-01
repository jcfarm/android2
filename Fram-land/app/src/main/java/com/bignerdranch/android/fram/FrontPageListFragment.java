package com.bignerdranch.android.fram;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class FrontPageListFragment extends Fragment {

    private ViewPager mViewPager;
    private View status_View,control_View;
    ArrayList<View> viewList = new ArrayList<View>();
    ArrayList<String> title = new ArrayList<String>();
    PagerTabStrip tabStrip;

    private Intent i;
    private String[] status_List = new String[]{
        "温度",
            "空气湿度",
            "CO2",
            "土壤湿度",
            "电导率",
            "盐分",
    };
    private String[] status_data = new String[]{
            "20",
            "80",
            "20",
            "40",
            "10%",
            "2%",
    };
    private String[] control_List = new String[]{
            "电磁阀",
            "环流风机",
            "照明灯",
            "遮阳网",
            "侧卷膜",
            "顶卷膜",
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_shou_ye_list,container,false);
        mViewPager = (ViewPager)view.findViewById(R.id.front_view_pager);
        tabStrip = (PagerTabStrip)view.findViewById(R.id.tabstrip);
        tabStrip.setDrawFullUnderline(false);
        tabStrip.setBackgroundColor(this.getResources().getColor(R.color.content_background_color));
        tabStrip.setTabIndicatorColor(this.getResources().getColor(R.color.colorPrimary));
        tabStrip.setTextSpacing(200);

        status_View = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_status,null);
        control_View = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_page_list,null);

        RecyclerView recyclerView1 = (RecyclerView)status_View.findViewById(R.id.id_status_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.setAdapter(new ShouYeListAdapter());

        RecyclerView recyclerView2 = (RecyclerView)control_View.findViewById(R.id.id_control_list);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setAdapter(new controlListAdapter());

        viewList.add(status_View);
        viewList.add(control_View);

        title.add("状态");
        title.add("控制");

        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }


            //重写destroyItem解决bug
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                ((ViewPager)container).removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position){
                ((ViewPager)container).addView(viewList.get(position));
                return viewList.get(position);
            }
            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
            public int getItemPosition(Object object){
                return super.getItemPosition(object);
            }
            public CharSequence getPageTitle(int position){
                return title.get(position);
            }
        });
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //Toast.makeText(ShouYeListActivity.this,"hhh",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageSelected(int position) {
                //Toast.makeText(ShouYeListActivity.this,"33",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //Toast.makeText(ShouYeListActivity.this,"22",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }


    private class ShouYeListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private LinearLayout mLinearLayout;
        private ImageView mImageView;
        private TextView mItemTextView;
        private TextView mItemTextView2;

        public ShouYeListHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.status_item,container,false));

            mImageView = (ImageView)itemView.findViewById(R.id.status_control_item_img);
            mItemTextView = (TextView) itemView.findViewById(R.id.status_control_item_text1);
            mItemTextView2 = (TextView)itemView.findViewById(R.id.status_control_item_text2);
            mLinearLayout = (LinearLayout)itemView.findViewById(R.id.status_item);
            mLinearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            /*switch (getPosition()){
                case 0:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 1:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 2:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 3:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 4:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 5:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
            }*/
        }
    }


    private class ShouYeListAdapter extends RecyclerView.Adapter<ShouYeListHolder>{

        @Override
        public ShouYeListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater= LayoutInflater.from(getActivity());
            return new ShouYeListHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(ShouYeListHolder holder, int position) {
            Drawable drawable1 = getResources().getDrawable(R.drawable.a);
            Drawable drawable2 = getResources().getDrawable(R.drawable.b);
            switch (position){
                case 0:holder.mImageView.setImageDrawable(drawable1);
                    holder.mItemTextView.setText(status_List[position]);
                    holder.mItemTextView2.setText(status_data[position]);break;
                case 1:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);
                    holder.mItemTextView2.setText(status_data[position]);break;
                case 2:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);
                    holder.mItemTextView2.setText(status_data[position]);break;
                case 3:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);
                    holder.mItemTextView2.setText(status_data[position]);break;
                case 4:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);
                    holder.mItemTextView2.setText(status_data[position]);break;
                case 5:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);
                    holder.mItemTextView2.setText(status_data[position]);break;
            }

        }


        @Override
        public int getItemCount() {
            return 6;
        }
    }


    private class ControlHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private LinearLayout mLinearLayout;
        private ImageView mImageView;
        private TextView mItemTextView;
        private Switch mSwitch;

        public ControlHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.control_item,container,false));

            mImageView = (ImageView)itemView.findViewById(R.id.status_control_item_img);
            mItemTextView = (TextView) itemView.findViewById(R.id.status_control_item_text1);
            mLinearLayout = (LinearLayout)itemView.findViewById(R.id.status_item);
            mSwitch = (Switch)itemView.findViewById(R.id.switch_id);

            mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){

                    }else {

                    }
                }
            });
            mLinearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            /*switch (getPosition()){
                case 0:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 1:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 2:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 3:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 4:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 5:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
            }*/
        }
    }


    private class controlListAdapter extends RecyclerView.Adapter<ControlHolder>{

        @Override
        public ControlHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater= LayoutInflater.from(getActivity());
            return new ControlHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(ControlHolder holder, int position) {
            Drawable drawable1 = getResources().getDrawable(R.drawable.d);
            Drawable drawable2 = getResources().getDrawable(R.drawable.f);
            switch (position){
                case 0:holder.mImageView.setImageDrawable(drawable1);
                    holder.mItemTextView.setText(control_List[position]);break;
                case 1:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(control_List[position]);break;
                case 2:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(control_List[position]);break;
                case 3:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(control_List[position]);break;
                case 4:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(control_List[position]);break;
                case 5:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(control_List[position]);break;
            }

        }

        @Override
        public int getItemCount() {
            return 6;
        }
    }
}
