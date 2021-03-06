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

public class PacFragment extends Fragment {
    public PacFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pac, container, false);

        Button btnFContinue = (Button) view.findViewById(R.id.buttonFContinue);
        Button btnFCancel = (Button) view.findViewById(R.id.buttonFCancel);
        Button btnConfirm = (Button) view.findViewById(R.id.buttonConfirm);
        Button btnPacCancel = (Button) view.findViewById(R.id.buttonPACCancel);

        btnFContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnFCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginFragment loginf = new LoginFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.login_container, loginf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnPacCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        getActivity().setTitle("Verification");
        return view;
    }
}
