package com.gbs.designpattern.chain;

/**
 * 责任链模式(ChainNode of Responsibility Pattern)
 * 应用场景举例：顾客结算时可以使用不同种类的优惠券（可以多选）
 *      审批流程时，可以使用责任链
 */
public class Context {
    ChainNode discountChain;

    public Context() {

    }

    public void SetStrategy(ChainNode discountChain)
    {
        this.discountChain = discountChain;
    }

    public int Calculate()
    {
        return discountChain.Calulate(250);
    }
}
