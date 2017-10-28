package com.yun.app.calculator;

/**
 * Created by 1027 on 2017-10-28.
 */

public class CalculatorImpl implements CalculatorService{


    @Override
    public String plus(CalculatorBean numbers) {
         return String.valueOf(Integer.parseInt(numbers.getNum1())
                +Integer.parseInt(numbers.getNum2()));
    }

    @Override
    public String minus(CalculatorBean numbers) {
        return String.valueOf(Integer.parseInt(numbers.getNum1())
                -Integer.parseInt(numbers.getNum2()));
    }

    @Override
    public String multiply(CalculatorBean numbers) {
        return String.valueOf(Integer.parseInt(numbers.getNum1())
               *Integer.parseInt(numbers.getNum2()));
    }

    @Override
    public String devide(CalculatorBean numbers) {
        return String.valueOf(Integer.parseInt(numbers.getNum1())
               /Integer.parseInt(numbers.getNum2()));
    }
}
