package com.example.suriyakathiresan.expensemanager;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    Intent i;
    Button b;
    //String index;
    EditText e1;
    String hint,fortoast,todisplay;
    SQLiteDatabase tables;
    Button b1,b2;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tables=openOrCreateDatabase("Income.db",Context.MODE_PRIVATE,null);
        tables.execSQL("CREATE TABLE IF NOT EXISTS Salarytable(Salary TEXT);");
        tables.execSQL("CREATE TABLE IF NOT EXISTS Parttimetable(Parttime TEXT);");
        tables.execSQL("CREATE TABLE IF NOT EXISTS Renttable(Rent TEXT);");
        tables.execSQL("CREATE TABLE IF NOT EXISTS Businesstable(Business TEXT);");
        e1=(EditText)findViewById(R.id.text1);
        b1=(Button)findViewById(R.id.appbtn1);
        b2=(Button)findViewById(R.id.appbtn2);
        i=getIntent();
        hint=i.getStringExtra("Detail");
        e1.setHint(hint);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hint.equals("Salary")){
                    tables.execSQL("INSERT INTO Salarytable VALUES('"+ e1.getText().toString()+"');");
                    fortoast="Salary detail inserted";
                }
                else if(hint.equals("Parttime")){
                    tables.execSQL("INSERT INTO Parttimetable VALUES('"+ e1.getText().toString()+"');");
                    fortoast="Parttime detail inserted";
                }
                else if(hint.equals("Rent")){
                    tables.execSQL("INSERT INTO Renttable VALUES('"+ e1.getText().toString()+"');");
                    fortoast="Rent detail inserted";
                }
                else{
                    tables.execSQL("INSERT INTO Businesstable VALUES('"+ e1.getText().toString()+"');");
                    fortoast="Business detail inserted";
                }
                Toast.makeText(getApplicationContext(),fortoast,Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(hint.equals("Salary")){
                        c = tables.rawQuery("SELECT * FROM Salarytable;",null);
                    }
                    else if(hint.equals("Parttime")){
                        c = tables.rawQuery("SELECT * FROM Parttimetable;",null);
                    }
                    else if(hint.equals("Rent")){
                        c = tables.rawQuery("SELECT * FROM Renttable;",null);
                    }
                    else{
                        c = tables.rawQuery("SELECT * FROM Businesstable;",null);
                    }
                        c.moveToFirst();
                        todisplay = c.getString(0);
                        Toast.makeText(getApplicationContext(),todisplay,Toast.LENGTH_LONG).show();
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
