package com.gbs.random;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        /*
        0 <= d < 1
        不要将 x 放大 10 的若干倍然后
        取整，直接使用 Random 对象的 nextInt 或者 nextLong 方法。
        */
        double d = Math.random();
        System.out.println(d);

        for (int i = 0; i < 10; i++) {
            System.out.println(new Random().nextInt(100));
        }
    }
}
