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

import java.util.List;

public class AdminMail extends Fragment {

    ListView listView;
    TextView userName, monthlyIncome, userIC, spouseName, spouseIC;
    Button btnApprove;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rowView = inflater.inflate(R.layout.fragment_admin_mail, container, false);


        userName = (TextView) rowView.findViewById(R.id.textViewMName);
        userIC = (TextView)rowView.findViewById(R.id.textViewMIC);
        spouseName = (TextView)rowView.findViewById(R.id.textViewMSName);
        spouseIC = (TextView)rowView.findViewById(R.id.textViewMSIC);
        monthlyIncome = (TextView)rowView.findViewById(R.id.textViewMMonthlyIncome);
        btnApprove = (Button)rowView.findViewById(R.id.btnApprove);

        Bundle b = getArguments();

        String name= b.getString("name");
        String IC = b.getString("ic");

        String spouseName = b.getString("s_name");
        String spouseIC = b.getString("s_ic");

        String income = b.getString("income");
        String expense = b.getString("expense");


        String car_plate = b.getString("carplate");
        String car_brand = b.getString("carbrand");
        String car_model = b.getString("carmodel");



        userName.setText(name);

        monthlyIncome.setText(income);
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
        //return super.getView(position, convertView, parent);
    }
}

