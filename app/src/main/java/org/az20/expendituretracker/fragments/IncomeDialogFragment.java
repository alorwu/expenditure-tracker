package org.az20.expendituretracker.fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import org.az20.expendituretracker.R;

public class IncomeDialogFragment extends DialogFragment{


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
        View mView = getActivity().getLayoutInflater().inflate(R.layout.fragment_dialog, null);

        mBuilder.setView(mView);
        mBuilder.setTitle(R.string.add_income);

        final TextInputEditText titleText = mView.findViewById(R.id.et_title);
        final TextInputEditText amountText = mView.findViewById(R.id.et_amount);
        Button saveBtn = mView.findViewById(R.id.save_btn);
        Button cancelBtn = mView.findViewById(R.id.cancel_btn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String title = titleText.getText().toString().trim();
                final String amount = amountText.getText().toString();

                if (!amount.isEmpty()) {
                    Toast.makeText(getContext(), title + " " + amount + " Saved successfully.", Toast.LENGTH_SHORT).show();
                    getDialog().dismiss();
                }
                else
                    Toast.makeText(getContext(), " Amount field can't be empty.", Toast.LENGTH_SHORT).show();

            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                getDialog().dismiss();
            }
        });

        return mBuilder.create();
    }

}
