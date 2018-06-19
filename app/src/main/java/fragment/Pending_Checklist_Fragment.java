package fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dell.checklist_app.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Pending_Checklist_Fragment extends Fragment implements AdapterView.OnItemSelectedListener {
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.linear)
    LinearLayout linear;
    @BindView(R.id.linear1)
    LinearLayout linear1;
    @BindView(R.id.linear2)
    LinearLayout linear2;
    @BindView(R.id.linear3)
    LinearLayout linear3;
    @BindView(R.id.submit)
    AppCompatButton submit;
    ProgressDialog pd;
    @BindView(R.id.sp_room)
    Spinner sp_room;
    Button  submit_btn;
    TextView txt_msg;
    String[] ROOM = { "Select Room Number","101", "102" ,"103","104","105","106"};
    ArrayAdapter roomlist;
    Context context;
    Dialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View v= inflater.inflate(R.layout.fragment_pending_list,container, false);
        ButterKnife.bind(this,v);
        roomlist = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,ROOM);
        roomlist.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_room.setAdapter(roomlist);
        sp_room.setOnItemSelectedListener(this);
        return v;
    }

    @OnClick(R.id.back)
    public void BackPressed(View view){
        backClick(view);
    }

    private void backClick(View view){
        List_Fragment fragment3 = new List_Fragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment3);
        fragmentTransaction.addToBackStack(null);
        getFragmentManager().popBackStack();
        fragmentTransaction.commit();
    }


    @OnClick(R.id.linear)
    public void OnViewRoom(View view){
        ViewClicked(view);
    }

    private void ViewClicked(View view){
        Pending_Checklist_Edit fragment3 = new Pending_Checklist_Edit();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment3);
        fragmentTransaction.addToBackStack(null);
        getFragmentManager().popBackStack();
        fragmentTransaction.commit();
    }

    @OnClick(R.id.linear1)
    public void OnViewRoom1(View view){
        ViewClicked1(view);
    }

    private void ViewClicked1(View view){
        Pending_Checklist_Added fragment3 = new Pending_Checklist_Added();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment3);
        fragmentTransaction.addToBackStack(null);
        getFragmentManager().popBackStack();
        fragmentTransaction.commit();
    }



    @OnClick(R.id.linear2)
    public void OnViewRoom2(View view){
        ViewClicked2(view);
    }

    private void ViewClicked2(View view){
        Pending_Checklist_Added fragment3 = new Pending_Checklist_Added();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment3);
        fragmentTransaction.addToBackStack(null);
        getFragmentManager().popBackStack();
        fragmentTransaction.commit();
    }



    @OnClick(R.id.linear3)
    public void OnViewRoom3(View view){
        ViewClicked3(view);
    }

    private void ViewClicked3(View view){
        Pending_Checklist_Added fragment3 = new Pending_Checklist_Added();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment3);
        fragmentTransaction.addToBackStack(null);
        getFragmentManager().popBackStack();
        fragmentTransaction.commit();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            ((TextView) parent.getChildAt(0)).setTextColor(this.getResources().getColor(R.color.grey));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @OnClick(R.id.submit)
    public void submit(View view){
        ViewSubmit(view);
    }

    private void ViewSubmit(View view){

         dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.update_dailog);
        submit_btn = (Button) dialog.findViewById(R.id.submit_btn);
        txt_msg = (TextView)dialog.findViewById(R.id.txt_msg);
        txt_msg.setText("Your Checklist has been submitted\n" +
                "     successfully");


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List_Fragment fragment3 = new List_Fragment();
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
