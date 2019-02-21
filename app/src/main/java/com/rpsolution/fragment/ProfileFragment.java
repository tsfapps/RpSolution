package com.rpsolution.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rpsolution.R;
import com.rpsolution.activity.DashboardActivity;
import com.rpsolution.utils.ConstantVal;
import com.rpsolution.utils.CustomLog;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileFragment extends Fragment {

  // private UserModel userModel = new UserModel(0, "");
    private DashboardActivity mActivity;

    @BindView(R.id.tv_profile_phone)
    protected TextView tvProfilePhone;
    @BindView(R.id.tv_profile_user_type)
    protected TextView tvProfileUserType;
    @BindView(R.id.tv_profile_username)
    protected TextView tvProfileUser;
    @BindView(R.id.tv_pro_emp_id)
    protected TextView tvEmpId;

   private String userPhone;
   private String userPass;
   private int userType;

    public static ProfileFragment newInstance(String userPhone, String userPass, int userType) {
        ProfileFragment fragment = new ProfileFragment();
       fragment.userPhone = userPhone;
       fragment.userPass = userPass;
       fragment.userType = userType;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_profile, container, false);
        ButterKnife.bind(this, view);
        setTitle();
        setProfileDetail();
        CustomLog.d(ConstantVal.TAG, "USER_TYPE : "+userType);
        return view;
    }

    private void setProfileDetail(){
        tvProfilePhone.setText(userPhone);
        tvProfileUserType.setText(userPass);
        tvProfileUser.setText(userPass+"@123");
        tvEmpId.setText(userType+userPass+userPhone);

//            if(userType.equals("1")) {
//                tvProfileUserType.setText("Employee");
//                tvProfileUser.setText("employee@123");
//            }

    }

    private void setTitle(){
        mActivity = (DashboardActivity) getActivity();
        if (mActivity != null){
            mActivity.setToolbarTitle("Profile");
        }
    }

}
