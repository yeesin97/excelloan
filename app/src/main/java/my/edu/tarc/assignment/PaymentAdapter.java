package my.edu.tarc.assignment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Personal on 10/1/2018.
 */

public class PaymentAdapter extends ArrayAdapter<Payment> {

    private List<Payment>  paymentList;
    Context context;

    public PaymentAdapter(@NonNull Context context, int resource, List<Payment> paymentList) {
        super(context, resource, paymentList);
        this.paymentList = paymentList;
        this.context =context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater  = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_payment, parent, false);

        TextView listDate = rowView.findViewById(R.id.listDate);
        TextView listAmount = rowView.findViewById(R.id.listAmount);
        TextView listNoOfTrans = rowView.findViewById(R.id.listNoOfTrans);

        Payment payment;
        payment = getItem(position);

        listDate.setText(payment.getPaymentDate());
        listAmount.setText(String.format("%.2f",payment.getAmount()));
        listNoOfTrans.setText(String.format("%3d",payment.getNoOfTrans()));

        return rowView;
    }
}
