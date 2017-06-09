package com.example.sazzad.foodie_2;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Cart extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ListView l;
        l=(ListView) findViewById(R.id.cartlist);
        Button b;
        b=(Button) findViewById(R.id.completeorderbutton);

        dl=(DrawerLayout) findViewById(R.id.activity_cart);
        ab= new ActionBarDrawerToggle(this,dl,R.string.open,R.string.close);
        dl.addDrawerListener(ab);
        ab.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String[]  names={"aaa","bbb","ccc","ddd"};

        String[]  names2={"100","200","300","400"};
        int[] ppu={100,200,300,400};
        String[] unit={"4","3","2","1"};
        //int[] prices = new int[names.length];
       String[] prices={"400","400", "400","400"};
       /* for(int i=0;i<names.length;i++)
        {
            prices[i]=unit[i]*ppu[i];
        }*/
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"clicked on button",Toast.LENGTH_LONG).show();
                Intent i=new Intent(Cart.this,CompleteOrder.class);
                startActivity(i);
            }
        });

        CartAdapter2 a= new CartAdapter2(this,names,names2,unit,prices);
        l.setAdapter(a);


    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(ab.onOptionsItemSelected(item))
        {
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
