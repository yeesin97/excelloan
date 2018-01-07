package my.edu.tarc.assignment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 25/12/2017.
 */

public class LoanApplicationFragment extends Fragment {

    EditText editTextCarPrice, editTextCarPlate, editTextModel, editTextDownpayment, editTextLoanApplied;
    Spinner spinnerCarBrand, spinnerCarYear, spinnerLoanTerm;
    RadioButton radioButtonNew, radioButtonUsed;
    double car_price, downpayment, loanApplied, net_car_price;
    int car_year, loan_term;
    String car_brand;
    char vehicle_classification;
    ArrayAdapter <String> adapter;

    //constructor
    public LoanApplicationFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loan_application, container, false);

        final Button btnNext = (Button) view.findViewById(R.id.buttonLANext);

        editTextCarPrice = (EditText)view.findViewById(R.id.editTextSellingPrice);
        editTextDownpayment = (EditText)view.findViewById(R.id.editTextDownpayment);
        editTextCarPlate = (EditText)view.findViewById(R.id.editTextCarPlate);
        editTextModel = (EditText)view.findViewById(R.id.editTextCarModel);
        editTextLoanApplied = (EditText)view.findViewById(R.id.editTextLLoanAmount);
        spinnerCarBrand = (Spinner)view.findViewById(R.id.spinnerCarBrand);
        spinnerCarYear = (Spinner)view.findViewById(R.id.spinnerCarYear);
        spinnerLoanTerm = (Spinner)view.findViewById(R.id.spinnerLoanTerm);
        radioButtonNew = (RadioButton)view.findViewById(R.id.radioButtonNew);
        radioButtonUsed = (RadioButton)view.findViewById(R.id.radioButtonUsed);

        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                car_price = Double.parseDouble(editTextCarPrice.getText().toString());
                downpayment = Double.parseDouble(editTextDownpayment.getText().toString());
                loanApplied = Double.parseDouble(editTextLoanApplied.getText().toString());
                net_car_price = car_price - downpayment;

                final String[] loanTerm = getActivity().getResources().getStringArray(R.array.loanTerm);
                String[] carBrand = getActivity().getResources().getStringArray(R.array.carBrand);
                String[] carYear = getActivity().getResources().getStringArray(R.array.carYear);
                adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, loanTerm);
                adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, carBrand);
                adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, carYear);
                spinnerLoanTerm.setAdapter(adapter);
                spinnerCarBrand.setAdapter(adapter);
                spinnerCarYear.setAdapter(adapter);

                spinnerLoanTerm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        loan_term = i + 5;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }

                });

                spinnerCarBrand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        car_brand = spinnerCarBrand.getSelectedItem().toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                spinnerCarYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        car_year = i + 2010;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });


                if (TextUtils.isEmpty(editTextCarPrice.getText().toString()) || TextUtils.isEmpty(editTextDownpayment.getText().toString())
                        || TextUtils.isEmpty(editTextCarPlate.getText().toString()) || TextUtils.isEmpty(editTextModel.getText().toString()) ||
                        TextUtils.isEmpty(editTextLoanApplied.getText().toString())) {
                    Toast.makeText(getActivity(), "Require field(s) is missing.", Toast.LENGTH_LONG).show();
                } else if (radioButtonNew.isChecked() == false && radioButtonUsed.isChecked() == false) {
                    Toast.makeText(getActivity(), "Please select your vehicle classification.", Toast.LENGTH_LONG).show();
                } else if (loanApplied > net_car_price) {
                    Toast.makeText(getActivity(), "Please make adjustment on loan amount.", Toast.LENGTH_LONG).show();
                    editTextLoanApplied.requestFocus();
                } else {

                    if(radioButtonUsed.isChecked()) {
                        vehicle_classification = 'U';
                    }
                    else {
                        vehicle_classification = 'B';
                    }

                //pass data to terms and conditions fragment
                Bundle b = getArguments();

                String spouseName = b.getString("s_name");
                String spouseIc = b.getString("s_ic");
                int spouseAge = b.getInt("s_age");
                String spouseAddr = b.getString("s_addr");
                String spousePhoneNum = b.getString("s_phoneNum");
                String spouseEmail = b.getString("s_email");
                double spouseNetIncome = b.getDouble("s_netincome");
                char spouseRelationship = b.getChar("s_relationship");
                char spouseGender = b.getChar("s_gender");

                Double totalIncome = b.getDouble("income");
                Double totalExpense = b.getDouble("expense");

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

                String car_plate = editTextCarPlate.getText().toString();
                String car_model = editTextModel.getText().toString();

                b.putString("carplate", car_plate);
                b.putString("carbrand", car_brand);
                b.putString("carmodel", car_model);
                b.putInt("caryear", car_year);
                b.putChar("classification", vehicle_classification);

                //Toast.makeText(getActivity(), String .valueOf(income) + " , " + String.valueOf(expense), Toast.LENGTH_LONG).show();

                TermsAndConditionFragment tncf = new TermsAndConditionFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_container, tncf);
                tncf.setArguments(b);
                ft.addToBackStack(null);
                ft.commit();
            }
            }
        });

        getActivity().setTitle("Car Detail");

        return view;
    }


//    public void makeServiceCall(Context context, String url, final Car
//            car) {
//        //mPostCommentResponse.requestStarted();
//        RequestQueue queue = Volley. newRequestQueue (context);
//        //Send data
//        try {
//            StringRequest postRequest = new StringRequest(
//                    Request.Method.POST ,
//                    url,
//                    new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            JSONObject jsonObject;
//                            try {
//                                jsonObject = new JSONObject(response);
//                                int success = jsonObject.getInt( "success" );
//                                String message =
//                                        jsonObject.getString( "message" );
//                                if (success== 0 ) {
//                                    Toast. makeText (getActivity(),
//                                            message, Toast. LENGTH_LONG ).show();
//                                } else {
//                                    Toast. makeText (getActivity(),
//                                            message, Toast. LENGTH_LONG ).show();
//                                }
//                            }catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    },
//                    new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Toast. makeText (getActivity(), "Error. " +
//                                    error.toString(), Toast. LENGTH_LONG ).show();
//                        }
//                    }) {
//                @Override
//                protected Map<String, String> getParams() {
//                    Map<String, String> params = new HashMap<>();
//                    params.put( "carPlate" , car.getCarPlate());
//                    params.put( "carBrand" , car.getCarBrand());
//                    params.put( "model" , car.getModel());
//                    return params;
//                }
//                @Override
//                public Map<String, String> getHeaders() throws AuthFailureError
//                {
//                    Map<String, String> params = new HashMap<>();
//                    params.put( "Content-Type" ,
//                            "application/x-www-form-urlencoded" );
//                    return params;
//                }
//            };
//            queue.add(postRequest);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



}
