package my.edu.tarc.assignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by User on 02/01/2018.
 */

public class AdminHome extends Fragment {
    public AdminHome(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_home, container, false);

        ImageButton imgBtnProfile = (ImageButton)view.findViewById(R.id.imageButtonAProfile);
        ImageButton imgBtnCustProfile = (ImageButton)view.findViewById(R.id.imageButtonACustProfile);
        ImageButton imgBtnReport = (ImageButton)view.findViewById(R.id.imageButtonAReport);
        ImageButton imgBtnLoan = (ImageButton)view.findViewById(R.id.imageButtonALoan);

        imgBtnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminProfileFragment apf = new AdminProfileFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_container, apf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        imgBtnCustProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFragment pf = new ProfileFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_container, pf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        imgBtnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgBtnLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        getActivity().setTitle("Home");
        return view;
    }
}
