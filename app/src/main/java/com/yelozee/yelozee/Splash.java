package com.yelozee.yelozee;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static java.lang.Thread.sleep;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread myThread = new Thread(){
            public void run(){

                try{

                    sleep(3000);
                    Intent intent= new Intent(getApplicationContext(),Register.class);
                    startActivity(intent);
                    finish();
                }
                catch(Exception e){
                    e.printStackTrace();

                }

            }


        };myThread.start();


    }
}
//https://github.com/DipurajThapa/Yelozee/invitations