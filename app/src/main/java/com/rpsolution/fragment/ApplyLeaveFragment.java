package com.rpsolution.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rpsolution.R;
import com.rpsolution.activity.DashboardActivity;
import com.rpsolution.utils.ConstantVal;
import com.rpsolution.utils.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ApplyLeaveFragment extends Fragment {

    private DashboardActivity mActivity;

    @BindView(R.id.tv_subject)
    protected TextView tvSubject;
    @BindView(R.id.rg_applyLeave)
    protected RadioGroup rgApplyLeave;
    @BindView(R.id.rb_casual)
    protected RadioButton rbCasual;
    @BindView(R.id.rb_sick)
    protected RadioButton rbSick;
    @BindView(R.id.tv_date_to)
    protected TextView tvDateTo;
    @BindView(R.id.tv_date_from)
    protected TextView tvDateFrom;
    @BindView(R.id.et_messageLeaveApply)
    protected EditText etMessageLeaveApply;

    private RadioButton rbLeaveButton;
    final Calendar myCalendar = Calendar.getInstance();

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

    String subject;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_apply_leave, container, false);
        ButterKnife.bind(this, view);
        subject = "Leave requested by "+userType+userPass+userPhone;
        tvSubject.setText(subject);
        setTitle();
        return view;
    }
    @OnClick(R.id.ll_date_from)
    public void llDateDepartClick(View view){
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                SimpleDateFormat sdf = new SimpleDateFormat(ConstantVal.INPUT_DATE_FORMAT, Locale.UK);
                tvDateFrom.setText(sdf.format(myCalendar.getTime()));
            }

        };
        new DatePickerDialog(getContext(), date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();

    }
    private void updateLabel() {
        String myFormat = ConstantVal.INPUT_DATE_FORMAT; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);
        tvDateTo.setText(sdf.format(myCalendar.getTime()));
        // edittext.setText(sdf.format(myCalendar.getTime()));
    }
    @OnClick(R.id.tv_date_to)
    public void tvReturn(View view){

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
        new DatePickerDialog(getContext(), date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }
    @OnClick(R.id.btn_submitEmail)
    public void OnSubmit(View view){
        sendMAil();
    }


    private void sendMAil(){
        int selectedId = rgApplyLeave.getCheckedRadioButtonId();
        rbLeaveButton =  Objects.requireNonNull(getActivity()).findViewById(selectedId);
        String messageStr = etMessageLeaveApply.getText().toString().trim();


        if(selectedId==-1){
            Toast.makeText(getContext(),"No leave selected", Toast.LENGTH_SHORT).show();
        }


        else{
            String dateFrom = tvDateFrom.getText().toString().trim();
            String dateTo = tvDateTo.getText().toString().trim();
            String dateDiff = DateUtils.timeDiff(dateFrom, dateTo);
            String content = "Emp Id : "+userType+userPass+userPhone+"\nReason : "
                    +rbLeaveButton.getText().toString().trim()+"\nFrom : "+dateFrom+
                    " \nTo : "+dateTo+"\nTotal Leave : "+dateDiff + "\nMessage : \n\t\t"+messageStr;
            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            emailIntent.setType("plain/text");
            if (userType == 1) {
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"manager@gmail.com"});
            }else if(userType == 2) {
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"admin@gmail.com"});
            }else {
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"superadmin@gmail.com"});
            }
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, content);
            getActivity().startActivity(emailIntent);
        }
    }




    private void setTitle(){
        mActivity = (DashboardActivity) getActivity();
        if (mActivity != null){
            mActivity.setToolbarTitle("Apply for Leave");
        }
    }

}
