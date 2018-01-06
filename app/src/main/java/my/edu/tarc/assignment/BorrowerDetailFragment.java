package my.edu.tarc.assignment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by User on 25/12/2017.
 */

public class BorrowerDetailFragment extends Fragment{
    EditText custName, custIC;
    public BorrowerDetailFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_borrower_detail, container, false);
        custName = (EditText)view.findViewById(R.id.editTextName);
        custIC = (EditText)view.findViewById(R.id.editTextBorrowerIC);
        Button btnNext = (Button) view.findViewById(R.id.buttonNext);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                String name = custName.getText().toString();
                String IC = custIC.getText().toString();

                SpouseFragment sf = new SpouseFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                b.putString("name", name);
                b.putString("ic", IC);

                sf.setArguments(b);

                ft.replace(R.id.frame_container, sf);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        getActivity().setTitle("Borrower Detail");

        return view;
    }

}