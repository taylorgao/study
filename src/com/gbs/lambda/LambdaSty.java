package com.gbs.lambda;

public class LambdaSty  {
    public static void main(String[] args){
        MathOperation Addition = (a,b)->a + b;
        MathOperation Multiplitation = (int a,int b)->{return a * b;};

        int rtn = Multiplitation.operation(3,2);
        System.out.println(rtn);

    }

    interface MathOperation{
        int operation(int a,int b);
    }

}

