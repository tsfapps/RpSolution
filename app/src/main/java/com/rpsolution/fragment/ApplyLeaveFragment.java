package com.rpsolution.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rpsolution.R;
import com.rpsolution.activity.DashboardActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ApplyLeaveFragment extends Fragment {

    private DashboardActivity mActivity;

    @BindView(R.id.tv_subject)
    protected TextView tvSubject;

    @BindView(R.id.et_body)
    protected TextInputEditText etBody;

    String userPhone;
    String userPass;
    int userType;
    public static ApplyLeaveFragment newInstance(String userPhone, String userPass, int userType) {

        ApplyLeaveFragment fragment = new ApplyLeaveFragment();
        fragment.userPhone = userPhone;
        fragment.userPass = userPass;
        fragment.userType = userType;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_apply_leave, container, false);
        ButterKnife.bind(this, view);
        setTitle();
        return view;
    }

    @OnClick(R.id.btn_submitEmail)
    public void OnSubmit(View view){
        sendMAil();
    }


    private void sendMAil(){
        String subject = userType+userPass+userPhone;
        tvSubject.setText(subject);
        String body = etBody.getText().toString().trim();
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        emailIntent.setType("plain/text");
        if (userType == 1) {
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"manager@gmail.com"});
        }else {
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"admin@gmail.com"});
        }
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, body );
        if (emailIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            getActivity().startActivity(emailIntent);
        }
        else {
            Toast.makeText(getActivity(), "You don't have any email apps to contact us.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setTitle(){
        mActivity = (DashboardActivity) getActivity();
        if (mActivity != null){
            mActivity.setToolbarTitle("Apply for Leave");
        }
    }

}
