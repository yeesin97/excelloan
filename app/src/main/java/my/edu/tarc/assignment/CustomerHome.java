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
 * Created by User on 01/01/2018.
 */

public class CustomerHome extends Fragment {
    public CustomerHome(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cust_home, container, false);

        ImageButton imgBtnLoan = (ImageButton)view.findViewById(R.id.imageButtonApplication);
        ImageButton imgBtnCProfile = (ImageButton)view.findViewById(R.id.imageButtonCProfile);
        ImageButton imgBtnPayment = (ImageButton)view.findViewById(R.id.imageButtonPayment);
        ImageButton imgBtnViewLoan = (ImageButton)view.findViewById(R.id.imageButtonLoan);
        ImageButton imgBtnCalculate = (ImageButton)view.findViewById(R.id.imageButtonCalculator);
        ImageButton imgBtnCalendar = (ImageButton)view.findViewById(R.id.imageButtonCalendar);

        imgBtnLoan.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                    BorrowerDetailFragment bdf = new BorrowerDetailFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frame_container, bdf);
                    ft.addToBackStack(null);
                    ft.commit();
                }
        });

        imgBtnCProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFragment pf = new ProfileFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_container, pf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        imgBtnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PaymentFragment payf = new PaymentFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_container, payf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        imgBtnViewLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgBtnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculatorFragment calcf = new CalculatorFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_container, calcf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        imgBtnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarFragment calenf = new CalendarFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_container, calenf);
                ft.commit();
            }
        });


        getActivity().setTitle("Home");

        return view;
    }


}
