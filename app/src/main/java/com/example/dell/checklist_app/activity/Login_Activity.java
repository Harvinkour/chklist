package com.example.dell.checklist_app.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.checklist_app.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fragment.Dashboard;

public class Login_Activity extends AppCompatActivity{
    @BindView(R.id.root_view)
    LinearLayout root_view;
    @BindView(R.id.et_user_name)
    AppCompatEditText et_user_name;
    @BindView(R.id.et_password)
    AppCompatEditText et_password;
    @BindView(R.id.login_btn)
    AppCompatButton login_btn;
    @BindView(R.id.forget)
    AppCompatTextView forget;
    @BindView(R.id.loginicon)
    ImageView loginicon;
    View focusView = null;
    ProgressDialog pd;
    String email_id="";
     String pass="";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       // root_view.setBackgroundResource(R.drawable.bg_img);
        setActionBar();
        ButterKnife.bind(this);
        loginicon.setImageResource(R.drawable.logo1);
        hideKeyBoardEdt(et_password);
        et_password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();

                    return true;
                }
                return false;
            }
        });
    }
    public void  hideKeyBoardEdt(EditText editText) {
        InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
    @OnClick(R.id.login_btn)
    public void LoginClick(View view){
        Login(view);
    }

    private void Login(View view){
       attemptLogin();
    }

    private void setActionBar() {
        //  getSupportActionBar().hide();
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));
        }
    }
    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }


    @OnClick(R.id.login_btn)
    public void onButtonClick() {
        loginValidation();
    }
    private boolean loginValidation(){

             email_id = et_user_name.getText().toString();
            pass = et_password.getText().toString();
            boolean cancel = false;

            if(TextUtils.isEmpty(email_id) && TextUtils.isEmpty(pass)){
                Toast.makeText(Login_Activity.this, getString(R.string.enter_email_password), Toast.LENGTH_SHORT).show();
                focusView = et_user_name;
                cancel = true;
            }else if(!isEmailValid(email_id) && TextUtils.isEmpty(email_id)){
                Toast.makeText(Login_Activity.this, getString(R.string.enter_email_password), Toast.LENGTH_SHORT).show();
                et_user_name.setError("Invalid Email");
                focusView = et_user_name;
                cancel = true;
            }else  if (!isValidEmail(email_id) ) {
                Toast.makeText(Login_Activity.this, getString(R.string.error_invalid_email), Toast.LENGTH_SHORT).show();
                et_user_name.setError("Invalid Email");
                focusView = et_user_name;
                cancel = true;
            }
            else if (TextUtils.isEmpty(pass)) {
                Toast.makeText(Login_Activity.this, getString(R.string.password_required), Toast.LENGTH_SHORT).show();
                et_password.setError("Invalid Password");
                focusView = et_password;
                cancel = true;
            }

            else if (!isPasswordValid(pass)) {
                Toast.makeText(Login_Activity.this, getString(R.string.error_invalid_password), Toast.LENGTH_SHORT).show();
                et_password.setError("Invalid Password");
                focusView = et_password;
                cancel = true;
            }

            return cancel;

    }

    @OnClick(R.id.forget)
    public void onForgetClick(View view){
        Forget(view);
    }

    private void Forget(View view){
        Intent i = new Intent(Login_Activity.this,ForgotPasswordActivity.class);
        startActivity(i);
        finish();
    }
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void attemptLogin(){

        boolean mCancel = this.loginValidation();
        if (mCancel) {
            focusView.requestFocus();
        } else {
           /* pd = new ProgressDialog(this);
            pd.setMessage("Please wait...");
            pd.setCancelable(false);
            pd.show();*/
            loginProcess(email_id, pass);

        }
    }


    private void loginProcess(final String email_id, String pass){
        Intent i = new Intent(Login_Activity.this, MainActivity.class);
        startActivity(i);
        finish();
       // pd.dismiss();
    }

}
