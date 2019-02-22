package com.rpsolution.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rpsolution.R;
import com.rpsolution.adapter.LeaveManageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaveManageFragment extends Fragment {

    @BindView(R.id.rv_leaveSum)
    protected RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_leave_manage, container, false);
        ButterKnife.bind(this, view);
        initRecyclerView();
        return view;
    }

    private void initRecyclerView(){
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        LeaveManageAdapter mAdapter = new LeaveManageAdapter();
        mRecyclerView.setAdapter(mAdapter);

    }
}
