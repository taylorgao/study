package com.gbs.designpattern.chain;

import java.util.Calendar;

public class HolidayDistcout implements ChainNode {
    ChainNode next;

    public HolidayDistcout(ChainNode next) {
        this.next = next;
    }

    @Override
    public int Calulate(int money) {
        if(money > 100 && isWeekend())
            money = money - 10;
        if(next != null)
            money = next.Calulate(money);
        return money;
    }

    private boolean isWeekend() {
        Calendar   calendar   =   Calendar.getInstance();
        int week =   calendar.get(Calendar.DAY_OF_WEEK)-1;
        return week == 0 || week == 6 ;
    }


}
