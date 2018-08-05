
package org.az20.expendituretracker.fragments;

import android.app.Activity;
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
import org.az20.expendituretracker.database.Category;
import org.az20.expendituretracker.viewmodels.CategoryViewModel;

public class CategoryDialogFragment extends DialogFragment implements View.OnClickListener{

    private TextInputEditText titleText, amountText;
    private CategoryViewModel categoryViewModel;
    private Activity activity;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        activity = getActivity();
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(activity);
        View mView = activity.getLayoutInflater().inflate(R.layout.fragment_dialog, null);

        mBuilder.setView(mView);
        mBuilder.setTitle(R.string.add_category);

        categoryViewModel = new CategoryViewModel(activity.getApplication());

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
                    Category category = new Category();
                    category.setCatTitle(title);
                    category.setCatAmount(Integer.parseInt(amount));
                    category.setSpentAmount(0);
                    categoryViewModel.addCategory(category);
                    Toast.makeText(getContext(), title + " " + amount + " Saved successfully.", Toast.LENGTH_SHORT).show();
                    getDialog().dismiss();
                }
                else
                    Toast.makeText(getContext(), " Amount field can't be empty.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancel_btn:
                getDialog().dismiss();
                Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}


