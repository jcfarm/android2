package com.bignerdranch.android.fram;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ControlFragment extends Fragment {

    private String[] control_List = new String[]{
            "电磁阀",
            "环流风机",
            "照明灯",
            "遮阳网",
            "侧卷膜",
            "顶卷膜",
    };
    private RecyclerView mRecyclerView;
    private Intent i;


    public ControlFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.control,container,false);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.control_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new MonitorAdapter());

        return view;
    }

    private class ControlHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private LinearLayout mLinearLayout;
        private TextView mTextView;

        public ControlHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.fragment_control,container,false));

            mTextView = (TextView) itemView.findViewById(R.id.control_text);
            mLinearLayout = (LinearLayout)itemView.findViewById(R.id.control_view_layout);
            mLinearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            switch (getPosition()){
                case 0:i = ControlListActivity.newIntent(getActivity(),control_List[getPosition()]);startActivity(i);break;
                case 1:i = ControlListActivity.newIntent(getActivity(),control_List[getPosition()]);startActivity(i);break;
                case 2:i = ControlListActivity.newIntent(getActivity(),control_List[getPosition()]);startActivity(i);break;
                case 3:i = ControlListActivity.newIntent(getActivity(),control_List[getPosition()]);startActivity(i);break;
                case 4:i = ControlListActivity.newIntent(getActivity(),control_List[getPosition()]);startActivity(i);break;
                case 5:i = ControlListActivity.newIntent(getActivity(),control_List[getPosition()]);startActivity(i);break;
            }

        }
    }


    private class MonitorAdapter extends RecyclerView.Adapter<ControlHolder>{

        @Override
        public ControlHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater= LayoutInflater.from(getActivity());
            return new ControlHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(ControlHolder homeHodler, int position) {

            switch (position){
                case 0:
                    homeHodler.mTextView.setText(control_List[position]);break;
                case 1:
                    homeHodler.mTextView.setText(control_List[position]);break;
                case 2:
                    homeHodler.mTextView.setText(control_List[position]);break;
                case 3:
                    homeHodler.mTextView.setText(control_List[position]);break;
                case 4:
                    homeHodler.mTextView.setText(control_List[position]);break;
                case 5:
                    homeHodler.mTextView.setText(control_List[position]);break;
            }

        }
        @Override
        public int getItemCount() {
            return 6;
        }
    }
}
