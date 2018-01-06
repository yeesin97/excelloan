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
    TextView userName, userIC, userPhoneNum, userEmailAddr, monthlyIncome, monthlyExpense, spouseName, spouseIC, spousePhoneNum, spouseNetIncome,carBrand, carPlate, carModel, netCarPrice, downpayment, loanApplied;
    Button btnApprove, btnReject;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rowView = inflater.inflate(R.layout.fragment_admin_mail, container, false);


        userName = (TextView) rowView.findViewById(R.id.textViewMName);
        userIC = (TextView)rowView.findViewById(R.id.textViewMIC);
        userPhoneNum = (TextView)rowView.findViewById(R.id.textViewMPhoneNum);
        userEmailAddr = (TextView)rowView.findViewById(R.id.textViewMEmailAddr);
        monthlyIncome = (TextView)rowView.findViewById(R.id.textViewMMonthlyIncome);
        monthlyExpense = (TextView)rowView.findViewById(R.id.textViewMMonthlyExpense);

        spouseName = (TextView)rowView.findViewById(R.id.textViewMSName);
        spouseIC = (TextView)rowView.findViewById(R.id.textViewMSIC);
        spousePhoneNum = (TextView)rowView.findViewById(R.id.textViewMSPhoneNum);
        spouseNetIncome = (TextView)rowView.findViewById(R.id.textViewMSNetIncome);

        carBrand = (TextView)rowView.findViewById(R.id.textViewMCarBrand);
        carPlate = (TextView)rowView.findViewById(R.id.textViewMCarPlate);
        carModel = (TextView)rowView.findViewById(R.id.textViewMCarModel);
        netCarPrice = (TextView)rowView.findViewById(R.id.textViewMNetCarPrice);
        downpayment = (TextView)rowView.findViewById(R.id.textViewMDownpayment);
        loanApplied = (TextView)rowView.findViewById(R.id.textViewMLoanApplied);

        btnApprove = (Button)rowView.findViewById(R.id.btnApprove);
        btnReject = (Button)rowView.findViewById(R.id.btnReject);

        Bundle b = getArguments();

        String name= b.getString("name");
        String IC = b.getString("ic");

        String spouse_name = b.getString("s_name");
        String spouse_ic = b.getString("s_ic");

        String income = b.getString("income");
        String expense = b.getString("expense");


        String car_plate = b.getString("carplate");
        String car_brand = b.getString("carbrand");
        String car_model = b.getString("carmodel");



        userName.setText(name);
        userIC.setText(IC);

        spouseName.setText(spouse_name);
        spouseIC.setText(spouse_ic);

        monthlyIncome.setText(income);
        monthlyExpense.setText(expense);

        carPlate.setText(car_plate);
        carBrand.setText(car_brand);
        carModel.setText(car_model);
//        TextView textViewCode, textViewTitle, textViewCredit;
//        textViewCode = (TextView)rowView.findViewById(R.id.textViewCode);
//        textViewTitle = (TextView)rowView.findViewById(R.id.textViewTitle);
//        textViewCredit = (TextView)rowView.findViewById(R.id.textViewCredit);
//        textViewCode.setText(textViewCode.getText() + ":" +course.getCode());
//        textViewTitle.setText(textViewTitle.getText() + ":" +
//                course.getTitle());
//        textViewCredit.setText(textViewCredit.getText() + ":" +
//                course.getCredit());
        return rowView;
    }
}

