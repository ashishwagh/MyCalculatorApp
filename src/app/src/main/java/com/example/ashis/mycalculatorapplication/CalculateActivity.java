package com.example.ashis.mycalculatorapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculateActivity extends AppCompatActivity{
    // All button variables
    Button button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8,button_9,
            button_0,button_sin,button_cos,button_tan,button_add,button_sub,button_mul,button_div,
            button_ans,button_dot,button_clear;

    //Text area to display result
    EditText answertext;
    //Variables to calculate result
    float numFloat1=0,numFloat2=0;
    int numInt1=0,numInt2=0;

    boolean isAdd=false,isSub=false,isMul=false,isDiv=false,isInt=false;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_activity);

        button_0=findViewById(R.id.button_0);
        button_1=findViewById(R.id.button_1);
        button_2=findViewById(R.id.button_2);
        button_3=findViewById(R.id.button_3);
        button_4=findViewById(R.id.button_4);
        button_5=findViewById(R.id.button_5);
        button_6=findViewById(R.id.button_6);
        button_7=findViewById(R.id.button_7);
        button_8=findViewById(R.id.button_8);
        button_9=findViewById(R.id.button_9);
        button_sin=findViewById(R.id.button_sin);
        button_cos=findViewById(R.id.button_cos);
        button_tan=findViewById(R.id.button_tan);
        button_add=findViewById(R.id.button_add);
        button_sub=findViewById(R.id.button_sub);
        button_mul=findViewById(R.id.button_mul);
        button_div=findViewById(R.id.button_div);
        button_ans=findViewById(R.id.button_ans);
        button_ans=findViewById(R.id.button_ans);
        button_dot =findViewById(R.id.button_dot);
        button_clear=findViewById(R.id.button_clear);
        answertext =findViewById(R.id.answer_text);

        //On click of button 0
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answertext.setText(answertext.getText()+"0");
            }
        });

        //On click of button 1
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answertext.setText(answertext.getText()+"1");
            }
        });

        //On click of button 2
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answertext.setText(answertext.getText()+"2");
            }
        });

        //On click of button 3
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answertext.setText(answertext.getText()+"3");
            }
        });

        //On click of button 4
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answertext.setText(answertext.getText()+"4");
            }
        });

        //On click of button 5
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answertext.setText(answertext.getText()+"5");
            }
        });

        //On click of button 6
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answertext.setText(answertext.getText()+"6");
            }
        });

        //On click of button 7
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answertext.setText(answertext.getText()+"7");
            }
        });

        //On click of button 8
        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answertext.setText(answertext.getText()+"8");
            }
        });

        //On click of button 9
        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answertext.setText(answertext.getText()+"9");
            }
        });

        //On click of button dot
        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answertext.getText().toString().contains(".")){
                    answertext.setText(answertext.getText());
                }else{
                    answertext.setText(answertext.getText()+".");
                }
            }
        });

        //On click of button clear
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answertext.setText("");
            }
        });

        //On click of button add for addition
        button_add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(answertext == null){
                   answertext.setText("");
               }else{
                   numFloat1=Float.parseFloat(answertext.getText().toString());
                   if(answertext.getText().toString().contains(".")){
                       isInt=false;
                   }else{
                      isInt=true;
                   }
                   isAdd=true;
                   answertext.setText(null);
               }
           }
       });

        //On click of button sub for subtraction
        button_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answertext == null){
                    answertext.setText("");
                }else{
                    numFloat1=Float.parseFloat(answertext.getText().toString());
                    if(answertext.getText().toString().contains(".")){
                       isInt=false;
                    }else{
                        isInt=true;
                    }
                    isSub=true;
                    answertext.setText(null);
                }
            }
        });

        //On click of button div for division
        button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answertext == null){
                    answertext.setText("");
                }else{
                    numFloat1=Float.parseFloat(answertext.getText().toString());
                    if(answertext.getText().toString().contains(".")){
                       isInt=false;
                    }else{
                        isInt=true;
                    }
                    isDiv=true;
                    answertext.setText(null);
                }
            }
        });

        //On click of button mul for multiplication
        button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answertext == null){
                    answertext.setText("");
                }else{
                    numFloat1=Float.parseFloat(answertext.getText().toString());
                    if(answertext.getText().toString().contains(".")){
                        isInt=false;
                    }else{
                        isInt=true;
                    }
                    isMul=true;
                    answertext.setText(null);
                }
            }
        });

        ////On click of button equalto for showing the result
        button_ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int intResult=0;
                if(answertext==null){
                    answertext.setText("");
                }else{
                    numFloat2=Float.parseFloat(answertext.getText().toString());
                    if(answertext.getText().toString().contains(".")){
                        isInt=false;
                    }else{
                        if(isInt!=false)
                            isInt=true;
                    }
                    if(isAdd==true){
                        float result=numFloat1+numFloat2;
                        if(isInt==true) {
                            intResult = ((int) result);
                            answertext.setText(intResult + "");
                        }else
                            answertext.setText(result + "");
                        isAdd=false;
                    }
                    if(isSub==true){
                        float result=numFloat1-numFloat2;
                        if(isInt==true) {
                            intResult = ((int) result);
                            answertext.setText(intResult + "");
                        }else
                            answertext.setText(result+"");
                        isSub=false;
                    }
                    if(isMul==true){
                        float result=numFloat1*numFloat2;
                        if(isInt==true) {
                            intResult = ((int) result);
                            answertext.setText(intResult+"");
                        }else
                            answertext.setText(result+"");
                        isMul=false;
                    }
                    if(isDiv==true){
                        float result=numFloat1/numFloat2;
                        if(isInt==true) {
                            intResult = ((int) result);
                            answertext.setText(intResult+"");
                        }else
                            answertext.setText(result+"");
                        isDiv=false;
                    }
                }
            }
        });

        //On click of button sin for calculating sign value of given number
        button_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answertext == null){
                    answertext.setText("");
                }else{
                    if(answertext.getText().toString().contains(".")){
                        numFloat1=Float.parseFloat(answertext.getText().toString());
                        Double d= Double.parseDouble(new Float(numFloat1).toString());
                        answertext.setText(Math.sin(d)+"");
                    }else{
                        numInt1=Integer.parseInt(answertext.getText().toString());
                        Double d= Double.parseDouble(new Float(numInt1).toString());
                        answertext.setText(Math.sin(d)+"");
                    }
                }
            }
        });

        //On click of button cos for calculating cos value of given number
        button_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answertext == null){
                    answertext.setText("");
                }else{
                    if(answertext.getText().toString().contains(".")){
                        numFloat1=Float.parseFloat(answertext.getText().toString());
                        Double d= Double.parseDouble(new Float(numFloat1).toString());
                        answertext.setText(Math.cos(d)+"");
                    }else{
                        numInt1=Integer.parseInt(answertext.getText().toString());
                        Double d= Double.parseDouble(new Float(numInt1).toString());
                        answertext.setText(Math.cos(d)+"");
                    }
                }
            }
        });

        //On click of button tan for calculating tan value of given number
        button_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answertext == null){
                    answertext.setText("");
                }else{
                    if(answertext.getText().toString().contains(".")){
                        numFloat1=Float.parseFloat(answertext.getText().toString());
                        Double d= Double.parseDouble(new Float(numFloat1).toString());
                        answertext.setText(Math.tan(d)+"");
                    }else{
                        numInt1=Integer.parseInt(answertext.getText().toString());
                        Double d= Double.parseDouble(new Float(numInt1).toString());
                        answertext.setText(Math.tan(d)+"");
                    }
                }
            }
        });


    }
}
