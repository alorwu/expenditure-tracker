package org.az20.expendituretracker.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.az20.expendituretracker.R;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ExpenseViewHolder> {
    List<CategoryStub> categoryStubList;
    CategoryStub categoryStub;
    Context mContext;

    public CategoryAdapter(Context context) {
        this.mContext = context;
    }
    @NonNull
    @Override
    public CategoryAdapter.ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expenditure_recyclerview_item, parent, false);
        return new ExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        categoryStub = categoryStubList.get(holder.getAdapterPosition());

        if(categoryStub != null) {
            holder.expenseName.setText(categoryStub.getName());
            holder.budgetSpent.setText(categoryStub.getSpentBudget());
            holder.actualBudget.setText(categoryStub.getActualBudget());
            holder.remaining.setText(remainingBudget(categoryStub.getActualBudget(), categoryStub.getSpentBudget()));
            holder.progressBar.setProgress(progressPercent(categoryStub.getActualBudget(), categoryStub.getSpentBudget()));
        }
    }

    private String remainingBudget(String actual, String spent) {
        return String.valueOf(Integer.parseInt(actual) - Integer.parseInt(spent));
    }

    private int progressPercent(String actual, String spent) {
        return (int) ((Double.parseDouble(spent) / Double.parseDouble(actual)) * 100);
    }

    @Override
    public int getItemCount() {
        if(categoryStubList != null) return categoryStubList.size();
        else return 0;
    }

    public void setCategories(List<CategoryStub> categoryStubs) {
        this.categoryStubList = categoryStubs;
        notifyDataSetChanged();
    }

    class ExpenseViewHolder extends RecyclerView.ViewHolder {
        TextView expenseName, budgetSpent, actualBudget, remaining;
        ContentLoadingProgressBar progressBar;

        ExpenseViewHolder(View view) {
            super(view);
            expenseName = view.findViewById(R.id.expense_name);
            budgetSpent = view.findViewById(R.id.budget_spent);
            actualBudget = view.findViewById(R.id.actual_budget);
            remaining = view.findViewById(R.id.remaining);
            progressBar = view.findViewById(R.id.expense_progress);
        }
    }
}
