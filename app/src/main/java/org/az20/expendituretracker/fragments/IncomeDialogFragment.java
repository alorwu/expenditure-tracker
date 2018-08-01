package org.az20.expendituretracker.fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;


import org.az20.expendituretracker.R;

public class IncomeDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
        View mView = getLayoutInflater().inflate(R.layout.fragment_income_dialog, null);

        mBuilder.setView(mView);
        mBuilder.setTitle(R.string.add_income);

        return mBuilder.create();
    }
}
