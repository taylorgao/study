package com.gbs.lambda;

public class LambdaSty  {
    public static void main(String[] args){
        MathCalulate Addition = (a,b)->a + b;
        MathCalulate Multiplitation = (int a,int b)->{return a * b;};

        int rtn = Multiplitation.Calulate(3,2);
        System.out.println(rtn);

    }

    interface MathCalulate{
        int Calulate(int a,int b);
    }

}

