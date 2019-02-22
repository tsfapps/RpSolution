package com.rpsolution.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rpsolution.R;
import com.rpsolution.model.EmployeeModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaveManageAdapter extends RecyclerView.Adapter<LeaveManageAdapter.LeaveViewHolder> {

    private List<EmployeeModel> employeeModels;

    public LeaveManageAdapter(List<EmployeeModel> employeeModels) {
        this.employeeModels = employeeModels;
    }

    @NonNull
    @Override
    public LeaveViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frag_leave_manage_item, viewGroup, false);
        return new LeaveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LeaveViewHolder leaveViewHolder, int i) {

        EmployeeModel employeeModel = employeeModels.get(i);
        leaveViewHolder.tvEmpId.setText(employeeModel.getEmpId());

        final String strAprove = leaveViewHolder.tvApprove.getText().toString().trim();
        final String strReject = leaveViewHolder.tvReject.getText().toString().trim();
        leaveViewHolder.tvApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), strAprove, Toast.LENGTH_SHORT).show();
            }
        });

        leaveViewHolder.tvReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), strReject, Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return employeeModels.size();
    }

    public class LeaveViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_empId)
        protected TextView tvEmpId;
        @BindView(R.id.tv_approve)
        protected TextView tvApprove;
        @BindView(R.id.tv_reject)
        protected TextView tvReject;

        public LeaveViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
