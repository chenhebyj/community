package com.example.demo.test;


import java.util.ArrayList;
import java.util.List;



public class Test {
    public static String add(String s1,String s2) {
        //先将输入的两个串逆序生成字符数组
        char[] a = new StringBuilder(s1).reverse().toString().toCharArray();
        char[] b = new StringBuilder(s2).reverse().toString().toCharArray();

        //结果数组的最大长度为两个数组中长度较大的那个再加1
        int lenA = a.length;
        int lenB = b.length;
        int maxlen = lenA > lenB ? lenA : lenB;
        int[] result = new int[maxlen+1];

        //如果当前位超过了最大的长度，补0即可
        for(int i=0; i<maxlen+1; i++) {
            int aint = i < lenA ? (a[i] - '0') : 0;
            int bint = i < lenB ? (b[i] - '0') : 0;
            result[i] = aint + bint;
        }

        //遍历结果数组，大于10进位，当前位取10的模
        for(int i=0; i<result.length; i++) {
            if(result[i] >= 10) {
                result[i+1] += result[i] /10;
                result[i] %= 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (result[maxlen] != 0) {
            sb.append(result[maxlen]);
        }

        for(int i=maxlen-1; i>=0; i--) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "329";
        String ret = add(s1,s2);
        System.out.println("ret is: " + ret);
        int a = (int)Math.pow(10, 3);
    }

}

