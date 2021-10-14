package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button buttonac, buttondel, button1,button2,button3,button4,button5,button6,button7,
                   button8,button9,buttonplus,buttonminus,buttonmul,buttondiv,button0,buttondot,buttonsci,buttonequal;

    private TextView textresult, texthis;
    private String number = null;//nedded for after pressing the button to add the no in the screen
    double firstno =0;//performing operation
    double lastno=0;//for storing the no given by user

    String status = null;
    boolean operator = false;

    String history, currentResult;//for creating history for operation

    DecimalFormat  mformat = new DecimalFormat("######.######");//.sign length of the decimal no .before this format of no

    boolean dot = true;//for debugging dot
    boolean control = true;//for debugging after pressing ac if press delete then app closed, or deleting all element if press del button then also app closed

    boolean ee =  false;//

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        buttonac = findViewById(R.id.btac);
        buttondel = findViewById(R.id.btdel);
        button1 = findViewById(R.id.bt1);
        button2 = findViewById(R.id.bt2);
        button3 = findViewById(R.id.bt3);
        button4 = findViewById(R.id.bt4);
        button5 = findViewById(R.id.bt5);
        button6 = findViewById(R.id.bt6);
        button7 = findViewById(R.id.bt7);
        button8 = findViewById(R.id.bt8);
        button9= findViewById(R.id.bt9);
        button0 = findViewById(R.id.bt0);
        buttonmul = findViewById(R.id.btmul);
        buttondiv= findViewById(R.id.btdiv);
        buttonplus= findViewById(R.id.btplus);
        buttonminus= findViewById(R.id.btneg);
        buttonplus= findViewById(R.id.btplus);
        buttonminus= findViewById(R.id.btneg);
        buttonequal= findViewById(R.id.btequal);
        buttonsci= findViewById(R.id.btsci);
        buttondot = findViewById(R.id.btdot);

        textresult= findViewById(R.id.t2);
        texthis = findViewById(R.id.t1);


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("0");//if press then view 0

            }
        });
        //same for other button
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("1");//if press then view 0

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("2");//if press then view 0

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("3");//if press then view 0

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("4");//if press then view 0

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("5");//if press then view 0

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("6");//if press then view 0

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("7");//if press then view 0

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("8");//if press then view 0

            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("9");//if press then view 0

            }
        });

        buttonac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = null;//pressing ac button make the text view 0 and first no and last no 0
                status = null;
                textresult.setText("0");
                texthis.setText("");
                firstno = 0;
                lastno = 0;
                dot = true;
                control = true;

            }
        });
        buttondel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(control)//for debugging
                {
                    textresult.setText("0");
                }
                else
                {
                    number = number.substring(0,number.length()-1);//for deleting no  we use substring method;
                    if(number.length() == 0)//if the length 0 then make the button false for avoid debugging error
                    {
                        buttondel.setClickable(false);
                    }
                    else if(number.contains("."))//we see that if we delete the dot after that if we prees dot again then it not printed in screen.so for this else if condition
                    {
                        dot = false;
                    }
                    else
                    {
                        dot = true;
                    }
                    textresult.setText(number);
                }




            }
        });
        buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               //printing operation in history section
                history = texthis.getText().toString();
                currentResult = textresult.getText().toString();
                texthis.setText(history+currentResult+"+");


                if(operator)
                {
                    if(status == "multiplication")
                    {
                        multiply();
                    }
                    else if(status == "division")
                    {
                        divide();
                    }
                    else if(status == "subtraction")
                    {
                        minus();
                    }
                    else
                    {
                        add();
                    }
                }
                status = "sum";
                operator = false;
                number = null;



            }
        });
        buttonminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //printing operation in history section
                history = texthis.getText().toString();
                currentResult = textresult.getText().toString();
                texthis.setText(history+currentResult+"-");

                if(operator)
                {
                    if(status == "multiplication")
                    {
                        multiply();
                    }
                    else if(status == "division")
                    {
                        divide();
                    }
                    else if(status == "sum")
                    {
                        add();
                    }
                    else
                    {
                        minus();
                    }
                }
                status = "subtraction";
                operator = false;
                number = null;


            }
        });
        buttonmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //printing operation in history section
                history = texthis.getText().toString();
                currentResult = textresult.getText().toString();
                texthis.setText(history+currentResult+"*");

                if(operator)
                {
                    if(status == "sum")
                    {
                        add();
                    }
                    else if(status == "division")
                    {
                        divide();
                    }
                    else if(status == "subtraction")
                    {
                        minus();
                    }
                    else
                    {
                        multiply();
                    }
                }
                status = "multiplication";
                operator = false;
                number = null;

            }
        });
        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //printing operation in history section
                history = texthis.getText().toString();
                currentResult = textresult.getText().toString();
                texthis.setText(history+currentResult+"/");

                if(operator)
                {
                    if(status == "multiplication")
                    {
                        multiply();
                    }
                    else if(status == "subtraction")
                    {
                        minus();
                    }
                    else if(status == "sum")
                    {
                        add();
                    }
                    else
                    {
                        divide();
                    }
                }
                status = "division";
                operator = false;
                number = null;



            }
        });
        buttonequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operator)
                {
                    if(status == "sum")
                    {
                        add();
                    }
                    else if(status == "subtraction")
                    {
                        minus();
                    }
                    else if(status == "multiplication")
                    {
                        multiply();
                    }
                    else if(status == "division")
                    {
                        divide();
                    }
                    else
                    {
                        firstno = Double.parseDouble(textresult.getText().toString());
                    }
                }
                operator = false;
                ee = true;//debugging equal

            }
        });
        buttondot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dot)
                {
                    if(number == null)
                    {
                        number = "0.";
                    }
                    else
                    {
                        number = number + ".";
                    }
                }


                textresult.setText(number);
                dot = false;
            }
        });




    }
    public void numberClick(String view)//number click method use for the number printed on the screen
    {
        if(number == null)
        {
            number = view;
        }
        else if(ee)//debugging equal
        {
            firstno =0;
            lastno = 0;
            number = view;
        }
        else
        {
            number = number+view;
        }
        textresult.setText(number);
        operator = true;//make it true
        control = false;
        buttondel.setClickable(true);
        ee = false;

    }
    public void add()//for adding create this method
    {
        lastno = Double.parseDouble(textresult.getText().toString());
        firstno = firstno+lastno;
        textresult.setText(mformat.format(firstno));
        dot = true;//for debugging dot

    }
    public void minus()//for minus create this method
    {
        if(firstno == 0)
        {
            firstno = Double.parseDouble(textresult.getText().toString());
        }
        else
        {
            lastno = Double.parseDouble(textresult.getText().toString());
            firstno = firstno-lastno;
        }
        textresult.setText(mformat.format(firstno));
        dot = true;//for debugging dot

    }
    public void multiply()//multipliying
    {
        if(firstno == 0)
        {
            firstno = 1;
            lastno = Double.parseDouble(textresult.getText().toString());
            firstno = firstno*lastno;
        }
        else
        {
            lastno = Double.parseDouble(textresult.getText().toString());
            firstno = firstno*lastno;
        }
        textresult.setText(mformat.format(firstno));
        dot = true;//for debugging dot
    }
    public void divide()
    {
        if(firstno == 0)
        {
            lastno = Double.parseDouble(textresult.getText().toString());
            firstno = lastno/1;
        }
        else
        {
            lastno = Double.parseDouble(textresult.getText().toString());
            firstno = firstno/lastno;
        }
        textresult.setText(mformat.format(firstno));
        dot = true;//for debugging dot
    }

}