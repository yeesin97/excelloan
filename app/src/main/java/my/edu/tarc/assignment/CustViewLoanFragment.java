package my.edu.tarc.assignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by User on 03/01/2018.
 */

public class CustViewLoanFragment extends Fragment {

    String[] MyData = {"One","Two","Three","Four","Five"};
    View view;

    public CustViewLoanFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_borrower_financial, container, false);

        ListView MyListView = view.findViewById(R.id.MyListView);

        final ArrayAdapter MyArrayAdapter = new ArrayAdapter(getActivity(),R.layout.listview_sytle,MyData);

        MyListView.setAdapter(MyArrayAdapter);

        MyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle b = new Bundle();

            //   String name = ;
            //   String IC = ;

                LoanDetailFragment ldf = new LoanDetailFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();

               // b.putString("name", name);
               // b.putString("ic", IC);

                ft.replace(R.id.frame_container, ldf);
                ldf.setArguments(b);
                ft.addToBackStack(null);
                ft.commit();
            }


        });

        getActivity().setTitle(" ");

        return view;

    }
}
