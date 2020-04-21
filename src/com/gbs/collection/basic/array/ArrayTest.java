package com.gbs.collection.basic.array;

public class ArrayTest {
    /*试题3： 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
            找出给定目标值在数组中的开始位置和结束位置。
            
        你的算法时间复杂度必须是 O(log n) 级别。
        如果数组中不存在目标值，返回 [-1, -1]。
        */
    public int[] searchRange(int[] nums, int target) {
        int []rtn = {-1,-1};
        if(nums.length == 0)
            return rtn;
        int nLeft = 0, nRight = nums.length - 1;
        int nHarf = (nLeft + nRight) / 2;

        //首先定位到某一个目标。
        while(nRight - nLeft > 0 && nums[nHarf] != target)
        {
            if(nums[nHarf] < target)
                nLeft = nHarf + 1;
            else
                nRight = nHarf - 1;
            nHarf = (nLeft + nRight) / 2;
        }

        //查找最左目标和最右目标。
        if(nums[nHarf] == target) {
            int nNewRight = nHarf;
            while(nNewRight - nLeft > 0)
            {
                int nNewHarf = (nLeft + nNewRight) / 2;
                if (nums[nNewHarf] == target) //继续向左找
                {
                    nNewRight = nNewHarf;
                }
                else
                {
                    nLeft = nNewHarf + 1;
                }

            }
            rtn[0] = nLeft; //此时的nNewRight == nLeft;

            int nNewLeft = nHarf;
            while(nRight - nNewLeft > 0) {
                int nNewharf = (nRight + 1 + nNewLeft) / 2;
                if(nums[nNewharf] == target) //继续向后右找
                {
                    nNewLeft = nNewharf;
                }
                else
                {
                    nRight = nNewharf - 1;
                }
            }
            rtn[1] = nRight; //此时nNewLeft = nRight;
        }
        return rtn;
    }

    public static void test3()
    {
        int []a = {0,1,2,3,4,4,4};
        int []rtn = (new ArrayTest()).searchRange(a,1);
        System.out.println(rtn[0] + "," + rtn[1]);
    }

//-------------------------------------------------------------------

    //试题2：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    // 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    //你可以假设数组中无重复元素。
    public int searchInsert(int[] nums, int target) {
        //采用折半查抄,答案总是优秀
        int nRight = nums.length - 1;
        int nLeft = 0;
        while(nLeft <= nRight)
        {
            int nHarf = (nRight + nLeft) / 2;
            if(nums[nHarf] == target)
                return nHarf;
            if(nums[nHarf] > target) {
                nRight = nHarf - 1;
            }
            else {
                nLeft = nHarf + 1;
            }
        }

        return nLeft;



        /*我的暴力查找方法，不理想
        for(int i = 0; i < nums.length; i ++)
        {
            if(target <= nums[i])
                return i;
        }
        return nums.length;*/
    }

    public static void test2(){
        int [] a = {1,3,7,9};
        int rtn = (new ArrayTest()).searchInsert(a,19);
        System.out.println(rtn);
    }

//-------------------------------------------------------------------


    //试题1：
    public int removeDuplicates(int[] nums) {
        //官方答案太优秀
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


        /* 我的思路比较惨，涉及到拷贝数组。
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



    }

    public void test1()
    {
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

    public static void main(String[] args) {

        test3();
    }
}
