package com.gbs.designpattern.chain;

public class ChainTest {
    public static void main(String[] args) {
        Context cx = new Context();
        ChainNode distcount = new FullDiscount(null);
        distcount = new HolidayDistcout(distcount);
        cx.SetStrategy(distcount);
        int result = cx.Calculate();
        System.out.println(result); //250 - 10 - 20


    }
}
