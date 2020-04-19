package com.gbs.collection;

public class ArrayTest {
    public int removeDuplicates(int[] nums) {
        /*
        int nSize = nums.length;
        if(nSize == 1)
            return 1;
        for (int i = 0; i < nSize - 1; i++) {
           int nObj = nums[i];
           for(int j = i + 1;j < nSize; )
           {
               if(nums[j] > nObj)
                   break;
               //如果j不是最后元素，把后续的所有元素前移
               if(j < nSize - 1) {
                   for (int k = j + 1; k < nSize; k++) {
                       nums[k - 1] = nums[k];
                   }
               }
               nSize --;

           }
        }
        return nSize;
        */

        if(nums.length <= 1) return nums.length;
        int i = 0;
        for(int j = 1; j < nums.length; j ++)
        {
            if(nums[j] > nums[i])
            {
                i ++;
                nums[i] = nums[j];
            }
        }
        return i + 1;

    }

    public static void main(String[] args) {
        ArrayTest arrayTest = new ArrayTest();
        int []a = {0,0,1,1,1,2,2};
        /*
        * 0,0,1,1,1,2,2
        * 0,1,1,1,1,2,2
        * 0,1,2,1,1,2,2
        * */
        int size = arrayTest.removeDuplicates(a);
        for(int i = 0; i < size; i ++)
            System.out.print(a[i] + ",");

    }
}
