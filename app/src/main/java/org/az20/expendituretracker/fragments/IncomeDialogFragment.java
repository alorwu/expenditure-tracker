package org.az20.expendituretracker.fragments;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import org.az20.expendituretracker.R;

public class IncomeDialogFragment extends DialogFragment implements View.OnClickListener {

    TextInputEditText titleText, amountText;
    private DialogListener listener;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
        View mView = getActivity().getLayoutInflater().inflate(R.layout.fragment_dialog, null);

        mBuilder.setView(mView);
        mBuilder.setTitle(R.string.add_income);

        titleText = mView.findViewById(R.id.et_title);
        amountText = mView.findViewById(R.id.et_amount);
        Button saveBtn = mView.findViewById(R.id.save_btn);
        Button cancelBtn = mView.findViewById(R.id.cancel_btn);

        saveBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);

        return mBuilder.create();
    }


    @Override
    public void onClick(View v) {

        int id = v.getId();

        switch (id){

            case R.id.save_btn:
                final String title = titleText.getText().toString().trim();
                final String amount = amountText.getText().toString().trim();
                if (!amount.isEmpty()) {
                    listener.sendData(title, Integer.parseInt(amount));
                    Toast.makeText(getContext(), title + " " + amount + " saved.", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getContext(), " Amount field can't empty.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancel_btn:
                IncomeDialogFragment.this.getDialog().cancel();
                Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (DialogListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " implement dialog listener");
        }
    }


    public interface DialogListener{
        void sendData(String title, int amount);
    }
}
