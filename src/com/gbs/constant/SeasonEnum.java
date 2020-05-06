package com.gbs.constant;

/**
 * Created by t.g.
 * on 2020.5.4
 * 季节
 */
public enum SeasonEnum {
    SPRING(1),SUMMER(2),AUTOMN(3),WINTER(4);
    private int seq;
    SeasonEnum(int seq) {
        this.seq = seq;
    }
    public int getSeq()
    {
        return seq;
    }
}
