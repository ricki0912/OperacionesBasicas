package com.istp.operacionesbasicas;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity  {
    public static final int SUMAR=1;
    public static final int RESTAR=2;
    public static final int MULTIPLICAR=3;
    public static final int DIVIDIR=4;

    LinearLayout liniarLayoutResult=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
         liniarLayoutResult=findViewById(R.id.liniarLayoutResult);
        Button buttonRegresar=findViewById(R.id.buttonRegresar);
        buttonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
         initView();
    }

    public void initView(){
        int operacion= getIntent().getExtras().getInt("operacion");

        if(operacion==SecondActivity.SUMAR){
            getSupportActionBar().setTitle("Suma");
        }else if(operacion==SecondActivity.RESTAR){
            getSupportActionBar().setTitle("Resta");
        }else if(operacion==SecondActivity.MULTIPLICAR){
            getSupportActionBar().setTitle("Multiplicación");
        } else if(operacion==SecondActivity.DIVIDIR){
            getSupportActionBar().setTitle("División");
        }

        /*En esta parte define los intervalos */
        int minValor=0;
        int maxValor=12;

        for(int i=minValor;i<=maxValor;i++){
            View dividir=new View(this);
            dividir.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2));
            dividir.setBackgroundResource(R.color.colorPrimary);
            liniarLayoutResult.addView(dividir);

            TextView title=new TextView(this);
            title.setText("Tabla de "+i);
            title.setGravity(Gravity.CENTER);
            title.setTextSize(25);
            title.setTypeface(title.getTypeface(), Typeface.BOLD);

            liniarLayoutResult.addView(title);

            for(int j=minValor;j<=maxValor;j++){
                TextView item=new TextView(this);
                if(operacion==SecondActivity.SUMAR){

                    item.setText(i+" + "+j+" = "+(i+j));

                }else if(operacion==SecondActivity.RESTAR){
                    item.setText((j+i)+" - "+i+" = "+((j+i)-i));
                }else if(operacion==SecondActivity.MULTIPLICAR){
                    item.setText(i+" x "+j+" = "+(i*j));
                } else if(operacion==SecondActivity.DIVIDIR){
                    /*LOS DOS IFS INTERNOS ES UNA MALA PRACTICA, SOLO SE UTILIZO PARA ESTE CASO PRACTICO                                                                                                                                                  */
                    if(i ==0 && j==0){
                        item.setTextSize(18);
                        item.setText("No se puede dividir por 0");
                        liniarLayoutResult.addView(item);
                    }
                    if(i ==0){
                        continue;
                    }
                    item.setText((i*j+" / "+i+" = "+j));
                }


                item.setTextSize(20);
                liniarLayoutResult.addView(item);
            }


        }

    }


}
