package com.istp.operacionesbasicas;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.title_main_activity);
        setSupportActionBar(toolbar);
        /*capturamos los botones*/
        Button buttonSumar=findViewById(R.id.buttonSumar);
        buttonSumar.setOnClickListener(this);

        Button bbuttonRestar=findViewById(R.id.buttonRestar);
        bbuttonRestar.setOnClickListener(this);

        Button buttonMultiplicar=findViewById(R.id.buttonMultiplicar);
        buttonMultiplicar.setOnClickListener(this);

        Button buttonDividir=findViewById(R.id.buttonDividir);
        buttonDividir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        if(v.getId()==R.id.buttonSumar){
            intent.putExtra("operacion",SecondActivity.SUMAR);
            startActivity(intent);
        } else if(v.getId()==R.id.buttonRestar){
            intent.putExtra("operacion",SecondActivity.RESTAR);
            startActivity(intent);
        } else if(v.getId()==R.id.buttonMultiplicar){
            intent.putExtra("operacion",SecondActivity.MULTIPLICAR);
            startActivity(intent);
        } else if(v.getId()==R.id.buttonDividir){
            intent.putExtra("operacion",SecondActivity.DIVIDIR);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Nimguno", Toast.LENGTH_SHORT).show();
        }
    }
}
