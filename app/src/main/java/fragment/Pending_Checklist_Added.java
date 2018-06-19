package fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.checklist_app.R;
import com.example.dell.checklist_app.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Pending_Checklist_Added extends Fragment  {
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.save_btn)
    AppCompatButton save_btn;
    @BindView(R.id.yes1)
    AppCompatTextView yes1;
    @BindView(R.id.yes2)
    AppCompatTextView yes2;
    @BindView(R.id.yes3)
    AppCompatTextView yes3;
    @BindView(R.id.no1)
    AppCompatTextView no1;
    @BindView(R.id.no2)
    AppCompatTextView no2;
    @BindView(R.id.no3)
    AppCompatTextView no3;
    Boolean check= false;
    ProgressDialog pd;
    Dialog dialog;
    Button submit_btn;
    TextView txt_msg;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View v= inflater.inflate(R.layout.fragment_pending_list_add,container, false);
        ButterKnife.bind(this,v);

        return v;

    }

    @OnClick(R.id.yes1)
    public  void Clickyes1(View view){
        ClickYesColor1(view);
    }
    private void ClickYesColor1(View view){
        yes1.setBackgroundColor((getResources().getColor(R.color.green)));
        yes1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.white_check, 0, 0, 0);
        yes1.setTextColor(this.getResources().getColor(R.color.white));
        no1.setBackgroundColor(getResources().getColor(R.color.light_gray));
        no1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.close, 0, 0, 0);

    }
    @OnClick(R.id.no1)
    public  void ClickNO1(View view){
        ClickNOColor1(view);
    }
    private void ClickNOColor1(View view){

        no1.setBackgroundColor(Color.RED);
        no1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.white_cross, 0, 0, 0);
        no1.setTextColor(this.getResources().getColor(R.color.white));
        yes1.setBackgroundColor(getResources().getColor(R.color.light_gray));
        yes1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.check, 0, 0, 0);
    }

    @OnClick(R.id.yes2)
    public  void Clickyes2(View view){
        ClickYesColor2(view);
    }
    private void ClickYesColor2(View view){
        yes2.setBackgroundColor((getResources().getColor(R.color.green)));
        yes2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.white_check, 0, 0, 0);
        yes2.setTextColor(this.getResources().getColor(R.color.white));
        no2.setBackgroundColor(getResources().getColor(R.color.light_gray));
        no2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.close, 0, 0, 0);

    }
    @OnClick(R.id.no2)
    public  void ClickNO2(View view){
        ClickNOColor2(view);
    }
    private void ClickNOColor2(View view){

        no2.setBackgroundColor(Color.RED);
        no2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.white_cross, 0, 0, 0);
        no2.setTextColor(this.getResources().getColor(R.color.white));
        yes2.setBackgroundColor(getResources().getColor(R.color.light_gray));
        yes2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.check, 0, 0, 0);
    }
    @OnClick(R.id.yes3)
    public  void Clickyes3(View view){
        ClickYesColor3(view);
    }
    private void ClickYesColor3(View view){
        yes3.setBackgroundColor((getResources().getColor(R.color.green)));
        yes3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.white_check, 0, 0, 0);
        yes3.setTextColor(this.getResources().getColor(R.color.white));
        no3.setBackgroundColor(getResources().getColor(R.color.light_gray));
        no3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.close, 0, 0, 0);

    }
    @OnClick(R.id.no3)
    public  void ClickNO3(View view){
        ClickNOColor3(view);
    }
    private void ClickNOColor3(View view){


        no3.setBackgroundColor(Color.RED);
        no3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.white_cross, 0, 0, 0);
        no3.setTextColor(this.getResources().getColor(R.color.white));
        yes3.setBackgroundColor(getResources().getColor(R.color.light_gray));
        yes3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.check, 0, 0, 0);
    }


    @OnClick(R.id.back)
    public void BackPressed(View view){
        backClick(view);
    }

    private void backClick(View view){
        Pending_Checklist_Fragment fragment3 = new Pending_Checklist_Fragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment3);
        fragmentTransaction.addToBackStack(null);
        getFragmentManager().popBackStack();
        fragmentTransaction.commit();
    }

    @OnClick(R.id.save_btn)
    public void ClickSave(View view){
        Save(view);
    }

    private void Save(View view){

        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.update_dailog);
        submit_btn = (Button) dialog.findViewById(R.id.submit_btn);
        txt_msg = (TextView)dialog.findViewById(R.id.txt_msg);
        txt_msg.setText("Your Checklist has been saved\n" +
                "     successfully");

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pending_Checklist_Fragment fragment3 = new Pending_Checklist_Fragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_frame, fragment3);
                fragmentTransaction.addToBackStack(null);
                getFragmentManager().popBackStack();
                fragmentTransaction.commit();
                dialog.dismiss();
            }
        });

    }

}
