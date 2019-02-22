package com.rpsolution.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rpsolution.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaveManageAdapter extends RecyclerView.Adapter<LeaveManageAdapter.LeaveViewHolder> {


    @NonNull
    @Override
    public LeaveViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frag_leave_manage_item, viewGroup, false);
        return new LeaveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LeaveViewHolder leaveViewHolder, int i) {

        leaveViewHolder.tvApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Leave Approved", Toast.LENGTH_SHORT).show();
            }
        });

        leaveViewHolder.tvReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Leave Not Approved", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    public class LeaveViewHolder extends RecyclerView.ViewHolder{

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
