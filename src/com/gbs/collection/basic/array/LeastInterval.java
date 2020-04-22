package com.gbs.collection.basic.array;

public class LeastInterval {
    public static int calculate(char[] tasks, int n)
    {
        int rtn = 0;
        int lenth = tasks.length; //任务总数
        if(lenth == 0)
            return 0;
        n = n + 1; //一个元素的执行周期。
        int tmp;
        int maxCnt = 0,disCnt = 0;  //单体任务出现次数最多，任务种类个数。
        int maxCntCnt = 0; //单体任务最多的记录的并列次数。
        int j = 0;
        for (int i = 0; i < tasks.length; i ++) {
            tmp = 0;
            if(tasks[i] == '\0')
                continue;
            disCnt ++;  //新种类出现
            tmp ++; //当前种类计数开始
            for(int k = i + 1; k < tasks.length; k ++)
            {
                if(tasks[k] == tasks[i]) {
                    tmp ++;  //当前种类计数增加。
                    tasks[k] = '\0';  //命中过得的种类置空
                }
            }
            if(tmp == maxCnt)  //出现并列最多
                maxCntCnt ++;
            else if(tmp > maxCnt) {
                //出现次数最多的新任务记录
                maxCntCnt = 1;
                maxCnt = tmp;
            }
            //
            j ++;
        }
        // 因为n个时间单位内，单种类只能运行1次，
        // 所以把任务总数除以n求商（向上取整），和数量最高的单个任务比较，取大数
        int average = lenth / n ;
        if(average >= maxCnt)
            rtn = average * n + lenth % n;
        else {
            rtn = (maxCnt - 1) * n + 1 + maxCntCnt - 1;
            int avg = (lenth / n) * n + lenth % n;
            rtn = avg > rtn ? avg : rtn;
        }
        return rtn;
    }

    public static void main(String[] args) {
        char[] tasks = {'G','C','A','H','A','G','G'};
        int rtn = calculate(tasks,1);
        System.out.println(rtn);
    }
}
