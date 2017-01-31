package com.example.suriyakathiresan.expensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class EditActivity extends AppCompatActivity {

    Button e1,e2,e3,e4;
    Intent i;
    String editname;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        e1=(Button)findViewById(R.id.ed2);
        e2=(Button)findViewById(R.id.ed3);
        e3=(Button)findViewById(R.id.ed4);
        e4=(Button)findViewById(R.id.ed5);

    }
    public void onClick(View v) {
        int edid = v.getId();
        switch (edid) {
            case R.id.ed2:
                editname = e1.getText().toString();
                break;
            case R.id.ed3:
                editname = e2.getText().toString();
                break;
            case R.id.ed4:
                editname = e3.getText().toString();
                break;
            case R.id.ed5:
                editname = e4.getText().toString();
                break;
        }
            i = new Intent(EditActivity.this,EditInsertActivity.class);
            i.putExtra("Edit", editname);
            startActivity(i);
        }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    }
