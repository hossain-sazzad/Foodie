package com.example.sazzad.foodie_2;

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



/**
 * Created by sazzad on 6/1/2017.
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

public class CartAdapter2 extends BaseAdapter {

    public String[] names;
    public String[] unit;
    public String[] priceperunit;
    public String[] prices;
    public Context ct;

    private static LayoutInflater inflater=null;

    public CartAdapter2(Context m, String[] n, String[] n2,String[] n3, String[] i) {
        names = n;
        unit=n2;
        priceperunit=n3;
        prices = i;
        ct=m;
        inflater=(LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return names.length;
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
        ImageView iv;
        TextView t1,t2,t3,t4,b;
        Button b1;

        RatingBar r;
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
        mh.t2.setText(unit[position]);
       mh.t3.setText(priceperunit[position]);
        mh.t4.setText(prices[position]);
       /* mh.iv.setImageResource(images[position]);
        mh.b.setText(names[position]);
        mh.r.setRating(rates[position]);
        myview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ct," "+ names[position],Toast.LENGTH_LONG).show();
                Intent openThree = new Intent(ct,FoodDetails.class);
                ct.startActivity(openThree);
            }
        });*/
        return  myview;
    }

}
