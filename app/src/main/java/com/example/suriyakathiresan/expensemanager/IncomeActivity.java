package com.example.suriyakathiresan.expensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class IncomeActivity extends AppCompatActivity implements View.OnClickListener{
    Button b1,b2,b3,b4,b5;
    Intent i;
    String btnname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        b1=(Button)findViewById(R.id.bt1);
        b2=(Button)findViewById(R.id.bt2);
        b3=(Button)findViewById(R.id.bt3);
        b4=(Button)findViewById(R.id.bt4);
        b5=(Button)findViewById(R.id.ed1);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(IncomeActivity.this,EditActivity.class);
                startActivity(i1);
            }
        });
    }


    public void onClick(View v){
       int btid=v.getId();
        switch(btid){
            case R.id.bt1:
                btnname=b1.getText().toString();
                break;
            case R.id.bt2:
                btnname=b2.getText().toString();
                break;
            case R.id.bt3:
                btnname=b3.getText().toString();
                break;
            case R.id.bt4:
                btnname=b4.getText().toString();
                break;
        }
        i = new Intent(IncomeActivity.this,InsertActivity.class);
        i.putExtra("Detail",btnname);
        startActivity(i);
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
