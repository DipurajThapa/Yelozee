package com.yelozee.yelozee;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Dipuraj_Thapa on 8/13/2017.
 */

public class Yelozee extends Application{

   public void onCreate()
   {
       super.onCreate();
       Firebase.setAndroidContext(this);

   }

}
