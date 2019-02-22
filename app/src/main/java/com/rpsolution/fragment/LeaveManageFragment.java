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
import com.rpsolution.adapter.LeaveManageAdapter;
import com.rpsolution.model.EmployeeModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaveManageFragment extends Fragment {

    private List<EmployeeModel> employeeModels = new ArrayList<>();
    private LeaveManageAdapter mAdapter;
    private DashboardActivity mActivity;
    @BindView(R.id.rv_leaveSum)
    protected RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_leave_manage, container, false);
        ButterKnife.bind(this, view);
        setTitle();
        initRecyclerView();
        return view;
    }

    private void initRecyclerView(){
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new LeaveManageAdapter(employeeModels);
        mRecyclerView.setAdapter(mAdapter);
        empIdSet();

    }

    private void setTitle(){
        mActivity = (DashboardActivity) getActivity();
        if (mActivity != null){
            mActivity.setToolbarTitle("Manage Leave");
        }
    }
    private void empIdSet(){


        String[] empId = {"Emp001","Emp002","Emp003","Emp004","Emp005","Emp006","Emp007","Emp008",
                "Emp009","Emp011","Emp012","Emp013","Emp014","Emp015","Emp016","Emp017","Emp018","Emp019","Emp020","Emp021","Emp022",
                "Emp023","Emp024","Emp025","Emp026","Emp027","Emp028","Emp029","Emp030","Emp031","Emp032",};
        for (int i = 0; i< empId.length; i++) {
            EmployeeModel employeeModel = new EmployeeModel(empId[i]);
            employeeModels.add(employeeModel);
            mAdapter.notifyDataSetChanged();
        }


    }


}
