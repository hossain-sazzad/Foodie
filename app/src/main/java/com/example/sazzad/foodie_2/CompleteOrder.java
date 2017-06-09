package com.example.sazzad.foodie_2;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class CompleteOrder extends AppCompatActivity {

    private DrawerLayout dl2;
    private ActionBarDrawerToggle ab2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_order);
        Spinner s1,s2,s3;
        s1=(Spinner) findViewById(R.id.spinner1);
        s2=(Spinner) findViewById(R.id.spinner2);
        Button b= (Button) findViewById(R.id.submitOrderButton);

  dl2=(DrawerLayout) findViewById(R.id.activity_complete_order);
        ab2= new ActionBarDrawerToggle(this,dl2,R.string.open,R.string.close);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Order submitted",Toast.LENGTH_LONG).show();

            }
        });
 dl2.addDrawerListener(ab2);
        ab2.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ArrayAdapter<String> adap1= new ArrayAdapter<String>
                (CompleteOrder.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.city));
        adap1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adap1);

        ArrayAdapter<String> adap2= new ArrayAdapter<String>
                (CompleteOrder.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.locationDhaka));
        adap2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adap2);

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(ab2.onOptionsItemSelected(item))
        {
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    }

