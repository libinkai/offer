package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/1/13 18:09
 **/

public class Problem263 {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem263().isUgly(8));
    }
}
