package com.example.buddies.questionaddingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class gkquestions extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5;
    Button b1;
    DatabaseReference mques,mq;
    int a=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gkquestions);
        t1=(TextView)findViewById(R.id.editText1);
        t2=(TextView)findViewById(R.id.editText02);
        t3=(TextView)findViewById(R.id.editText03);
        t4=(TextView)findViewById(R.id.editText04);
        t5=(TextView)findViewById(R.id.editText05);
        b1=(Button)findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1,s2,s3,s4,s5;
                s1 = t1.getText().toString();
                s2 = t2.getText().toString();
                s3 = t3.getText().toString();
                s4 = t4.getText().toString();
                s5 = t5.getText().toString();
                mques= FirebaseDatabase.getInstance().getReference().child("General Knowledge");
                mq= mques.child(""+a);
                mq.child("Question").setValue(s1);
                mq.child("Choice1").setValue(s2);
                mq.child("Choice2").setValue(s3);
                mq.child("Choice3").setValue(s4);
                mq.child("Answer").setValue(s5);
                a++;
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                Toast.makeText(gkquestions.this,"Question Added Successfully to the Firebase Database!",Toast.LENGTH_LONG).show();


            }
        });

    }
}
