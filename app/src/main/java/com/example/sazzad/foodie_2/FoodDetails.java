package com.example.sazzad.foodie_2;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class FoodDetails extends AppCompatActivity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fooddetails);
        Button b,b1;
        b=(Button) findViewById(R.id.addtocart);
        b1=(Button) findViewById(R.id.cartbutton);



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"clicked on button",Toast.LENGTH_LONG).show();
               // Intent i=new Intent(MainActivity.this,FoodDetails.class);
               // startActivity(i);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"clicked on button",Toast.LENGTH_LONG).show();
                 Intent i=new Intent(FoodDetails.this,Cart.class);
                 startActivity(i);
            }
        });
    }

}
