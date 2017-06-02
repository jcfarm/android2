package com.bignerdranch.android.fram;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FrontPageFragment extends Fragment {

    private String[] listName = new String[]{
        "一号田",
            "二号田",
            "三号田",
            "四号田",
            "五号田",
            "六号田",
    };
    private int[] listImg = new int[]{
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.j,
    };
    private Intent i;

    private RecyclerView recyclerView;

    public FrontPageFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_frontpage,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_frontpage_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
       recyclerView.setAdapter(new FrontPageAdapter());
       return view;
    }

    private class FrontPageHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private LinearLayout homeLinearLayout;
        private ImageView homeImageView;
        private TextView homeItemTextView;

        public FrontPageHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.frontpage,container,false));
            //View view = inflater.inflate(R.layout.frontpage,container,false);
            homeImageView = (ImageView)itemView.findViewById(R.id.list_img);
            homeItemTextView = (TextView) itemView.findViewById(R.id.list_name);
            homeLinearLayout = (LinearLayout)itemView.findViewById(R.id.list_frontPage);
            homeLinearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (getPosition()){
                case 0:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 1:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 2:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 3:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 4:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
                case 5:i = ShouYeListActivity.newIntent(getActivity());startActivity(i);break;
            }
        }
    }


    private class FrontPageAdapter extends RecyclerView.Adapter<FrontPageHolder>{

        @Override
        public FrontPageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater= LayoutInflater.from(getActivity());
            return new FrontPageHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(FrontPageHolder homeHodler, int position) {
            Drawable drawable1 = getResources().getDrawable(R.drawable.a);
            Drawable drawable2 = getResources().getDrawable(R.drawable.b);
            switch (position){
                case 0:homeHodler.homeImageView.setImageDrawable(drawable1);
                    homeHodler.homeItemTextView.setText(listName[position]);break;
                case 1:homeHodler.homeImageView.setImageDrawable(drawable2);
                    homeHodler.homeItemTextView.setText(listName[position]);break;
                case 2:homeHodler.homeImageView.setImageDrawable(drawable2);
                    homeHodler.homeItemTextView.setText(listName[position]);break;
                case 3:homeHodler.homeImageView.setImageDrawable(drawable2);
                    homeHodler.homeItemTextView.setText(listName[position]);break;
                case 4:homeHodler.homeImageView.setImageDrawable(drawable2);
                    homeHodler.homeItemTextView.setText(listName[position]);break;
                case 5:homeHodler.homeImageView.setImageDrawable(drawable2);
                    homeHodler.homeItemTextView.setText(listName[position]);break;
            }

        }


        @Override
        public int getItemCount() {
            return 6;
        }
    }
}
