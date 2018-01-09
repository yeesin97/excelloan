package my.edu.tarc.assignment;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 03/01/2018.
 */

public class ReportFragment extends Fragment {

    ListView listReport;
    View view;
    ImageButton imgLeft, imgRight, imgChange;
    TextView textMonth, textYear;
    String month;
    int year;
    String startDate,endDate;
    private ProgressDialog progressDialog;
    List<Payment> paymentList=new ArrayList<>();

    public ReportFragment(){

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressDialog = new ProgressDialog(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Report List");
        //  return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_report, container, false);

        imgChange = view.findViewById(R.id.imgChange);
        imgLeft = view.findViewById(R.id.leftButton);
        imgRight = view.findViewById(R.id.rightButton);
        textMonth = view.findViewById(R.id.textViewMonth);
        textYear = view.findViewById(R.id.textViewYear);
        listReport = view.findViewById(R.id.listReport);

        month=textMonth.getText().toString();
        year=(Integer.parseInt(textYear.getText().toString()));

        imgLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                month=textMonth.getText().toString();
                year=(Integer.parseInt(textYear.getText().toString()));

                switch (month) {
                    case "JAN":
                        textMonth.setText("DEC");
                        year=year-1;
                        textYear.setText(String.valueOf(year));
                        break;
                    case "FEB":
                        textMonth.setText("JAN");
                        break;
                    case "MAC":
                        textMonth.setText("FEB");
                        break;
                    case "APR":
                        textMonth.setText("MAC");
                        break;
                    case "MAY":
                        textMonth.setText("APR");
                        break;
                    case "JUN":
                        textMonth.setText("MAY");
                        break;
                    case "JUL":
                        textMonth.setText("JUN");
                        break;
                    case "AUG":
                        textMonth.setText("JUL");
                        break;
                    case "SEP":
                        textMonth.setText("AUG");
                        break;
                    case "OCT":
                        textMonth.setText("SEP");
                        break;
                    case "NOV":
                        textMonth.setText("OCT");
                        break;
                    case "DEC":
                        textMonth.setText("NOV");
                        year=year+1;
                        textYear.setText(year);
                        break;
                    default:
                        break;
                }
            }
        });


        imgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                month=textMonth.getText().toString();
                year=(Integer.parseInt(textYear.getText().toString()));

                switch (month) {
                    case "JAN":
                        textMonth.setText("FEB");
                        break;
                    case "FEB":
                        textMonth.setText("MAC");
                        break;
                    case "MAC":
                        textMonth.setText("APR");
                        break;
                    case "APR":
                        textMonth.setText("MAY");
                        break;
                    case "MAY":
                        textMonth.setText("JUN");
                        break;
                    case "JUN":
                        textMonth.setText("JUL");
                        break;
                    case "JUL":
                        textMonth.setText("AUG");
                        break;
                    case "AUG":
                        textMonth.setText("SEP");
                        break;
                    case "SEP":
                        textMonth.setText("OCT");
                        break;
                    case "OCT":
                        textMonth.setText("NOV");
                        break;
                    case "NOV":
                        textMonth.setText("DEC");
                        break;
                    case "DEC":
                        textMonth.setText("JAN");
                        year=year+1;
                        textYear.setText(String.valueOf(year));
                        break;
                    default:
                        break;
                }
            }
        });

        imgChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ReportChartFragment rp = new ReportChartFragment();
                ft.replace(R.id.frame_container, rp);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        setDate();

        getIncome(getContext(),"https://excelloan.000webhostapp.com/getreportlist.php",startDate,endDate);


        return view;

    }


    public void setDate(){

        if (!progressDialog.isShowing())
            progressDialog.setMessage("Syn with server...");

        progressDialog.show();


        switch (month) {
            case "JAN":
                startDate = String.valueOf(year) + "-01-01";
                endDate = String.valueOf(year) + "-01-31";
                break;
            case "FEB":
                startDate = String.valueOf(year) + "-02-01";
                endDate = String.valueOf(year) + "-02-29";
                break;
            case "MAC":
                startDate = String.valueOf(year) + "-03-01";
                endDate = String.valueOf(year) + "-03-31";
                break;
            case "APR":
                startDate = String.valueOf(year) + "-04-01";
                endDate = String.valueOf(year) + "-04-30";
                break;
            case "MAY":
                startDate = String.valueOf(year) + "-05-01";
                endDate = String.valueOf(year) + "-05-31";
                break;
            case "JUN":
                startDate = String.valueOf(year) + "-06-01";
                endDate = String.valueOf(year) + "-06-30";
                break;
            case "JUL":
                startDate = String.valueOf(year) + "-07-01";
                endDate = String.valueOf(year) + "-07-31";
                break;
            case "AUG":
                startDate = String.valueOf(year) + "-08-01";
                endDate = String.valueOf(year) + "-08-31";
                break;
            case "SEP":
                startDate = String.valueOf(year) + "-09-01";
                endDate = String.valueOf(year) + "-09-30";
                break;
            case "OCT":
                startDate = String.valueOf(year) + "-10-01";
                endDate = String.valueOf(year) + "-10-31";
                break;
            case "NOV":
                startDate = String.valueOf(year) + "-11-01";
                endDate = String.valueOf(year) + "-11-30";
                break;
            case "DEC":
                startDate = String.valueOf(year) + "-12-01";
                endDate = String.valueOf(year) + "-12-31";
                break;
            default:
                break;
        }



    }


    public void getIncome(Context context, String url, final String startDate, final String endDate) {
        //mPostCommentResponse.requestStarted();
        RequestQueue queue = Volley.newRequestQueue(context);
        //Send data
        try {
            StringRequest postRequest = new StringRequest(
                    Request.Method.POST,
                    url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            JSONArray jsonArray;
                            try {
                                jsonArray = new JSONArray(response);

                                if (jsonArray.length()==0){
                                    if (progressDialog.isShowing())
                                        progressDialog.dismiss();
                                    Toast.makeText(getContext(), "No Result Found ", Toast.LENGTH_LONG).show();
                                }
                                else{
                                    for(int i=0;i<jsonArray.length();i++){

                                        JSONObject jsonObject=(JSONObject)jsonArray.get(i);
                                        String paymentDate = jsonObject.getString("paymentDate");
                                        double monthIncome =jsonObject.getDouble("income");
                                        int noOfTrans = jsonObject.getInt("noOfTrans");
                                        Payment payment = new Payment(paymentDate,monthIncome,noOfTrans);
                                        paymentList.add(payment);
                                    }
                                    Toast.makeText(getContext(), "Yes,you got it! ", Toast.LENGTH_LONG).show();
                                    loadListView();
                                }
                            } catch (JSONException e) {

                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
                            Toast.makeText(getContext(), "Error. " + error.toString(), Toast.LENGTH_LONG).show();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put("startDate", startDate);
                    params.put("endDate",endDate);

                    return params;
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("Content-Type", "application/x-www-form-urlencoded");
                    return params;
                }
            };
            queue.add(postRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadListView(){
        if (progressDialog.isShowing())
            progressDialog.dismiss();

        final PaymentAdapter adapter = new PaymentAdapter(getContext(), R.layout.fragment_report, paymentList);
        listReport.setAdapter(adapter);

        Toast.makeText(getContext(), "whyyyy!!!", Toast.LENGTH_LONG).show();
    }




}



