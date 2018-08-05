package org.az20.expendituretracker.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.az20.expendituretracker.R;
import org.az20.expendituretracker.adapters.IncomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class CategoriesFragment extends Fragment {

    RecyclerView categoryRecyclerView;
//    LinearLayout categoryChart;

//    private static int[] COLORS = new int[] { Color.GREEN, Color.BLUE,Color.MAGENTA, Color.CYAN, Color.RED, Color.YELLOW, Color.GRAY };
//    private static double[] VALUES = new double[] { 10, 11, 12, 13 };
//    private static String[] NAME_LIST = new String[] { "A", "B", "C", "D" };
//    private CategorySeries mSeries = new CategorySeries("");
//    private DefaultRenderer mRenderer = new DefaultRenderer();
//    private GraphicalView mChartView;

    private IncomeAdapter adapter;


    com.github.mikephil.charting.charts.PieChart mChart;

    public CategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        mChart = view.findViewById(R.id.pie_chart);

        mChart.setDrawEntryLabels(true);
        mChart.getDescription().setEnabled(false);
        mChart.setExtraOffsets(5, 10, 5, 5);
        mChart.setDragDecelerationFrictionCoef(0.95f);
        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.WHITE);

        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);

        mChart.setHoleRadius(38f);
        mChart.setTransparentCircleRadius(41f);
        mChart.setDrawCenterText(true);
        mChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        mChart.setRotationEnabled(true);
        mChart.setHighlightPerTapEnabled(true);

        setData();

        // entry label styling
        mChart.setEntryLabelColor(Color.BLACK);
        mChart.setEntryLabelTextSize(12f);

        return view;
    }

    private List<IncomeStub> getAllIncome() {
        List<IncomeStub> newList = new ArrayList<>();
        newList.add(new IncomeStub("Salary", "$200.00"));
        newList.add(new IncomeStub("Mobile money", "$55.00"));
        newList.add(new IncomeStub("Dad", "$90.00"));
        newList.add(new IncomeStub("Eric reimbursement", "$20.00"));
        newList.add(new IncomeStub("Crypto benefit", "$300.00"));
        newList.add(new IncomeStub("Salary", "$200.00"));
        return newList;
    }

    private void setData() {
        String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep"};
        ArrayList<PieEntry> entries = new ArrayList<>();
        for(int i=0; i< months.length; i++) {
            entries.add(new PieEntry((i * 10) + 10, months[i]));
        }

        PieDataSet dataSet = new PieDataSet(entries, "");

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);
        mChart.setData(data);

        // undo all highlights
        mChart.highlightValues(null);

        mChart.invalidate();
    }

}
