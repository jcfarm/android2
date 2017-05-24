package com.bignerdranch.android.fram;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShouYeListActivity extends AppCompatActivity {

    private Intent i;
    private String[] status_List = new String[]{
            "温度",
            "空气湿度",
            "CO2",
            "土壤湿度",
            "电导率",
            "盐分",
    };
    private String[] control_List = new String[]{
            "电磁阀",
            "环流风机",
            "照明灯",
            "遮阳网",
            "侧卷膜",
            "顶卷膜",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shou_ye_list);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.status_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ShouYeListAdapter());
    }

    private class ShouYeListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private LinearLayout mLinearLayout;
        private ImageView mImageView;
        private TextView mItemTextView;
        private TextView mItemTextView2;

        public ShouYeListHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.status_control_item,container,false));

            mImageView = (ImageView)itemView.findViewById(R.id.status_control_item_img);
            mItemTextView = (TextView) itemView.findViewById(R.id.status_control_item_text1);
            mItemTextView2 = (TextView)itemView.findViewById(R.id.status_control_item_text2);
            mLinearLayout = (LinearLayout)itemView.findViewById(R.id.status_control_item_layout);
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
            LayoutInflater inflater= LayoutInflater.from(ShouYeListActivity.this);
            return new ShouYeListHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(ShouYeListHolder holder, int position) {
            Drawable drawable1 = getResources().getDrawable(R.drawable.a);
            Drawable drawable2 = getResources().getDrawable(R.drawable.b);
            switch (position){
                case 0:holder.mImageView.setImageDrawable(drawable1);
                    holder.mItemTextView.setText(status_List[position]);break;
                case 1:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);break;
                case 2:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);break;
                case 3:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);break;
                case 4:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);break;
                case 5:holder.mImageView.setImageDrawable(drawable2);
                    holder.mItemTextView.setText(status_List[position]);break;
            }

        }


        @Override
        public int getItemCount() {
            return 6;
        }
    }
    public static Intent newIntent(Context packageContext){
        Intent i = new Intent(packageContext,ShouYeListActivity.class);
        return i;
    }
}
