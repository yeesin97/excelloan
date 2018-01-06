package my.edu.tarc.assignment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

    //constructor
    public LoanApplicationFragment(){

    }
    EditText carPlate, carBrand, model;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loan_application, container, false);

        final Button btnNext = (Button) view.findViewById(R.id.buttonLANext);


        carPlate = (EditText)view.findViewById(R.id.editTextCarPlate);
        carBrand = (EditText)view.findViewById(R.id.editTextCarBrand);
        model = (EditText)view.findViewById(R.id.editTextCarModel);

        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                ///////////////////////////////////////////////////////////////////////

//                Car car = new Car();
//
//                car.setCarBrand(carBrand.getText().toString());
//                car.setCarPlate(carPlate.getText().toString());
//                car.setModel(model.getText().toString());
//
//
//                try {
//                    makeServiceCall(getActivity() , "https://excelloan.000webhostapp.com/insert_loan.php" , car);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Toast. makeText (getActivity(), "Error: " + e.getMessage(),
//                            Toast. LENGTH_LONG ).show();
//                }


                ///////////////////////////////////////////////////////////////////////


                //pass data to terms and conditions fragment
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

                String car_plate = carPlate.getText().toString();
                String car_brand = carBrand.getText().toString();
                String car_model = model.getText().toString();
                b.putString("carplate", car_plate);
                b.putString("carbrand", car_brand);
                b.putString("carmodel", car_model);

                TermsAndConditionFragment tncf = new TermsAndConditionFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame_container, tncf);
                tncf.setArguments(b);
                ft.addToBackStack(null);
                ft.commit();
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
