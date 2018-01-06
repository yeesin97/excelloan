package my.edu.tarc.assignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by User on 03/01/2018.
 */

public class LoginFragment extends Fragment {
    public LoginFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        Button btnForgotPw = (Button) view.findViewById(R.id.buttonForgotPassword);
        Button btnRegister = (Button) view.findViewById(R.id.buttonRegister);
        Button btnLogin = (Button) view.findViewById(R.id.buttonLogin);
        ImageButton imgBtnLCalculator = (ImageButton) view.findViewById(R.id.imageButtonLCalculator);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnForgotPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangePwFragment chpwf = new ChangePwFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.login_container, chpwf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrationFragment rf = new RegistrationFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.login_container, rf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        imgBtnLCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalculatorFragment calcf = new CalculatorFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.login_container, calcf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        getActivity().setTitle("Login");
        return view;
    }
}
