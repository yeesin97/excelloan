package my.edu.tarc.assignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by User on 03/01/2018.
 */

public class AdminViewLoanFragment extends Fragment {
    public AdminViewLoanFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Car Loan");
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
