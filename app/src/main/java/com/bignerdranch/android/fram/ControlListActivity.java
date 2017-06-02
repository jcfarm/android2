package com.bignerdranch.android.fram;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;


public class ControlListActivity extends AppCompatActivity {

    private TextView tt;
    static String control_title = "";
    private RecyclerView mRecyclerView;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_list);

        tt = (TextView)findViewById(R.id.control_select);
        tt.setText(control_title);
        mRecyclerView = (RecyclerView)findViewById(R.id.control_select_recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new ControlListActivity.ControlListAdapter());
    }
    public static Intent newIntent(Context packageContext,String s){
        Intent i = new Intent(packageContext,ControlListActivity.class);
        control_title = s;
        return i;
    }

    private class ControlListHolder extends RecyclerView.ViewHolder{

        private CheckBox checked;
        private TextView mTextView;

        public ControlListHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.control_list,container,false));

            mTextView = (TextView) itemView.findViewById(R.id.id_number);
            checked = (CheckBox) itemView.findViewById(R.id.id_checkbox);

        }
    }


    private class ControlListAdapter extends RecyclerView.Adapter<ControlListHolder>{

        @Override
        public ControlListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater= LayoutInflater.from(ControlListActivity.this);
            return new ControlListHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(ControlListHolder homeHodler, int position) {

            switch (position){
                case 0:
                    homeHodler.mTextView.setText(position+1+"");break;
                case 1:
                    homeHodler.mTextView.setText(position+1+"");break;
                case 2:
                    homeHodler.mTextView.setText(position+1+"");break;
                case 3:
                    homeHodler.mTextView.setText(position+1+"");break;
                case 4:
                    homeHodler.mTextView.setText(position+1+"");break;
                case 5:
                    homeHodler.mTextView.setText(position+1+"");break;
            }

        }
        @Override
        public int getItemCount() {
            return 6;
        }
    }
}
