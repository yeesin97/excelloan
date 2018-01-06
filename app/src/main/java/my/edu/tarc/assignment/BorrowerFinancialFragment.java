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
import android.widget.TextView;

/**
 * Created by User on 25/12/2017.
 */

public class BorrowerFinancialFragment extends Fragment {

    TextView textViewTotalIncome, textViewTotalExpenses;
    EditText editTextIncome, editTextBonus, editTextRentalE, editTextHouseholdE, editTextOtherE;
    public BorrowerFinancialFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_borrower_financial, container, false);

        textViewTotalIncome = (TextView)view.findViewById(R.id.textViewTotalIncome);
        textViewTotalExpenses = (TextView)view.findViewById(R.id.textViewTotalExpenses);

        editTextIncome = (EditText)view.findViewById(R.id.editTextIncome);
        editTextBonus = (EditText)view.findViewById(R.id.editTextBonus);
        editTextRentalE = (EditText)view.findViewById(R.id.editTextRental);
        editTextHouseholdE = (EditText)view.findViewById(R.id.editTextHouseholdExpenses);
        editTextOtherE = (EditText)view.findViewById(R.id.editTextOtherExpenses);

        final double totalIncome;
        final double totalExpense;

        totalIncome = Double.parseDouble(editTextIncome.getText().toString()) + Double.parseDouble(editTextBonus.getText().toString());
        totalExpense = Double.parseDouble(editTextHouseholdE.getText().toString()) + Double.parseDouble(editTextRentalE.getText().toString()) + Double.parseDouble(editTextOtherE.getText().toString());

        Button btnNext = (Button)view.findViewById(R.id.buttonBFNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle b = getArguments();

                String name= b.getString("name");
                String IC = b.getString("ic");
                b.putString("name", name);
                b.putString("ic", IC);

                String spouseName = b.getString("s_name");
                String spouseIC = b.getString("s_ic");
                b.putString("s_name", spouseName);
                b.putString("s_ic", spouseIC);

                b.putDouble("income", totalIncome);
                b.putDouble("expense", totalExpense);


                //AdminMail mail = new AdminMail();
                //mail.setArguments(b);

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
