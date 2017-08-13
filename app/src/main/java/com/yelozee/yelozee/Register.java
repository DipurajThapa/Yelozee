package com.yelozee.yelozee;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class Register extends AppCompatActivity {

    private Button register;
    private EditText email,password;
    private Firebase mRootRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Firebase.setAndroidContext(this);

        mRootRef=new Firebase("https://yelozee-93fc0.firebaseio.com/Users");

        register= (Button)findViewById(R.id.register);
        email= (EditText)findViewById(R.id.email);
        password= (EditText)findViewById(R.id.password);


        register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                String em= email.getText().toString();
                Firebase childRef= mRootRef.child("Email");
                childRef.setValue(em);

                String pass=password.getText().toString();
                Firebase childRefPass= mRootRef.child("Password");
                childRefPass.setValue(pass);
               // Firebase mRefChild= mRef.child("Kaushambi");
               // mRefChild.setValue("dfgdfg");
            }

        });
        Firebase obj= new Firebase("https://yelozee-93fc0.firebaseio.com/Users/Email");
        obj.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value= dataSnapshot.getValue(String.class);
                Toast.makeText(Register.this, value, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



    }
}
