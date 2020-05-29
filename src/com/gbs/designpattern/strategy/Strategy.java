package com.gbs.designpattern.strategy;

/**
 * created by t.g.
 * on 2020-05-05
 *
 * 对两个整型参数进行相加，相减，或者相乘等运算。
 */
public interface Strategy {
    /**
     * @param x 参数1
     * @param y 参数2
     * @return 运算结果
     */
    int Calulate(int x,int y);
}
