package my.edu.tarc.assignment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class AdminMail extends Fragment {

    ListView listView;
    TextView textViewuserName, textViewuserIC, textViewuserPhoneNum, textViewuserEmailAddr, textViewmonthlyIncome, textViewmonthlyExpense, textViewspouseName, textViewspouseIC, textViewspousePhoneNum, textViewspouseNetIncome,textViewcarBrand, textViewcarPlate, textViewcarModel, textViewnetCarPrice, textViewdownpayment, textViewloanApplied;
    Button btnApprove, btnReject;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rowView = inflater.inflate(R.layout.fragment_admin_mail, container, false);

        textViewuserName = (TextView) rowView.findViewById(R.id.textViewMName);
        textViewuserIC = (TextView)rowView.findViewById(R.id.textViewMIC);
        textViewuserPhoneNum = (TextView)rowView.findViewById(R.id.textViewMPhoneNum);
        textViewuserEmailAddr = (TextView)rowView.findViewById(R.id.textViewMEmailAddr);
        textViewmonthlyIncome = (TextView)rowView.findViewById(R.id.textViewMMonthlyIncome);
        textViewmonthlyExpense = (TextView)rowView.findViewById(R.id.textViewMMonthlyExpense);

        textViewspouseName = (TextView)rowView.findViewById(R.id.textViewMSName);
        textViewspouseIC = (TextView)rowView.findViewById(R.id.textViewMSIC);
        textViewspousePhoneNum = (TextView)rowView.findViewById(R.id.textViewMSPhoneNum);
        textViewspouseNetIncome = (TextView)rowView.findViewById(R.id.textViewMSNetIncome);

        textViewcarBrand = (TextView)rowView.findViewById(R.id.textViewMCarBrand);
        textViewcarPlate = (TextView)rowView.findViewById(R.id.textViewMCarPlate);
        textViewcarModel = (TextView)rowView.findViewById(R.id.textViewMCarModel);
        textViewnetCarPrice = (TextView)rowView.findViewById(R.id.textViewMNetCarPrice);
        textViewdownpayment = (TextView)rowView.findViewById(R.id.textViewMDownpayment);
        textViewloanApplied = (TextView)rowView.findViewById(R.id.textViewMLoanApplied);

        btnApprove = (Button)rowView.findViewById(R.id.btnApprove);
        btnReject = (Button)rowView.findViewById(R.id.btnReject);

        Bundle b = getArguments();

        String name= b.getString("c_name");
        String IC = b.getString("c_ic");

        String spouse_name = b.getString("s_name");
        String spouse_ic = b.getString("s_ic");

        Double income = b.getDouble("income");
        Double expense = b.getDouble("expense");


        String car_plate = b.getString("carplate");
        String car_brand = b.getString("carbrand");
        String car_model = b.getString("carmodel");


        textViewuserName.setText(name);
        textViewuserIC.setText(IC);

        textViewspouseName.setText(spouse_name);
        textViewspouseIC.setText(spouse_ic);

        textViewmonthlyIncome.setText(String.valueOf(income));
        textViewmonthlyExpense.setText(String.valueOf(expense));

        textViewcarPlate.setText(car_plate);
        textViewcarBrand.setText(car_brand);
        textViewcarModel.setText(car_model);

        return rowView;
    }
}

