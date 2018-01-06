package my.edu.tarc.assignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by User on 03/01/2018.
 */

public class ChangePwFragment extends Fragment {
    public ChangePwFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_pw, container, false);
        Button btnUpdatePw = (Button) view.findViewById(R.id.buttonUpdatePw);
        Button btnCancel = (Button) view.findViewById(R.id.buttonChCancel);

        btnUpdatePw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PacFragment pacf = new PacFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.login_container, pacf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginFragment loginf = new LoginFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.login_container, loginf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        getActivity().setTitle("New Password");
        return view;
    }
}