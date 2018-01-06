package my.edu.tarc.assignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by User on 02/01/2018.
 */

public class CalculatorFragment extends Fragment {

    public int position;

    public CalculatorFragment(){

    }

    View view;

    EditText editTextCarPrice;
    EditText editTextDownpayment;
    TextView textViewMonthlyRepayment;
    TextView textViewTotalPrincipal;
    TextView textViewInterestPaid;
    Double principal;
    Double interestRate = 0.0301;
    Double totalInterest;
    Double monthlyRepayment;

    ArrayAdapter <String> adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calculator, container, false);
        getActivity().setTitle("Calculator");

        Button btnCalc = (Button)view.findViewById(R.id.buttonCalc);

        //btnCalc.setOnClickListener(new View.OnClickListener() {
        //Spinner spin = (Spinner)view.findViewById(R.id.spinnerLoanTerm);

        //String[] loanTerm = getResources().getStringArray(R.array.loanTerm);
        //final int year = Integer.valueOf(loanTerm[position]);


        final Spinner spin = (Spinner)view.findViewById(R.id.spinnerLoanTerm);
        String[] year = getActivity().getResources().getStringArray(R.array.loanTerm);

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, year);
        spin.setAdapter(adapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                position = i+5;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        editTextCarPrice = (EditText)view.findViewById(R.id.editTextCCarPrice);
        editTextDownpayment = (EditText)view.findViewById(R.id.editTextCDownpayment);
        textViewMonthlyRepayment = (TextView)view.findViewById(R.id.textViewMonthlyRepayment);
        textViewTotalPrincipal = (TextView)view.findViewById(R.id.textViewPrincipalPaid);
        textViewInterestPaid = (TextView)view.findViewById(R.id.textViewInterestPaid);
        //textViewInterestRate = (TextView)view.findViewById(R.id.textViewInterestRate);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double carPrice = Double.parseDouble(editTextCarPrice.getText().toString());
                Double downpayment = Double.parseDouble(editTextDownpayment.getText().toString());

                if (carPrice <= downpayment)
                {
                    Toast.makeText(getActivity(), "Invalid input of Car Price or Downpayment", Toast.LENGTH_LONG).show();
                    editTextCarPrice.requestFocus();
                }
                else
                {
                    principal = carPrice - downpayment;
                    textViewTotalPrincipal.setText(String.format("RM %.2f", principal));
                    totalInterest = principal * interestRate * position;
                    textViewInterestPaid.setText(String.format("RM %.2f", totalInterest));
                    monthlyRepayment = totalInterest / position / 12;
                    textViewMonthlyRepayment.setText(String.format(" %.2f", monthlyRepayment));
                    //Toast.makeText(getActivity(), String.valueOf(totalInterest), Toast.LENGTH_LONG).show();

                }
               // Toast.makeText(getActivity(), String.valueOf(position), Toast.LENGTH_LONG).show();


            }
        });



        return view;
    }
}
