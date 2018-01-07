package my.edu.tarc.assignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

/**
 * Created by User on 03/01/2018.
 */

public class ReportFragment extends Fragment {

    BarChart barChart;
    View view;

    public ReportFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Report");
      //  return super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_report, container, false);


        barChart = view.findViewById(R.id.barchart);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0f,30f));
        barEntries.add(new BarEntry(1f,80f));
        barEntries.add(new BarEntry(2f,60f));
        barEntries.add(new BarEntry(3f,50f));
        barEntries.add(new BarEntry(4f,70f));
        barEntries.add(new BarEntry(5f,60f));
        barEntries.add(new BarEntry(6f,0f));
        barEntries.add(new BarEntry(7f,0f));
        barEntries.add(new BarEntry(8f,80f));
        barEntries.add(new BarEntry(9f,90f));
        barEntries.add(new BarEntry(10f,0f));
        barEntries.add(new BarEntry(11f,10f));
        barEntries.add(new BarEntry(12f,0f));

        BarDataSet barDataSet = new BarDataSet(barEntries,"Income");

      //  ArrayList<String> theDates = new ArrayList<>();
       // theDates.add("JAN");
        //theDates.add("FEB");
        //theDates.add("MAC");
       //theDates.add("APR");
        //theDates.add("MAY");
        //theDates.add("JUN");
        ///theDates.add("JUL");
        //theDates.add("AUG");
        ///theDates.add("SEP");
        //theDates.add("OCT");
        //theDates.add("NOV");
        ///theDates.add("DEC");

        BarData theData = new BarData(barDataSet);
        theData.setBarWidth(0.9f);
        barChart.setData(theData);
        barChart.setFitBars(true);
        barChart.setTouchEnabled(false);
        barChart.setVisibleXRangeMinimum(1);

        barChart.setDragEnabled(false);
        barChart.setScaleEnabled(false);
        barChart.invalidate();
        return view;

    }
}
