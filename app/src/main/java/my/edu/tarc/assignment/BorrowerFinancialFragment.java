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
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by User on 25/12/2017.
 */

public class BorrowerFinancialFragment extends Fragment {

    TextView textViewTotalIncome, textViewTotalExpenses;
    EditText editTextIncome, editTextBonus, editTextRentalE, editTextHouseholdE, editTextOtherE;
    View view;
    public BorrowerFinancialFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_borrower_financial, container, false);

        textViewTotalIncome = (TextView)view.findViewById(R.id.textViewTotalIncome);
        textViewTotalExpenses = (TextView)view.findViewById(R.id.textViewTotalExpenses);

        editTextIncome = (EditText)view.findViewById(R.id.editTextIncome);
        editTextBonus = (EditText)view.findViewById(R.id.editTextBonus);
        editTextRentalE = (EditText)view.findViewById(R.id.editTextRental);
        editTextHouseholdE = (EditText)view.findViewById(R.id.editTextHouseholdExpenses);
        editTextOtherE = (EditText)view.findViewById(R.id.editTextOtherExpenses);
        //totalIncome = Double.parseDouble(editTextIncome.getText().toString()) + Double.parseDouble(editTextBonus.getText().toString());
        //totalExpense = Double.parseDouble(editTextHouseholdE.getText().toString()) + Double.parseDouble(editTextRentalE.getText().toString()) + Double.parseDouble(editTextOtherE.getText().toString());


        Button btnNext = (Button)view.findViewById(R.id.buttonBFNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double totalIncome = 0.0;
                double totalExpense =  0.0;
                double income, bonus, householdexp, rentalexp, otherexp;

                if(TextUtils.isEmpty(editTextIncome.getText().toString())){
                    editTextIncome.setError("The fields cannot be blank");
                    return;
                }
                else if(TextUtils.isEmpty(editTextRentalE.getText().toString())){
                    editTextRentalE.setError("The fields cannot be blank");
                    return;
                }
                else if(TextUtils.isEmpty(editTextHouseholdE.getText().toString())){
                    editTextHouseholdE.setError("The fields cannot be blank");
                    return;
                }
                else if(TextUtils.isEmpty(editTextBonus.getText().toString()) && TextUtils.isEmpty(editTextOtherE.getText().toString())){
                    income = Double.parseDouble(editTextIncome.getText().toString());

                    householdexp = Double.parseDouble(editTextHouseholdE.getText().toString());
                    rentalexp = Double.parseDouble(editTextRentalE.getText().toString());

                    totalIncome =  income;
                    totalExpense =  householdexp +  rentalexp;

                    textViewTotalIncome.setText(String.valueOf(totalIncome));
                    textViewTotalExpenses.setText(String.valueOf(totalExpense));
                }
                else if(TextUtils.isEmpty(editTextOtherE.getText().toString())){

                    income = Double.parseDouble(editTextIncome.getText().toString());
                    bonus = Double.parseDouble(editTextBonus.getText().toString());
                    householdexp = Double.parseDouble(editTextHouseholdE.getText().toString());
                    rentalexp = Double.parseDouble(editTextRentalE.getText().toString());

                    totalIncome =  income + bonus;
                    totalExpense =  householdexp +  rentalexp;

                    textViewTotalIncome.setText(String.valueOf(totalIncome));
                    textViewTotalExpenses.setText(String.valueOf(totalExpense));
                }
                else if(TextUtils.isEmpty(editTextBonus.getText().toString())){
                    income = Double.parseDouble(editTextIncome.getText().toString());

                    householdexp = Double.parseDouble(editTextHouseholdE.getText().toString());
                    rentalexp = Double.parseDouble(editTextRentalE.getText().toString());
                    otherexp = Double.parseDouble(editTextOtherE.getText().toString());

                    totalIncome =  income;
                    totalExpense =  householdexp +  rentalexp + otherexp;

                    textViewTotalIncome.setText(String.valueOf(totalIncome));
                    textViewTotalExpenses.setText(String.valueOf(totalExpense));
                }
                else {
                    income = Double.parseDouble(editTextIncome.getText().toString());
                    bonus = Double.parseDouble(editTextBonus.getText().toString());
                    householdexp = Double.parseDouble(editTextHouseholdE.getText().toString());
                    rentalexp = Double.parseDouble(editTextRentalE.getText().toString());
                    otherexp = Double.parseDouble(editTextOtherE.getText().toString());

                    totalIncome = income + bonus;
                    totalExpense = householdexp + rentalexp + otherexp;

                    textViewTotalIncome.setText(String.valueOf(totalIncome));
                    textViewTotalExpenses.setText(String.valueOf(totalExpense));
                }

                Bundle b = getArguments();

//                String custName = b.getString("c_name");
//                String custIc = b.getString("c_ic");
//                int custAge = b.getInt("c_age");
//                String custAddr = b.getString("c_addr");
//                String custPhoneNum = b.getString("c_phoneNum");
//                String custEmail = b.getString("c_email");
//                char custGender = b.getChar("c_gender");

                String spouseName = b.getString("s_name");
                String spouseIc = b.getString("s_ic");
                int spouseAge = b.getInt("s_age");
                String spouseAddr = b.getString("s_addr");
                String spousePhoneNum = b.getString("s_phoneNum");
                String spouseEmail = b.getString("s_email");
                double spouseNetIncome = b.getDouble("s_netincome");
                char spouseRelationship = b.getChar("s_relationship");
                char spouseGender = b.getChar("s_gender");


                //put into bundle

//                b.putString("c_name", custName);
//                b.putString("c_ic", custIc);
//                b.putInt("c_age", custAge);
//                b.putString("c_addr", custAddr);
//                b.putString("c_phoneNum", custPhoneNum);
//                b.putString("c_email", custEmail);
//                b.putChar("c_gender", custGender);

                b.putString("s_name", spouseName);
                b.putString("s_ic", spouseIc);
                b.putInt("s_age", spouseAge);
                b.putString("s_addr", spouseAddr);
                b.putString("s_phoneNum", spousePhoneNum);
                b.putString("s_email", spouseEmail);
                b.putDouble("s_netincome", spouseNetIncome);
                b.putChar("s_relationship", spouseRelationship);
                b.putChar("s_gender", spouseGender);

                    b.putDouble("income", totalIncome);
                    b.putDouble("expense", totalExpense);

                LoanApplicationFragment laf = new LoanApplicationFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_container, laf);
                laf.setArguments(b);
                ft.addToBackStack(null);
                ft.commit();

            }
        });

        getActivity().setTitle("Borrower Financial");

        return view;
    }
}
