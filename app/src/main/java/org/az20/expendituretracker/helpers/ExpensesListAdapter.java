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

        View mView = mLayoutInflater.inflate(R.layout.recycler_view_item, parent, false);
        return new ExpensesViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpensesViewHolder holder, int position) {

        if (mExpenses != null){
            Expenses currentExpenses = mExpenses.get(position);
            holder.incomeItem.setText(currentExpenses.getExpensesTitle());
            holder.tvAmount.setText((String.valueOf(currentExpenses.getExpensesAmount())));
        }else {
            holder.incomeItem.setText(R.string.no_data);
            holder.tvAmount.setText(R.string.no_data);
        }
    }

    @Override
    public int getItemCount() {
        if (mExpenses != null)
            return mExpenses.size();
        else return 0;
    }

    class ExpensesViewHolder extends RecyclerView.ViewHolder{
        private final TextView incomeItem, tvAmount;

        public ExpensesViewHolder(View itemView) {
            super(itemView);
            incomeItem = itemView.findViewById(R.id.tv_title);
            tvAmount = itemView.findViewById(R.id.tv_amount);
        }
    }
}
