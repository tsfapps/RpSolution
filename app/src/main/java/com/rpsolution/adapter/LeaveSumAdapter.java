package com.rpsolution.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rpsolution.R;
import com.rpsolution.model.LeaveSumModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaveSumAdapter extends RecyclerView.Adapter<LeaveSumAdapter.SummaryViewHolder> {

    private Context mContext;
    private List<LeaveSumModel> leaveSumModels;

    public LeaveSumAdapter(Context mContext, List<LeaveSumModel> leaveSumModels) {
        this.mContext = mContext;
        this.leaveSumModels = leaveSumModels;
    }

    @NonNull
    @Override
    public SummaryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frag_leave_sum_item, viewGroup, false);
        return new SummaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SummaryViewHolder summaryViewHolder, int i) {
        LeaveSumModel leaveSumModel = leaveSumModels.get(i);
        String monthStr = leaveSumModel.getMonth();
        String sickStr = leaveSumModel.getSickLeave();
        String casualStr = leaveSumModel.getCasualLeave();
        String totalStr = leaveSumModel.getTotalLeave();

        summaryViewHolder.tvSumMonth.setText(monthStr);
        summaryViewHolder.tvSumSick.setText(sickStr);
        summaryViewHolder.tvSumCasual.setText(casualStr);
        summaryViewHolder.tvSumTotal.setText(totalStr);

    }

    @Override
    public int getItemCount() {
        return leaveSumModels.size();
    }

    public class SummaryViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_sumMonth)
        protected TextView tvSumMonth;
        @BindView(R.id.tv_sumSick)
        protected TextView tvSumSick;
        @BindView(R.id.tv_sumCasual)
        protected TextView tvSumCasual;
        @BindView(R.id.tv_sumTotal)
        protected TextView tvSumTotal;

        public SummaryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
