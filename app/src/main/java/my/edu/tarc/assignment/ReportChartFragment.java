package my.edu.tarc.assignment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
import com.github.mikephil.charting.formatter.YAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 03/01/2018.
 */

public class ReportChartFragment extends Fragment {

    BarChart barChart;
    View view;
    ImageButton imgLeft, imgRight,imgChange;
    TextView textMonth, textYear;
    int year;
    String startDate,endDate;
    String [] total = {"0","0","0","0","0","0","0","0","0","0","0","0"};

    public ReportChartFragment(){

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Report Chart");
        //  return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_report_chart, container, false);

        imgChange = view.findViewById(R.id.imgChange);
        imgLeft = view.findViewById(R.id.leftButton);
        imgRight = view.findViewById(R.id.rightButton);
        textYear = view.findViewById(R.id.textViewYear);
        barChart = view.findViewById(R.id.barchart);

        year=(Integer.parseInt(textYear.getText().toString()));

        imgLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                year=(Integer.parseInt(textYear.getText().toString()));

                year=year-1;
                textYear.setText(String.valueOf(year));

            }
        });


        imgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                year=(Integer.parseInt(textYear.getText().toString()));

                year=year+1;
                textYear.setText(String.valueOf(year));
            }
        });

        int count=0;

        for (int i=1 ; i<=12 ; i++){

            startDate = String.valueOf(year) + "-" + String.format("%02d",i) + "-01";
            endDate = String.valueOf(year) + "-" + String.format("%02d",i) + "-31";

           getIncome(getContext(),"https://excelloan.000webhostapp.com/getreportchart.php",startDate,endDate,i-1);

        }


        imgChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ReportFragment rp = new ReportFragment();
                ft.replace(R.id.frame_container, rp);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        

        return view;

    }


    public void getIncome(Context context, String url, final String startDate, final String endDate,final int count) {
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
                            JSONObject jsonObject;
                            try {
                                jsonObject = new JSONObject(response);
                                int success = jsonObject.getInt("success");

                                if (success==0) {

                                    Toast.makeText(getContext(), "No Result Found ", Toast.LENGTH_LONG).show();

                                }else{

                                    double monthIncome=jsonObject.getDouble("income");
                                    total[count]=String.valueOf(monthIncome);
                                    Toast.makeText(getContext(), monthIncome  + "Hello "+ count + "   // " + startDate + " and " + endDate, Toast.LENGTH_LONG).show();

                                    if(count == 11){
                                        graph();
                                    }

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() { //if server down or unavailable or what
                        @Override
                        public void onErrorResponse(VolleyError error) {
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


    public void graph(){
        ArrayList<String> xAxis = new ArrayList<>();
        ArrayList<BarEntry> barEntries = new ArrayList<>();

        Toast.makeText(getContext(), total[0]  + "hereh 1", Toast.LENGTH_LONG).show();
        Toast.makeText(getContext(), total[0]  + "hereh 2", Toast.LENGTH_LONG).show();

        xAxis.add("JAN");
        xAxis.add("FEB");
        xAxis.add("MAC");
        xAxis.add("APR");
        xAxis.add("MAY");
        xAxis.add("JUN");
        xAxis.add("JUL");
        xAxis.add("AUG");
        xAxis.add("SEP");
        xAxis.add("OCT");
        xAxis.add("NOV");
        xAxis.add("DEC");

        barEntries.add(new BarEntry(Float.valueOf(total[0]),0));
        barEntries.add(new BarEntry(Float.valueOf(total[1]),1));
        barEntries.add(new BarEntry(Float.valueOf(total[2]),2));
        barEntries.add(new BarEntry(Float.valueOf(total[3]),3));
        barEntries.add(new BarEntry(Float.valueOf(total[4]),4));
        barEntries.add(new BarEntry(Float.valueOf(total[5]),5));
        barEntries.add(new BarEntry(Float.valueOf(total[6]),6));
        barEntries.add(new BarEntry(Float.valueOf(total[7]),7));
        barEntries.add(new BarEntry(Float.valueOf(total[8]),8));
        barEntries.add(new BarEntry(Float.valueOf(total[9]),9));
        barEntries.add(new BarEntry(Float.valueOf(total[10]),10));
        barEntries.add(new BarEntry(Float.valueOf(total[11]),11));

        BarDataSet barDataSet = new BarDataSet(barEntries,"INCOME");
        barDataSet.setColor(Color.BLUE);


        YAxis yAxisRight = barChart.getAxisRight();
        YAxis yAxisLeft = barChart.getAxisLeft();

        yAxisRight.setEnabled(true);
        yAxisLeft.setEnabled(true);

        yAxisLeft.setAxisMinValue(0);

        barChart.getXAxis().setTextSize(2);
        barChart.getXAxis().setDrawLabels(true);

        BarData data = new BarData(xAxis,barDataSet);
        barChart.setExtraOffsets(0,0,0,20);
        barChart.setData(data);

        barChart.setPinchZoom(true);
        barChart.setDragEnabled(false);
        barChart.setTouchEnabled(false);
        barChart.setScaleEnabled(false);
        barChart.setDoubleTapToZoomEnabled(true);
        barChart.setDescription("INCOME");
        barChart.setFitsSystemWindows(false);
        barChart.setVisibleXRangeMinimum(0);
        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(false);

        barChart.animateXY(2000,2000);
        barChart.invalidate();

    }


}



