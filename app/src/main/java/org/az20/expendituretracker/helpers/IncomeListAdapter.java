package org.az20.expendituretracker.helpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.az20.expendituretracker.R;
import org.az20.expendituretracker.database.Income;

import java.util.List;

public class IncomeListAdapter extends RecyclerView.Adapter<IncomeListAdapter.IncomeViewHolder> {

    class IncomeViewHolder extends RecyclerView.ViewHolder{

        private IncomeViewHolder(View itemView){
            super(itemView);
        }
    }

    private final LayoutInflater mLayoutInflater;
    private List<Income> mIncome;

    public IncomeListAdapter(Context context){
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public IncomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Replace layout with corresponding layout
        View itemView = mLayoutInflater.inflate(R.layout.fragment_home, parent, false);
        return new IncomeViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull IncomeViewHolder holder, int position) {
        // Bind holder to views. Income title and amount
    }

    public void setIncome(List<Income> income){
        mIncome = income;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mIncome != null)
            return mIncome.size();
        else return 0;
    }

}
