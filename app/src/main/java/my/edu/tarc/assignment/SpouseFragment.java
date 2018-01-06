package my.edu.tarc.assignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by User on 25/12/2017.
 */

public class SpouseFragment extends Fragment {
    public SpouseFragment(){

    }

    EditText editTextspouseName, editTextspouseIC;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spouse, container, false);

        Button btnNext = (Button)view.findViewById(R.id.buttonSNext);
        editTextspouseName = (EditText)view.findViewById(R.id.editTextSName);
        editTextspouseIC = (EditText)view.findViewById(R.id.editTextSIC);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle b = getArguments();

                String name= b.getString("name");
                String IC = b.getString("ic");
                b.putString("name", name);
                b.putString("ic", IC);

                String spouseName = editTextspouseIC.getText().toString();
                String spouseIC = editTextspouseIC.getText().toString();
                b.putString("s_name", spouseName);
                b.putString("s_ic", spouseIC);
                //Toast.makeText(getActivity(), name, Toast.LENGTH_LONG).show();

                BorrowerFinancialFragment bff = new BorrowerFinancialFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                bff.setArguments(b);
                ft.replace(R.id.frame_container, bff);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        getActivity().setTitle("Spouse or Co-guarantor Detail");

        return view;
    }
}
