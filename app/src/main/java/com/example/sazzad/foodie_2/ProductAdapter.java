package com.example.sazzad.foodie_2;

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

public class ProductAdapter extends BaseAdapter {

    public String[] names;
    public String[] prices;
    public int[] rates;
    public int[] images;
    public Context ct;
    private static LayoutInflater inflater=null;

    public ProductAdapter(Context m, String[] n, String[] n2,int[] n3, int[] i) {
        names = n;
        prices=n2;
        rates=n3;
        images = i;
        ct=m;
        inflater=(LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return images.length;
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
        TextView tv,b;
        Button b1;

        RatingBar r;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Myholder mh;

        mh=new Myholder();
        View myview;
        myview= inflater.inflate(R.layout.productlistview,null);
        mh.iv=(ImageView) myview.findViewById(R.id.productimage);
        mh.tv=(TextView) myview.findViewById(R.id.productprice);
        mh.b=(TextView) myview.findViewById(R.id.productname);
        mh.r=(RatingBar) myview.findViewById(R.id.productrating);
       mh.b1=(Button) myview.findViewById(R.id.details);


        mh.tv.setText("price :"+prices[position]);
        mh.iv.setImageResource(images[position]);
        mh.b.setText(names[position]);
        mh.r.setRating(rates[position]);
        myview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ct," "+ names[position],Toast.LENGTH_LONG).show();
                Intent openThree = new Intent(ct,FoodDetails.class);
                ct.startActivity(openThree);
            }
        });
        return  myview;
    }

}
