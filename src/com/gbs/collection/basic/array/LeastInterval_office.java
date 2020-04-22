package com.gbs.collection.basic.array;

import java.util.Arrays;

public class LeastInterval_office {
    public static int calculate(char[] tasks, int n)
    {
        int rtn = 0;

        if(tasks.length == 0)
            return 0;
        int []map = new int[26];

        for(int t:tasks)
        {
            map[t - 'A'] ++;
        }

        Arrays.sort(map);

        while(map[25] > 0)
        {
            for(int i = 0; i <= n ; i ++)
            {
                //要判断n > 25情况
                if(i > 25)
                {
                    rtn += (n - i + 1);
                    break;
                }
                //如果是最后一轮，最多的任务已经执行完成。第i+1多的任务已经不存在
                if(map[25] == 0 && i > 0 && map[25 - i] <= 0)
                    break;
                map[25 - i]--;
                rtn ++;
            }
            
            Arrays.sort(map);
        }

        return rtn;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int rtn = calculate(tasks,2);
        System.out.println(rtn);
    }
}

