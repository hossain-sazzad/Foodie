package com.example.sazzad.foodie_2;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;



import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;
import android.app.ProgressDialog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.cert.Certificate;
import java.sql.SQLOutput;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

/**
 * Created by Lenovo on 12/6/2016.
 */

public class backgroundRegisterTask extends AsyncTask<String,Void,String>
{
    Context ctx;
    AlertDialog alertDialog=null;
    ProgressDialog loading;
    backgroundRegisterTask(Context ctx)
    {
        this.ctx=ctx;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        alertDialog=new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("login information");
        //loading = ProgressDialog.show(ctx, "Please Wait",null, true, true);
    }

    @Override
    protected String doInBackground(String... params) {

        String reg_url = "http://10.0.2.2/webapp/register.php";
        String login_url = "http://10.0.2.2/webapp/login.php";

        String method = params[0];


        if (method.equals("register")) {
            String name = params[1];

            String phone = params[2];
            String location = params[3];

            String password = params[4];

            System.out.println("In task " + name + location + phone + password);
            // URL url=null;
            //HttpURLConnection httpURLConnection=null;
            //BufferedWriter bufferedWriter=null;
            //OutputStream os=null;

            try {


                URL url = new URL(reg_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                System.out.println("okk url");
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));



                String data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"+
                        URLEncoder.encode("location","UTF-8")+"="+URLEncoder.encode(location,"UTF-8")+"&"+

                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                System.out.println(data);
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                System.out.println("okk bakita");
                InputStream is = httpURLConnection.getInputStream();

                BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(is,"UTF-8"));
                bufferedReader.close();

                return "registered....";

            }

            catch (MalformedURLException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();
            }

        }
          /*  BufferedReader bufferedReader = null;

            URL url = null;
            System.out.println("okk url");
            try {
                url = new URL(reg_url);
            } catch (MalformedURLException e) {

                e.printStackTrace();
            }

            HttpURLConnection con = null;
            try {
                con = (HttpURLConnection) url.openConnection();
                System.out.println("okk connec");
            } catch (IOException e) {

                e.printStackTrace();
            }
            try{
                con.setRequestMethod("POST");
                con.setDoOutput(true);
                OutputStream os= con.getOutputStream();
                BufferedWriter bufferedWriter= new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+URLEncoder.encode("location","UTF-8")+"="+URLEncoder.encode(location,"UTF-8")+"&"+URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"+URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));

                String result;

                result = bufferedReader.readLine();
                System.out.println("okk url");

                return result;
            }
            catch (Exception e) {


                return null;
            }


        }*/
        else{
            String name = params[1];

            String password = params[2];

            System.out.println("In login " + name + password);


            try {

                BufferedReader bufferedReader=null;
                URL url = new URL(login_url);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                System.out.println("okk url");
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter  bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));


                String data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+

                        URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");
                System.out.println(data);
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream is = httpURLConnection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                String response = "";
                String line = "";
                while((line=bufferedReader.readLine())!=null)
                {
                    response+=line;
                }
                System.out.println("Response : "+response);
                is.close();
                bufferedReader.close();
                httpURLConnection.disconnect();
                return response;
            }

            catch (MalformedURLException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        return null;

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String st) {
        //Toast.makeText(ctx,s,Toast.LENGTH_LONG).show();
        super.onPostExecute(st);
//            loading.dismiss();
        System.out.println(st);
      /*  if(st.contains("login success...welcome")){

            Intent i;
            i = new Intent(ctx,MainActivity.class);
            ctx.startActivity(i);

            Toast.makeText(ctx.getApplicationContext(),st,Toast.LENGTH_LONG).show();}
        else
        {
            alertDialog.setTitle(st);
            //  alertDialog.show();
            Toast.makeText(ctx.getApplicationContext(),"Login failed...try again",Toast.LENGTH_LONG).show();

        }*/
    }
}

