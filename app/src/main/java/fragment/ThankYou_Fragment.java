package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.dell.checklist_app.R;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThankYou_Fragment extends Fragment {
    @BindView(R.id.back)
    ImageView back;
        @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    View v= inflater.inflate(R.layout.fragment_thankyou,container, false);
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


}
