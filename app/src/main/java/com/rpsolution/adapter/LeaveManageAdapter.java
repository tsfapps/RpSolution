package com.rpsolution.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rpsolution.R;
import com.rpsolution.model.EmployeeModel;
import com.rpsolution.utils.DateUtils;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaveManageAdapter extends RecyclerView.Adapter<LeaveManageAdapter.LeaveViewHolder> {

    private Context mContext;
    private List<EmployeeModel> employeeModels;

    public LeaveManageAdapter(Context mContext, List<EmployeeModel> employeeModels) {
        this.mContext = mContext;
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
        final String empIdStr = employeeModel.getEmpId();
        leaveViewHolder.tvEmpId.setText(empIdStr);

        final String strAprove = leaveViewHolder.tvApprove.getText().toString().trim();
        final String strReject = leaveViewHolder.tvReject.getText().toString().trim();
        leaveViewHolder.tvApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), strAprove, Toast.LENGTH_SHORT).show();
                String subject = "Leave Approved";
                String content ="Employee Id : "+ empIdStr + "\nYour leave has approved.";
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"employee@gmail.com"});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, content);
                mContext.startActivity(emailIntent);
            }
        });

        leaveViewHolder.tvReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), strReject, Toast.LENGTH_SHORT).show();
                String subject = "Leave Not Approved";
                String content = "Employee Id : "+ empIdStr + "\nYour leave has not approved.";
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"employee@gmail.com"});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, content);
                mContext.startActivity(emailIntent);

            }
        });
    }

//    private void sendMAil(){
//
//
//            String dateFrom = tvDateFrom.getText().toString().trim();
//            String dateTo = tvDateTo.getText().toString().trim();
//            String dateDiff = DateUtils.timeDiff(dateFrom, dateTo);
//            String content = "Emp Id : "+userType+userPass+userPhone+"\nReason : "+rbLeaveButton.getText().toString().trim()+"\nFrom : "+dateFrom+ " \nTo : "+dateTo+"\nTotal Leave : "+dateDiff;
//
//
//    }



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
