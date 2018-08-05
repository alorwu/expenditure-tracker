package org.az20.expendituretracker.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.az20.expendituretracker.R;
import org.az20.expendituretracker.database.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ExpenseViewHolder> {
    List<Category> categoryList;
    Category category;
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
        category = categoryList.get(holder.getAdapterPosition());

        if(category != null) {
            holder.expenseName.setText(category.getCatTitle());
            holder.budgetSpent.setText(String.valueOf(category.getSpentAmount()));
            holder.actualBudget.setText(String.valueOf(category.getCatAmount()));
            holder.remaining.setText(remainingBudget(category.getCatAmount(), category.getSpentAmount()));
            holder.progressBar.setProgress(progressPercent(category.getCatAmount(), category.getSpentAmount()));
        }
    }

    private String remainingBudget(int actual, int spent) {
        return String.valueOf(actual - spent);
    }

    private int progressPercent(double actual, double spent) {
        return (int) ((spent / actual) * 100);
    }

    @Override
    public int getItemCount() {
        if(categoryList != null) return categoryList.size();
        else return 0;
    }

    public void setCategories(List<Category> categories) {
        this.categoryList = categories;
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
