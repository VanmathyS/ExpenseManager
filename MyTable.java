package com.benoitletondor.easybudgetapp.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.benoitletondor.easybudgetapp.R;
import com.benoitletondor.easybudgetapp.model.Expense;

import java.util.Date;
import java.util.List;


public class MyTable extends DBActivity {
    /** Called when the activity is first created. */
    TableLayout country_table;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        country_table=(TableLayout)findViewById(R.id.country_table);
        fillCountryTable();
    }
    void fillCountryTable() {
 
        TableRow row;
        TextView t1, t2, t3;
        //Converting to dip unit
        int dip = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                (float) 1, getResources().getDisplayMetrics());

        List<Expense> lst = db.getAllExpenses();

        //for (int current = 0; current < CountriesList.abbreviations.length; current++) {
        for(Expense exp:lst){
            row = new TableRow(this);

            if(exp.getAmount()>0) {
                t1 = new TextView(this);
                t1.setTextColor(getResources().getColor(R.color.budget_green));
                t2 = new TextView(this);
                t2.setTextColor(getResources().getColor(R.color.budget_green));
                t3 = new TextView(this);
                t3.setTextColor(getResources().getColor(R.color.budget_green));
            }
            else
            {
                t1 = new TextView(this);
                t1.setTextColor(getResources().getColor(R.color.budget_red));
                t2 = new TextView(this);
                t2.setTextColor(getResources().getColor(R.color.budget_red));
                t3 = new TextView(this);
                t3.setTextColor(getResources().getColor(R.color.budget_red));
            }
            t1.setText(exp.getTitle());
            t2.setText(String.valueOf(exp.getAmount()));

            t3.setText(DateFormat.format("yyyy-MM-dd", exp.getDate()).toString());
 
            t1.setTypeface(null, 1);
            t2.setTypeface(null, 1);
            t3.setTypeface(null, 1);
 
            t1.setTextSize(15);
            t2.setTextSize(15);
            t3.setTextSize(15);
 
            t1.setWidth(50 * dip);
            t2.setWidth(100 * dip);
            t2.setWidth(100 * dip);
            t1.setPadding(20*dip, 0, 0, 0);
            row.addView(t1);
            row.addView(t2);
            row.addView(t3);
 
            country_table.addView(row, new TableLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
 
        }
    }
}