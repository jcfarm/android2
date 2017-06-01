package com.bignerdranch.android.fram;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FrontControlFragment extends Fragment {

    private RecyclerView recyclerView;

    //private static final String EXTRA_POSITION="com.example.zhangnan.myfarm.position";

    public static int Tag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_control_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.control_details_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setAdapter(new SoundAdapter());
        return view;
    }


    private class SoundHodler extends RecyclerView.ViewHolder {

        public SoundHodler(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.control_details_list_item,container,false));
        }

    }


    private class SoundAdapter extends RecyclerView.Adapter<SoundHodler>{

        @Override
        public SoundHodler onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater= LayoutInflater.from(getActivity());
            return new SoundHodler(inflater,parent);
        }

        @Override
        public void onBindViewHolder(SoundHodler soundHodler, int position) {


        }

        @Override
        public int getItemCount() {
            return 1;
        }
    }




}
