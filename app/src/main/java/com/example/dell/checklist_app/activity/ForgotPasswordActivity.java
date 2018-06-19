package com.example.dell.checklist_app.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.checklist_app.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotPasswordActivity extends AppCompatActivity{
    @BindView(R.id.et_frg_email)
    AppCompatEditText et_frg_email;
    @BindView(R.id.submt_btn)
    AppCompatButton submt_btn;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.loginicon)
    ImageView loginicon;
    View focusView = null;
    ProgressDialog pd;
    String email_id="";
    String pass="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        setActionBar();
        ButterKnife.bind(this);
        loginicon.setImageResource(R.drawable.logo1);
        hideKeyBoardEdt(et_frg_email);
        et_frg_email.setOnEditorActionListener(new TextView.OnEditorActionListener() {
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
    private void setActionBar() {
        //  getSupportActionBar().hide();
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));
        }
    }
    public void  hideKeyBoardEdt(EditText editText) {
        InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    private void attemptLogin(){

        boolean mCancel = this.loginValidation();
        if (mCancel) {
            focusView.requestFocus();
        } else {
            pd = new ProgressDialog(this);
            pd.setMessage("Please wait...");
            pd.setCancelable(false);
            pd.show();
            loginProcess(email_id, pass);
        }
    }
    private void loginProcess(final String email_id, String pass){

        AlertDialog.Builder builder = new AlertDialog.Builder(ForgotPasswordActivity.this);
        builder.setMessage("Password Sent to your Registered email");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                pd = new ProgressDialog(ForgotPasswordActivity.this);
                pd.setMessage("Please wait...");
                pd.setCancelable(false);
                pd.show();
                Intent i = new Intent(ForgotPasswordActivity.this, Login_Activity.class);
                startActivity(i);
                finish();
            }
        });
       builder.create().show();

    }
    @OnClick(R.id.back)
    public void onBackClick(View view){
        Forget(view);
    }

    private void Forget(View view){
        Intent i = new Intent(ForgotPasswordActivity.this,Login_Activity.class);
        startActivity(i);
        finish();
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }
    @OnClick(R.id.submt_btn)
    public void onButtonClick() {
        loginValidation();
    }
    private boolean loginValidation(){

        email_id = et_frg_email.getText().toString();
        boolean cancel = false;

        if(TextUtils.isEmpty(email_id) ){
            Toast.makeText(ForgotPasswordActivity.this, getString(R.string.error_field_required), Toast.LENGTH_SHORT).show();
            focusView = et_frg_email;
            cancel = true;
        }else if(!isEmailValid(email_id) && TextUtils.isEmpty(email_id)){
            Toast.makeText(ForgotPasswordActivity.this, getString(R.string.error_field_required), Toast.LENGTH_SHORT).show();
            et_frg_email.setError("Invalid Email");
            focusView = et_frg_email;
            cancel = true;
        }else  if (!isValidEmail(email_id) ) {
            Toast.makeText(ForgotPasswordActivity.this, getString(R.string.error_invalid_email), Toast.LENGTH_SHORT).show();
            et_frg_email.setError("Invalid Email");
            focusView = et_frg_email;
            cancel = true;
        }
        return cancel;
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    @OnClick(R.id.submt_btn)
    public void LoginClick(View view){
        Login(view);
    }

    private void Login(View view){
        attemptLogin();
    }

}
