package org.az20.expendituretracker.helpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.az20.expendituretracker.R;
import org.az20.expendituretracker.database.Expenses;

import java.util.List;

public class ExpensesListAdapter extends RecyclerView.Adapter<ExpensesListAdapter.ExpensesViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private List<Expenses> mExpenses;

    public ExpensesListAdapter(Context context){
        mLayoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ExpensesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Replace layout with corresponding layout
        View mView = mLayoutInflater.inflate(R.layout.fragment_home, parent, false);
        return new ExpensesViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpensesViewHolder holder, int position) {
        // Bind holder to views. Income title and amount
    }

    @Override
    public int getItemCount() {
        if (mExpenses != null)
            return mExpenses.size();
        else return 0;
    }

    public void setExpenses(List<Expenses> expenses){
        mExpenses = expenses;
        notifyDataSetChanged();
    }

    class ExpensesViewHolder extends RecyclerView.ViewHolder{

        public ExpensesViewHolder(View itemView) {
            super(itemView);
        }
    }
}
