package org.az20.expendituretracker.home;

import android.app.PendingIntent;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.az20.expendituretracker.R;

import java.util.List;

public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.IncomeViewHolder> {

    List<IncomeStub> incomeStubList;
    IncomeStub incomeStub;
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
        incomeStub = incomeStubList.get(holder.getAdapterPosition());

        if(incomeStub != null) {
            holder.incomeDescription.setText(incomeStub.getName());
            holder.amount.setText(incomeStub.getAmount());
            holder.firstLetter.setText(getFirstLetter(incomeStub.getName()));
        }
    }

    @Override
    public int getItemCount() {
        return incomeStubList == null ? 0 : incomeStubList.size();
    }

    private String getFirstLetter(String name) {
        return String.valueOf(name.charAt(0));
    }

    public void setIncomeStubList(List<IncomeStub> stubs) {
        this.incomeStubList = stubs;
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
