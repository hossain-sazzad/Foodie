package com.example.sazzad.foodie_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText name1,loc,phoneno,pass;
    Button b;
    String name,location,email,phone,password;
    private  static  final  String reg_url = "http://localhost/foodie/register.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText name1,loc,phoneno,pass;
        Button b;
        String name,location,phone,password;


        name1=(EditText) findViewById(R.id.name);
        phoneno=(EditText) findViewById(R.id.phone);
        loc=(EditText) findViewById(R.id.location);
        pass=(EditText) findViewById(R.id.password);

    }
    public void onClickReg(View v) {
        Toast.makeText(getApplicationContext(),"clicked on button",Toast.LENGTH_LONG).show();
        name=name1.getText().toString();

        location=loc.getText().toString().trim().toLowerCase();;
        phone=phoneno.getText().toString().trim().toLowerCase();;

        password=pass.getText().toString().trim().toLowerCase();;
        String method="register";

        backgroundRegisterTask background=new backgroundRegisterTask(this);
        background.execute(method,"sazzad","111","222","333","12456");
        finish();
    }
}
