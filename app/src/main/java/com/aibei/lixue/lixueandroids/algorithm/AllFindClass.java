package com.aibei.lixue.lixueandroids.algorithm;

/**
 * 作者：lixue on 2019/7/5 17:44
 */

public class AllFindClass {

    //二分查找
    private int halfFind(int data,int[] arrs){
        int mid;
        int low = 0;
        int high = arrs.length -1;
        while (low <= high){
            mid = (low + high)/2;
            if (arrs[mid] < data){
                low = mid + 1;
            }else if(arrs[mid] > data){
                high = mid - 1;
            }else {
                return arrs[low];
            }
        }
        return -1;
    }

    private void maopao(int[] arr){
        int temp;
        if (arr != null && arr.length > 0){
            for (int i = 0;i < arr.length - 1;i ++){
                for (int j = 0;j < arr.length - 1- i;j ++){
                 if (arr[j] > arr[j + 1]){
                     temp = arr[j];
                     arr[j] = arr[j + 1];
                     arr[j + 1] = temp;
                 }
                }
            }
        }
    }

}
