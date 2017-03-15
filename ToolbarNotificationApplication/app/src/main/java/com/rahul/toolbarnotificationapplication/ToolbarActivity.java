package com.rahul.toolbarnotificationapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ToolbarActivity extends AppCompatActivity implements View.OnClickListener {
    //Creates an Object of NotificationMenuItem
    private NotificationMenuItem notificationMenuItem =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        //Button to Increment Notification Count
        Button Increment= (Button) findViewById(R.id.btn_increment);
        //Button to Decrement Notification Count
        Button Decrement= (Button) findViewById(R.id.btn_decrement);
        //Setting onClick Event Listeners to the buttons
        Increment.setOnClickListener(this);
        Decrement.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        MenuItem cartItem = menu.findItem(R.id.cart);
        notificationMenuItem =new NotificationMenuItem(this, cartItem,R.drawable.ic_shopping_cart_white_24dp);
        return true;
    }


    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.btn_increment:
               notificationMenuItem.incrementCount();
               break;
           case R.id.btn_decrement:
               notificationMenuItem.decrementCount();
               break;
       }
    }
}
