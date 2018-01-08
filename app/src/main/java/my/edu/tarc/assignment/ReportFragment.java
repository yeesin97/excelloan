package my.edu.tarc.assignment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

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

        ArrayList<String> xAxis = new ArrayList<>();
        ArrayList<BarEntry> barEntries = new ArrayList<>();

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

        barEntries.add(new BarEntry(2500,0));
        barEntries.add(new BarEntry(2000,1));
        barEntries.add(new BarEntry(4000,2));
        barEntries.add(new BarEntry(3000,3));
        barEntries.add(new BarEntry(2500,4));
        barEntries.add(new BarEntry(2000,5));
        barEntries.add(new BarEntry(4000,6));
        barEntries.add(new BarEntry(3000,7));
        barEntries.add(new BarEntry(2500,8));
        barEntries.add(new BarEntry(2000,9));
        barEntries.add(new BarEntry(4000,10));
        barEntries.add(new BarEntry(3000,11));

        BarDataSet barDataSet = new BarDataSet(barEntries,"INCOME");
        barDataSet.setColor(Color.BLUE);


        YAxis yAxisRight = barChart.getAxisRight();
        yAxisRight.setEnabled(true);

        barChart.getXAxis().setTextSize(2);
        barChart.getXAxis().setDrawLabels(true);

        BarData data = new BarData(xAxis,barDataSet);
        barChart.setExtraOffsets(0,0,0,20);
        barChart.setData(data);
        barChart.setPinchZoom(true);
        barChart.setDragEnabled(false);
        barChart.setTouchEnabled(false);
        barChart.setScaleEnabled(true);
        barChart.setDoubleTapToZoomEnabled(true);
        barChart.setDescription("INCOME");
        barChart.setFitsSystemWindows(false);
        barChart.setVisibleXRangeMinimum(1);

//        barChart.animateXY(2000,2000);
        barChart.invalidate();

        return view;

    }
}


//        ArrayList<BarEntry> barEntries = new ArrayList<>();
//        barEntries.add(new BarEntry(0f,30f));
//        barEntries.add(new BarEntry(1f,80f));
//        barEntries.add(new BarEntry(2f,60f));
//        barEntries.add(new BarEntry(3f,50f));
//        barEntries.add(new BarEntry(4f,70f));
//        barEntries.add(new BarEntry(5f,60f));
//        barEntries.add(new BarEntry(6f,0f));
//        barEntries.add(new BarEntry(7f,0f));
//        barEntries.add(new BarEntry(8f,80f));
//        barEntries.add(new BarEntry(9f,90f));
//        barEntries.add(new BarEntry(10f,0f));
//        barEntries.add(new BarEntry(11f,10f));
//        barEntries.add(new BarEntry(12f,0f));
//
//        BarDataSet barDataSet = new BarDataSet(barEntries,"Income");
//        barDataSet.setColor(12);
//        barDataSet.setValueTextColor(12);
//
//      //ArrayList<String> theDates = new ArrayList<>();
//       // theDates.add("JAN");
//        //theDates.add("FEB");
//        //theDates.add("MAC");
//       //theDates.add("APR");
//        //theDates.add("MAY");
//        //theDates.add("JUN");
//        ///theDates.add("JUL");
//        //theDates.add("AUG");
//        ///theDates.add("SEP");
//        //theDates.add("OCT");
//        //theDates.add("NOV");
//        ///theDates.add("DEC");
//
//        BarData theData = new BarData(barDataSet);
//        theData.setBarWidth(0.9f);
//        barChart.setData(theData);
//        barChart.setFitBars(true);
//        barChart.setTouchEnabled(false);
//        barChart.setVisibleXRangeMinimum(1);
//
//        barChart.getXAxis().setDrawLabels(true);
//        barChart.getXAxis().setDrawGridLines(false);
//
//
//        barChart.setDragEnabled(false);
//        barChart.setScaleEnabled(false);
//        barChart.invalidate();
//        return view;

