package com.gbs.demo;

import com.gbs.constant.SeasonEnum;
import com.gbs.constant.WeekEnum;

import java.math.BigDecimal;

public class Basic {
    /**
     * @param args 参数组
     */
    public static void main(String[] args) {
        //enum study
        int season;
        season = SeasonEnum.SUMMER.getSeq();
        System.out.println(season);
        // 判断是否位夏天并输出
        if (season == SeasonEnum.SUMMER.getSeq()) {
            System.out.println("it's in summer");
        } else {
            System.out.println("it's not in summer");
        }

        System.out.println("---------");
        System.out.println(WeekEnum.FRIDAY);
        System.out.println(WeekEnum.valueOf("FRIDAY"));
        System.out.println("it's a good day.\nwhat do u want?");

        //when Integer not between -128 and 127， you should compare with equal() but not "=".
        System.out.println("---------");
        Integer testA = 33,testB = 33;
        Integer testC = 128,testD = 128;
        if (testA == testB)
            System.out.println("good boy");
        if (testC == testD)
            System.out.println("my god");   // will not print
        if(testC.equals(testD))
            System.out.println("a right way");

        //use BigDecimal but not Double..
        System.out.println("---------");
        BigDecimal a = new BigDecimal("1.0"),
                b = new BigDecimal("0.9"),
                c = new BigDecimal("0.8");
        BigDecimal x = a.subtract(b),
                y = b.subtract(c);
        if (x.equals(y))
            System.out.println("good BidDecimal");

        //split will skip null itme.
        System.out.println("---------");
        String str = "a,b,c,,";
        String[] ary = str.split(",");
        // 预期大于 3，结果是 3
        System.out.println(ary.length);

        //FIXME
        //in loop , use StringBuilder but not "abd += sub"
        System.out.println("---------");
        String[] testString = {"a","b","c"};
        StringBuilder sb = new StringBuilder();
        for (String value:testString) {
            sb.append(value);
        }
        System.out.println(sb);

        System.out.println((-7) % 2);
        int nn = new Basic().testJavaDocNote(0,2);

    }

    /**
     * @param x 参数1
     * @param y 参数2
     * @return 返回结果
     */
    public int testJavaDocNote(int x,int y)
    {
        return x + y;
    }
}
