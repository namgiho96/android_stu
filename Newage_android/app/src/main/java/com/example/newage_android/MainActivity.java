package com.example.newage_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context ctx = MainActivity.this;
        final EditText num = findViewById(R.id.num);

        class Calc{
            int num , res;
            String op;
            public void execute(){
                switch (res){


                }
            }
            int getNum(){return num;}
            void setNum(){this.num = num;}
        }
        findViewById(R.id.plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"플러스버튼 : "+num.getText().toString(),Toast.LENGTH_LONG).show();
                Log.d("입력값 : ",num.getText()+"");
                num.setText("");

            }
        });
        findViewById(R.id.minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"마이너스버튼 : "+num.getText().toString(),Toast.LENGTH_LONG).show();
                num.setText("");
            }
        });
        findViewById(R.id.multi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"곱하기버튼 : "+num.getText().toString(),Toast.LENGTH_LONG).show();
                num.setText("");

            }
        });
        findViewById(R.id.divid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"들어온값 : "+num.getText().toString(),Toast.LENGTH_LONG).show();
                num.setText("");
            }
        });

        findViewById(R.id.equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"이퀄즈 : "+num.getText().toString(),Toast.LENGTH_LONG).show();

            }
        });
        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"초기화 : "+num.getText().toString(),Toast.LENGTH_LONG).show();

            }
        });
    }
}
