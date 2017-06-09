package com.example.sazzad.foodie_2;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
   private ActionBarDrawerToggle ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView l;
        Button b,b2,b3;
        ImageButton Im;

        b3=(Button) findViewById(R.id.signup);
        b= (Button) findViewById(R.id.details);
        l=(ListView) findViewById(R.id.productList);

         dl=(DrawerLayout) findViewById(R.id.activity_main);
        ab= new ActionBarDrawerToggle(this,dl,R.string.open,R.string.close);
        dl.addDrawerListener(ab);
         ab.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




      /*  b.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Toast.makeText(getApplicationContext(),"clicked on button",Toast.LENGTH_LONG).show();
                                      Intent i=new Intent(MainActivity.this,FoodDetails.class);
                                      startActivity(i);
                                  }
                              });*/

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"clicked on button",Toast.LENGTH_LONG).show();
                Intent i=new Intent(MainActivity.this,Register.class);
                startActivity(i);
            }
        });
        String[] friends = {"food1", "food2", "food3", "food1"};
        String[] price = {"150", "205", "550", "110"};
        int[] rate = {4,5,2,3};


        int[] img = {R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food1};
       ProductAdapter a= new ProductAdapter(this,friends,price,rate,img);
        l.setAdapter(a);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(ab.onOptionsItemSelected(item))
        {
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
