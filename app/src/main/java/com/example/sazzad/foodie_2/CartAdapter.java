package com.example.sazzad.foodie_2;

/**
 * Created by sazzad on 6/3/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.RatingBar;



/**
 * Created by Lenovo on 11/28/2016.
 */

public class CartAdapter extends BaseAdapter {

    public String[] names;
    public int[] pricesperunit;
    public int[] unit;
    public int[] prices;
    public Context ct;
    private static LayoutInflater inflater=null;

    public CartAdapter(Context m, String[] n, int[] n2, int[] n3, int[] i) {
        names = n;
        pricesperunit=n2;
        unit=n3;
        prices = i;
        ct=m;
        inflater=(LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public  class Myholder{

        TextView t1,t2,t3,t4;



    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Myholder mh;

        mh=new Myholder();
        View myview;
        myview= inflater.inflate(R.layout.cartfoodlist,null);

        mh.t1=(TextView) myview.findViewById(R.id.cartfoodname);
        mh.t2=(TextView) myview.findViewById(R.id.cartfoodpriceperunit);
        mh.t3=(TextView) myview.findViewById(R.id.cartfoodunit);
        mh.t4=(TextView) myview.findViewById(R.id.cartprice);





        mh.t1.setText(names[position]);
        mh.t2.setText(pricesperunit[position]);
        mh.t3.setText(unit[position]);
        mh.t4.setText(prices[position]);


        myview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ct," "+ names[position],Toast.LENGTH_LONG).show();

            }
        });
        return  myview;
    }

}