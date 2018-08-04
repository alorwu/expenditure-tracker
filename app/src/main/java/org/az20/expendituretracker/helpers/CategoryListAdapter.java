package org.az20.expendituretracker.helpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.az20.expendituretracker.R;
import org.az20.expendituretracker.database.Category;
import org.az20.expendituretracker.database.Income;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private List<Category> mCategory;

    public CategoryListAdapter(Context context){
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = mLayoutInflater.inflate(R.layout.recycler_view_item, parent, false);
        return new CategoryViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        if (mCategory != null){
            Category currentCategory = mCategory.get(position);
            holder.incomeItem.setText(currentCategory.getCatTitle());
            holder.tvAmount.setText((String.valueOf(currentCategory.getCatAmount())));
        }else {
            holder.incomeItem.setText(R.string.no_data);
            holder.tvAmount.setText(R.string.no_data);
        }

    }

    @Override
    public int getItemCount() {
        if (mCategory != null)
            return mCategory.size();
        else return 0;
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        private final TextView incomeItem, tvAmount;

        private CategoryViewHolder(View itemView){
            super(itemView);
            incomeItem = itemView.findViewById(R.id.tv_title);
            tvAmount = itemView.findViewById(R.id.tv_amount);
        }
    }
}
