package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import com.example.dell.checklist_app.R;
import com.example.dell.checklist_app.activity.ForgotPasswordActivity;
import com.example.dell.checklist_app.activity.Login_Activity;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
//005756
public class Dashboard extends Fragment {
    @BindView(R.id.pending)
    AppCompatTextView pending;
    @BindView(R.id.missed)
    AppCompatTextView missed;
    @BindView(R.id.linear1)
    LinearLayout linear1;
    @BindView(R.id.linear2)
    LinearLayout linear2;
    @BindView(R.id.linear3)
    LinearLayout linear3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View v= inflater.inflate(R.layout.fragment_dashboard,container, false);
        ButterKnife.bind(this,v);

        return v;
    }
    @OnClick(R.id.pending)
    public void OnPendingClick(View view){
        Pending(view);
    }

    private void Pending(View view){
        List_Fragment fragment2 = new List_Fragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment2);
        fragmentTransaction.commit();
    }
    @OnClick(R.id.missed)
    public void OnMissedClick(View view){
        Missed(view);
    }

    private void Missed(View view){
        List_Fragment fragment3 = new List_Fragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment3);
        fragmentTransaction.addToBackStack(null);
        getFragmentManager().popBackStack();
        fragmentTransaction.commit();
    }

    @OnClick(R.id.linear1)
    public void OnClickRoom1(View view){
        RoomClicked1(view);
    }

    private void RoomClicked1(View view){
        List_Fragment fragment3 = new List_Fragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment3);
        fragmentTransaction.addToBackStack(null);
        getFragmentManager().popBackStack();
        fragmentTransaction.commit();
    }
    @OnClick(R.id.linear2)
    public void OnClickRoom2(View view){
        RoomClicked2(view);
    }

    private void RoomClicked2(View view){
        List_Fragment fragment3 = new List_Fragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment3);
        fragmentTransaction.addToBackStack(null);
        getFragmentManager().popBackStack();
        fragmentTransaction.commit();
    }
    @OnClick(R.id.linear3)
    public void OnClickRoom3(View view){
        RoomClicked3(view);
    }

    private void RoomClicked3(View view){
        List_Fragment fragment3 = new List_Fragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment3);
        fragmentTransaction.addToBackStack(null);
        getFragmentManager().popBackStack();
        fragmentTransaction.commit();
    }

}
