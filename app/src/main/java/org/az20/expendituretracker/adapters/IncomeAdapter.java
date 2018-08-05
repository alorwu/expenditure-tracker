package org.az20.expendituretracker.adapters;

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

public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.IncomeViewHolder> {

    List<Income> incomeList;
    Income income;
    Context mContext;

    public IncomeAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public IncomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.income_recyclerview_item, parent, false);
        return new IncomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IncomeViewHolder holder, int position) {
        income = incomeList.get(holder.getAdapterPosition());

        if(income != null) {
            holder.incomeDescription.setText(income.getIncomeTitle());
            holder.amount.setText(String.valueOf(income.getAmount()));
            holder.firstLetter.setText(getFirstLetter(income.getIncomeTitle()));
        }
    }

    @Override
    public int getItemCount() {
        return incomeList == null ? 0 : incomeList.size();
    }

    private String getFirstLetter(String name) {
        return String.valueOf(name.charAt(0));
    }

    public void setIncomeList(List<Income> list) {
        this.incomeList = list;
        notifyDataSetChanged();
    }

    class IncomeViewHolder extends RecyclerView.ViewHolder {
        TextView incomeDescription, firstLetter, amount;
        IncomeViewHolder(View view) {
            super(view);
            incomeDescription = view.findViewById(R.id.income_description);
            firstLetter = view.findViewById(R.id.first_letter);
            amount = view.findViewById(R.id.amount);
        }
    }
}
