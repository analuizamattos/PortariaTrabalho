package com.ninjasmockers.portaria_trabalho;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void cadastroLogin(View view){
        startActivity(new Intent(this,CadastroLogin.class));
    }

    protected void login(View view) {
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName("com.google.android.calendar", "com.android.calendar.LaunchActivity");
        intent.setComponent(componentName);
        startActivity(intent);
    }

}
