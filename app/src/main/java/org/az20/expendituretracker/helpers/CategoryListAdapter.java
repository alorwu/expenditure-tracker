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
        //Replace layout with corresponding recycler view layout
        View mView = mLayoutInflater.inflate(R.layout.fragment_home, parent, false);
        return new CategoryViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        // Bind holder to views. Income title and amount

    }

    @Override
    public int getItemCount() {
        if (mCategory != null)
            return mCategory.size();
        else return 0;
    }

    public void setCategory(List<Category> category){
        mCategory = category;
        notifyDataSetChanged();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        private CategoryViewHolder(View itemView){
            super(itemView);
        }
    }
}
