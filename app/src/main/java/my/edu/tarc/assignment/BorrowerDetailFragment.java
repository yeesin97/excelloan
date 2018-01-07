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
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by User on 25/12/2017.
 */

public class BorrowerDetailFragment extends Fragment{
    EditText editTextCustName, editTextCustIC, editTextCustAge, editTextCustEmail, editTextCustAddr, editTextCustPhoneNum;
    RadioButton radioButtonCustMale, radioButtonCustFemale;
    public BorrowerDetailFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_borrower_detail, container, false);
        editTextCustName = (EditText)view.findViewById(R.id.editTextName);
        editTextCustIC = (EditText)view.findViewById(R.id.editTextBorrowerIC);
        editTextCustAge = (EditText)view.findViewById(R.id.editTextBAge);
        editTextCustAddr = (EditText)view.findViewById(R.id.editTextBAddress);
        editTextCustEmail = (EditText)view.findViewById(R.id.editTextBEmail);
        editTextCustPhoneNum = (EditText)view.findViewById(R.id.editTextBPhoneNum);
        radioButtonCustFemale = (RadioButton)view.findViewById(R.id.radioButtonBFemale);
        radioButtonCustMale = (RadioButton)view.findViewById(R.id.radioButtonBMale);
        Button btnNext = (Button) view.findViewById(R.id.buttonNext);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                String name = editTextCustName.getText().toString();
                String IC = editTextCustIC.getText().toString();
                int age = Integer.parseInt(editTextCustAge.getText().toString());
                String address = editTextCustAddr.getText().toString();
                String phoneNum = editTextCustPhoneNum.getText().toString();
                char gender = 'F';



                SpouseFragment sf = new SpouseFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();

//                b.putString("c_name", name);
//                b.putString("c_ic", IC);
//                b.putInt("c_age", age);
//                b.putString("c_address", address);
//                b.putString("c_phoneNum", phoneNum);
//                b.putChar("c_gender", gender);

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