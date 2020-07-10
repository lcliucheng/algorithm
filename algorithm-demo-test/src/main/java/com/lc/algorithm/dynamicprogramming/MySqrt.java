package com.lc.algorithm.dynamicprogramming;

/**
 * @author liu cheng
 * @since 2020-05-09 11:09
 */
public class MySqrt {

    public static int mySqrt(int x) {
        if(x==0||x==1){
            return x;
        }
        int a=x/2;
        int temp=0;
        for(int i=1;i<=a;i++){
            long aLong = Long.valueOf (i);
            if((aLong*aLong)<x){
                temp=i;
            }else if(aLong*aLong==Long.valueOf (x).longValue ()){
                temp=i;
                break;
            }else{
                break;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int i = mySqrt (2147483647);
        System.out.println (i);

        System.out.println (289398*289398);
        System.out.println (46340*46340);
        System.out.println (2147395600);
    }

}
