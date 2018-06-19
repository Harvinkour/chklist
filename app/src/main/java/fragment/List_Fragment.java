package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dell.checklist_app.R;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class List_Fragment extends Fragment {
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.linear1)
    LinearLayout linear1;
    @BindView(R.id.linear2)
    LinearLayout linear2;
   @BindView(R.id.linear3)
    LinearLayout linear3;
    @BindView(R.id.linear4)
    LinearLayout linear4;
    @BindView(R.id.linear5)
    LinearLayout linear5;
    @BindView(R.id.linear6)
    LinearLayout linear6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View v= inflater.inflate(R.layout.fragment_list,container, false);
        ButterKnife.bind(this,v);
        return v;
    }

    @OnClick(R.id.back)
    public void BackPressed(View view){
        backClick(view);
    }

    private void backClick(View view){
        Dashboard fragment3 = new Dashboard();
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
        Pending_Checklist_Fragment fragment3 = new Pending_Checklist_Fragment();
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
        Pending_Checklist_Fragment fragment3 = new Pending_Checklist_Fragment();
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
        Pending_Checklist_Fragment fragment3 = new Pending_Checklist_Fragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment3);
        fragmentTransaction.addToBackStack(null);
        getFragmentManager().popBackStack();
        fragmentTransaction.commit();
    }
    @OnClick(R.id.linear4)
    public void OnClickRoom4(View view){
        RoomClicked4(view);
    }

    private void RoomClicked4(View view){
        Pending_Checklist_Fragment fragment3 = new Pending_Checklist_Fragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment3);
        fragmentTransaction.addToBackStack(null);
        getFragmentManager().popBackStack();
        fragmentTransaction.commit();
    }
    @OnClick(R.id.linear5)
    public void OnClickRoom5(View view){
        RoomClicked5(view);
    }

    private void RoomClicked5(View view){
        Pending_Checklist_Fragment fragment3 = new Pending_Checklist_Fragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment3);
        fragmentTransaction.addToBackStack(null);
        getFragmentManager().popBackStack();
        fragmentTransaction.commit();
    }
    @OnClick(R.id.linear6)
    public void OnClickRoom6(View view){
        RoomClicked6(view);
    }

    private void RoomClicked6(View view){
        Pending_Checklist_Fragment fragment3 = new Pending_Checklist_Fragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment3);
        fragmentTransaction.addToBackStack(null);
        getFragmentManager().popBackStack();
        fragmentTransaction.commit();
    }


}
