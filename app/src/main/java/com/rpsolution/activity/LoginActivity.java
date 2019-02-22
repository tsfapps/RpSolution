package com.rpsolution.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.rpsolution.R;
import com.rpsolution.utils.ConstantVal;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_phone_login)
    protected EditText etPhoneLogin;
    @BindView(R.id.et_password_login)
    protected EditText etPasswordLogin;
    @BindView(R.id.sp_login)
    protected Spinner mSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    private void loginUser(){

        String userPhone = etPhoneLogin.getText().toString().trim();
        String userPass = etPasswordLogin.getText().toString().trim();
        int userType = mSpinner.getSelectedItemPosition();
        if (userType > 0){
            switch (userType){
                case 1 :
                    if (userPhone.equals("")){
                        Toast.makeText(LoginActivity.this,"Write the phone number", Toast.LENGTH_SHORT).show();
                    }

                   else if (userPass.equals("")){
                        Toast.makeText(LoginActivity.this,"Write the password", Toast.LENGTH_SHORT).show();
                    }
                   else if (!userPhone.equals("12345") || !userPass.equals("employee")){
                        toastError();
                    }
                    else {
                        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                        intent.putExtra(ConstantVal.PHONE, userPhone);
                        intent.putExtra(ConstantVal.PASS, userPass);
                        intent.putExtra(ConstantVal.USER, userType);
                        startActivity(intent);
                    }
                    break;
                case 2 :
                    if (userPhone.equals("")){
                        Toast.makeText(LoginActivity.this,"Write the phone number", Toast.LENGTH_SHORT).show();
                    }

                    else if (userPass.equals("")){
                        Toast.makeText(LoginActivity.this,"Write the password", Toast.LENGTH_SHORT).show();
                    }
                   else if (!userPhone.equals("54321") || !userPass.equals("manager")){
                            toastError();
                    }
                    else {
                        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                        intent.putExtra(ConstantVal.PHONE, userPhone);
                        intent.putExtra(ConstantVal.PASS, userPass);
                        intent.putExtra(ConstantVal.USER, userType);
                        startActivity(intent);
                    }
                    break;
                case 3 :
                    if (userPhone.equals("")){
                        Toast.makeText(LoginActivity.this,"Write the phone number", Toast.LENGTH_SHORT).show();
                    }

                    else if (userPass.equals("")){
                        Toast.makeText(LoginActivity.this,"Write the password", Toast.LENGTH_SHORT).show();
                    }
                   else if (!userPhone.equals("09876") || !userPass.equals("admin")){
                        toastError();
                    }
                    else {
                        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                        intent.putExtra(ConstantVal.PHONE, userPhone);
                        intent.putExtra(ConstantVal.PASS, userPass);
                        intent.putExtra(ConstantVal.USER, userType);
                        startActivity(intent);
                    }
                    break;
            }
        }
        else {
            Toast.makeText(LoginActivity.this, "Select the user type please", Toast.LENGTH_LONG).show();
        }

    }

    private void toastError(){
        Toast.makeText(LoginActivity.this, "Phone number or password is wrong", Toast.LENGTH_LONG).show();

    }
    @OnClick(R.id.btn_login)
    public void loginClk(View view){
       loginUser();
    }
}
