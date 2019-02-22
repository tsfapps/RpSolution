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
import com.rpsolution.activity.DashboardActivity;
import com.rpsolution.adapter.LeaveSumAdapter;
import com.rpsolution.model.LeaveSumModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaveSumFragment extends Fragment {

    private String phoneStr;
    private String passStr;
    private int userType;

    public static LeaveSumFragment newInstance(String phoneStr, String passStr, int userType) {
        LeaveSumFragment fragment = new LeaveSumFragment();
        fragment.phoneStr = phoneStr;
        fragment.passStr = passStr;
        fragment.userType = userType;
        return fragment;
    }

    private List<LeaveSumModel> leaveSumModels = new ArrayList<>();
    @BindView(R.id.rv_leaveSum)
    protected RecyclerView rvLeaveSum;
    private LeaveSumAdapter mAdapter;
    private DashboardActivity mActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_leave_sum, container,false);
        ButterKnife.bind(this,view);
        setTitle();
        initRecyclerView();
        return view;
    }
    private void setTitle(){
        String titleStr = userType+passStr+phoneStr;
        mActivity = (DashboardActivity)getActivity();
        if (mActivity != null){
            mActivity.setToolbarTitle(titleStr);
        }
    }
    private void initRecyclerView(){
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rvLeaveSum.setLayoutManager(mLayoutManager);
        mAdapter = new LeaveSumAdapter(getContext(), leaveSumModels);
        rvLeaveSum.setAdapter(mAdapter);
        setDataLeaveSum();
    }


    private void setDataLeaveSum(){
        String[] monthsStr = {"Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] sickLeaveStr = {"2", "0", "1", "0", "0", "0", "2", "0", "3", "0", "0", "0"};
        String[] casualLeaveStr = {"0", "0", "3", "0", "0", "2", "4", "0", "0", "0", "0", "4"};
        String[] totalLeaveStr = {"2", "0", "4", "0", "0", "2", "6", "0", "0", "0", "0", "4"};

        for(int i = 0 ; i<monthsStr.length; i++) {
            LeaveSumModel leaveSumModel = new LeaveSumModel(monthsStr[i], sickLeaveStr[i], casualLeaveStr[i], totalLeaveStr[i]);
            leaveSumModels.add(leaveSumModel);

        }
        mAdapter.notifyDataSetChanged();
    }
}
