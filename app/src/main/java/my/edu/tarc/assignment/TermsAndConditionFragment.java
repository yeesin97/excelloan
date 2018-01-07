package my.edu.tarc.assignment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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

public class TermsAndConditionFragment extends Fragment {
    public TermsAndConditionFragment(){

    }

    CheckBox chkAgree;
    Button btnNext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_terms_condition, container, false);
        btnNext = (Button)view.findViewById(R.id.buttonTCNext);
        chkAgree = (CheckBox)view.findViewById(R.id.checkBoxAgree);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chkAgree.isChecked())
                {

                    Bundle b = getArguments();

                    String name= b.getString("name");
                    String IC = b.getString("ic");
                    b.putString("name", name);
                    b.putString("ic", IC);

                    String spouseName = b.getString("s_name");
                    String spouseIC = b.getString("s_ic");
                    b.putString("s_name", spouseName);
                    b.putString("s_ic", spouseIC);

                    String income = b.getString("income");
                    b.putString("income", income);
                    String expense = b.getString("expense");
                    b.putString("expense", expense);

                    String car_plate = b.getString("carplate");
                    String car_brand = b.getString("carbrand");
                    String car_model = b.getString("carmodel");
                    b.putString("carplate", car_plate);
                    b.putString("carbrand", car_brand);
                    b.putString("carmodel", car_model);

                    Car car = new Car();

                    car.setCarBrand(car_brand);
                    car.setCarPlate(car_plate);
                    car.setModel(car_model);

                    Loan loan = new Loan();
                    loan.setUserID(name);
                    loan.setLoanMonthlyIncome(Double.parseDouble(income));
                    loan.setLoanMonthlyExpenses(Double.parseDouble(expense));
                    loan.setLoanID("L000005");
                    loan.setLoanStatus('P');


                    try {
                        makeServiceCall(getActivity() , "https://excelloan.000webhostapp.com/insert_loan.php" , loan);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast. makeText (getActivity(), "Error: " + e.getMessage(),
                                Toast. LENGTH_LONG ).show();
                    }


                    AdminMail mail = new AdminMail();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frame_container, mail);
                    mail.setArguments(b);
                    ft.addToBackStack(null);
                    ft.commit();
                }
                else
                {
                    Toast.makeText(getActivity(), "Please agree the terms and conditions before proceed.", Toast.LENGTH_LONG).show();
                }

            }
        });

        getActivity().setTitle("Terms and Conditions");

        return view;
    }

    public void makeServiceCall(Context context, String url, final Loan
            loan) {
        //mPostCommentResponse.requestStarted();
        RequestQueue queue = Volley. newRequestQueue (context);
        //Send data
        try {
            StringRequest postRequest = new StringRequest(
                    Request.Method.POST ,
                    url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            JSONObject jsonObject;
                            try {
                                jsonObject = new JSONObject(response);
                                int success = jsonObject.getInt( "success" );
                                String message =
                                        jsonObject.getString( "message" );
                                if (success== 0 ) {
                                    Toast. makeText (getActivity(),
                                            message, Toast. LENGTH_LONG ).show();
                                } else {
                                    Toast. makeText (getActivity(),
                                            message, Toast. LENGTH_LONG ).show();
                                }
                            }catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast. makeText (getActivity(), "Error. " +
                                    error.toString(), Toast. LENGTH_LONG ).show();
                        }
                    }) {

//                @Override
//                protected Map<String, String> getParams() {
//                    Map<String, String> params = new HashMap<>();
//                    params.put( "carPlate" , car.getCarPlate());
//                    params.put( "carBrand" , car.getCarBrand());
//                    params.put( "model" , car.getModel());
//                    return params;
//                }


                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("loanID", loan.getLoanID());
                    params.put("userID", loan.getUserID());
                    params.put("loanStatus", String.valueOf(loan.getLoanStatus()));
                    params.put("loanMonthlyIncome", String.valueOf(loan.getLoanMonthlyIncome()));
                    params.put("loanMonthlyExpenses", String.valueOf(loan.getLoanMonthlyExpenses()));
                    return params;
                }


                @Override
                public Map<String, String> getHeaders() throws AuthFailureError
                {
                    Map<String, String> params = new HashMap<>();
                    params.put( "Content-Type" ,
                            "application/x-www-form-urlencoded" );
                    return params;
                }
            };
            queue.add(postRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
