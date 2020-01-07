package com.leetcode.cn.com.recursive.cn;

/**
 * Created by Administrator on 2019/12/12.
 */
public class FeiBo {

    //1,2,3,5,8
    public int func(int n){
        int[] res = new int[n];

        res[0] = 1;
        res[1] = 2;
        int ans = 2;
        while (ans < n){
            res[ans] = res[ans - 1]+ res[ans - 2];
            ans++;
        }
        return res[ans - 1];
    }

    public static void main(String[] args) {
        FeiBo feiBo = new FeiBo();
        System.out.println(feiBo.func(7));
    }
}
