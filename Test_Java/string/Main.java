package com.pdm.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        String str = "123_2*14ghfg003sad15/2dasdasd8.10";
        String[] numbers = StringParser.parser(str);
        int[] arr = ArrayUtil.newAddArray(numbers);

        System.out.println("Numbers: ");
        ArrayUtil.printArray(arr);
        System.out.println("Max = " + ArrayUtil.findMax(arr));
        System.out.println("Min = " + ArrayUtil.findMin(arr));
    }
}

