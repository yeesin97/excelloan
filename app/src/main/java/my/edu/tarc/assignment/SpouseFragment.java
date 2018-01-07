package my.edu.tarc.assignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * Created by User on 25/12/2017.
 */

public class SpouseFragment extends Fragment {
    public SpouseFragment(){

    }

    EditText editTextspouseName, editTextspouseIC, editTextAge, editTextAddress, editTextPhoneNum, editTextEmailAddr, editTextNetIncome;
    RadioButton radioButtonMale, radioButtonFemale, radioButtonSpouse, radioButtonGuarantor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spouse, container, false);

        Button btnNext = (Button)view.findViewById(R.id.buttonSNext);
        editTextspouseName = (EditText)view.findViewById(R.id.editTextSName);
        editTextspouseIC = (EditText)view.findViewById(R.id.editTextSIC);
        editTextAge = (EditText)view.findViewById(R.id.editTextSAge);
        editTextAddress = (EditText)view.findViewById(R.id.editTextSAddress);
        editTextPhoneNum = (EditText)view.findViewById(R.id.editTextSPhoneNum);
        editTextEmailAddr = (EditText)view.findViewById(R.id.editTextSEmail);
        editTextNetIncome = (EditText)view.findViewById(R.id.editTextSNetIncome);

        radioButtonMale = (RadioButton)view.findViewById(R.id.radioButtonSMale);
        radioButtonFemale = (RadioButton)view.findViewById(R.id.radioButtonSFemale);
        radioButtonSpouse = (RadioButton)view.findViewById(R.id.radioButtonSSpouse);
        radioButtonGuarantor = (RadioButton)view.findViewById(R.id.radioButtonSGuarantor);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = editTextspouseName.getText().toString();
                String ic = editTextspouseIC.getText().toString();
                int age = Integer.parseInt(editTextAge.getText().toString());
                String addr = editTextAddress.getText().toString();
                String phoneNum = editTextPhoneNum.getText().toString();
                String email = editTextEmailAddr.getText().toString();
                double netIncome = Double.parseDouble(editTextNetIncome.getText().toString());
                char spouseGender;
                char spouseRelationship;


                if(radioButtonFemale.isChecked() == false && radioButtonMale.isChecked() == false){
                    Toast.makeText(getActivity(), "Please choose your gender.", Toast.LENGTH_LONG).show();
                    radioButtonMale.requestFocus();
                }
                else if (radioButtonSpouse.isChecked() == false && radioButtonGuarantor.isChecked() == false){
                    Toast.makeText(getActivity(), "Required field(s) is missing..", Toast.LENGTH_LONG).show();
                    radioButtonSpouse.requestFocus();
                }
                else if (TextUtils.isEmpty(name) || TextUtils.isEmpty(ic) || TextUtils.isEmpty(String.valueOf(age)) ||
                        TextUtils.isEmpty(addr) || TextUtils.isEmpty(phoneNum) || TextUtils.isEmpty(String.valueOf(netIncome))) {
                    Toast.makeText(getActivity(), "Required field(s) is missing..", Toast.LENGTH_LONG).show();
                }
                else {

                    if(radioButtonMale.isChecked()){
                        spouseGender = 'M';
                    }else {
                        spouseGender = 'F';
                    }

                    if(radioButtonSpouse.isChecked()){
                        spouseRelationship = 'S';
                    }else {
                        spouseRelationship = 'G';
                    }

                    Bundle b = getArguments();

//                    String custName = b.getString("c_name");
//                    String custIc = b.getString("c_ic");
//                    String custAge = b.getString("c_age");
//                    String custAddr = b.getString("c_addr");
//                    String custPhoneNum = b.getString("c_phoneNum");
//                    String custEmail = b.getString("c_email");

                    //put into bundle

//                    b.putString("c_name", custName);
//                    b.putString("c_ic", custIc);
//                    b.putString("c_age", custAge);
//                    b.putString("c_addr", custAddr);
//                    b.putString("c_phoneNum", custPhoneNum);
//                    b.putString("c_email", custEmail);

                    b.putString("s_name", name);
                    b.putString("s_ic", ic);
                    b.putInt("s_age", age);
                    b.putString("s_addr", addr);
                    b.putString("s_phoneNum", phoneNum);
                    b.putString("s_email", email);
                    b.putDouble("s_netincome", netIncome);
                    b.putChar("s_relationship", spouseRelationship);
                    b.putChar("s_gender", spouseGender);

//                    String spouseName = editTextspouseName.getText().toString();
//                    String spouseIC = editTextspouseIC.getText().toString();
//                    b.putString("s_name", spouseName);
//                    b.putString("s_ic", spouseIC);

                    BorrowerFinancialFragment bff = new BorrowerFinancialFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    bff.setArguments(b);
                    ft.replace(R.id.frame_container, bff);
                    ft.addToBackStack(null);
                    ft.commit();
                }

            }
        });

        getActivity().setTitle("Spouse or Co-guarantor Detail");

        return view;

    }

}
