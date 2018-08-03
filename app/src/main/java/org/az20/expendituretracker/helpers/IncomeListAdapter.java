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
        private final TextView incomeItem, tvAmount;

        private IncomeViewHolder(View itemView){
            super(itemView);
            incomeItem = itemView.findViewById(R.id.tv_title);
            tvAmount = itemView.findViewById(R.id.tv_amount);
        }
    }

    private final LayoutInflater mLayoutInflater;
    private List<Income> mIncome;

    public IncomeListAdapter(Context context){
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public IncomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.recycler_view_item, parent, false);
        return new IncomeViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull IncomeViewHolder holder, int position) {

        if (mIncome != null){
            Income currentIncome = mIncome.get(position);
            holder.incomeItem.setText(currentIncome.getIncomeTitle());
            holder.tvAmount.setText((String.valueOf(currentIncome.getAmount())));
        }else {
            holder.incomeItem.setText("No data");
            holder.tvAmount.setText("No data");
        }
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
