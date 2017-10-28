package com.yun.app.calculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Front에서 입력받은 숫자
        final EditText num_input1 = findViewById(R.id.num_input1);
        final EditText num_input2 = findViewById(R.id.num_input2);
        //계산 후 출력값
        final TextView result_value = findViewById(R.id.result_value);
        //MainActivity 자신을 받아 객체를 만듬
        final Context ctx = MainActivity.this;

        //plus_btn에 대한 Lambda 표현식
        findViewById(R.id.plus_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Front에서 입력받은 숫자는 String타입으로 받는다.
                String sNum1 = num_input1.getText().toString();
                String sNum2 = num_input2.getText().toString();

                //String으로 받은 숫자를 int 타입으로 변환하여 준다.
               /*int num1 = Integer.parseInt(sNum1);
                int num2 = Integer.parseInt(sNum2);*/

               //계산 서비스를 실제로 실행한다.
               /* CalculatorService s = new CalculatorImpl();*/

               //공통 전역변수는 bean에 담아준다.
                CalcBean b = new CalcBean();
                //
                b.setNum1(sNum1); //bean에 입력값 sNum1을 할당
                b.setNum2(sNum2); //bean에 입력값 sNum2을 할당
                /*s.plus(b);*/

                //Plus 함수 메서드에서 bean에 입력 숫자를 할당해주고,
                //인터페이스에서 실행시킨 후, 더한 값을 String 타입으로 반환
                result = new Plus() {
                    @Override
                    public String execute(CalcBean numbers) {
                        return String.valueOf(Integer.parseInt(numbers.getNum1())
                                +Integer.parseInt(numbers.getNum2()));
                    }
                }.execute(b);

                Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.minus_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx,"click-minus dummy test",Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.multiply_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx,"click-multiply dummy test",Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.divide_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx,"click-divide dummy test",Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.equal_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_value.setText("계산 결과: "+result);
               /* Toast.makeText(ctx,"click-equal dummy test",Toast.LENGTH_LONG).show();*/
            }
        });


    }

    //interface 정의
    private interface Plus{public String execute(CalcBean numbers);}
    private interface Minus{public String execute(CalcBean numbers);}
    private interface Multiply{public String execute(CalcBean numbers);}
    private interface Devide{public String execute(CalcBean numbers);}

    //전역 변수 bean 세팅
    private class CalcBean{
        private String num1;
        private String num2;

        public String getNum1() {
            return num1;
        }

        public void setNum1(String num1) {
            this.num1 = num1;
        }

        public String getNum2() {
            return num2;
        }

        public void setNum2(String num2) {
            this.num2 = num2;
        }
    }
}
