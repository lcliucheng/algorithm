package com.lc.algorithm.interview;

/**
 * @author liu cheng
 * @since 2020-04-23 16:16
 */
public class WaysToChange {
    /**
     * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
     * <p>
     * 示例1:
     * <p>
     * 输入: n = 5
     * 输出：2
     * 解释: 有两种方式可以凑成总金额:
     * 5=5
     * 5=1+1+1+1+1
     * 示例2:
     * <p>
     * 输入: n = 10
     * 输出：4
     * 解释: 有四种方式可以凑成总金额:
     * 10=10 1
     * 10=5+5  2
     * 10=1+1+1+1+1+1+1+1+1+1 1
     * <p>
     * 25
     * 25=25 1
     * 25=10+10+5 5
     * 25=5+5+5+5+5 5
     * 1
     * <p>
     * 50
     * 50= 25+25  1
     * <p>
     * 1*a+5*b+10*c+25*e =n
     * 0<=a<=n
     * 0<b<n/5
     * 0<c<n/10
     * 0<e<25/e
     */
    static int[] aa = {5, 10, 25};

    public static int waysToChange(int n) {
        int num=0;
        int a = n;
        int b = n / 5;
        int c = n / 10;
        int d = n / 25;
        for (int i = 0; i <= a; i++) {
            int e = (n - i * 1);
            if(e==0){
                num+=1;
            }
            if (e % 5 == 0) {
                int g = e / 25;

            }

        }

        return num;
    }

    public static void main(String[] args) {
        int i = waysToChange (61);
        System.out.println (i);
    }
}
