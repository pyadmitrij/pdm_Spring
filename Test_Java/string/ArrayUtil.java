package com.pdm.string;

import java.util.ArrayList;
import java.util.List;

public final class ArrayUtil {

    public static int[] newAddArray(String[] numbers) {
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].trim().equals("")) continue;
            array.add(Integer.parseInt(numbers[i]));
        }
        int[] arr = new int[array.size()];
        for (int i = 0; i < array.size(); i++)
            arr[i] = array.get(i);
        return arr;
    }

    public static int findMin(int[] array) {
        if (array.length != 0) {
            int min = array[0];
            for (int i = 0; i < array.length; i++)
                if (min > array[i]) min = array[i];
            return min;
        } else {
            System.out.println("This array is empty!!!");
            return 0;
        }
    }

    public static int findMax(int[] array) {
        if (array.length != 0) {
            int max = array[0];
            for (int i = 0; i < array.length; i++)
                if (max < array[i]) max = array[i];
            return max;
        } else {
            System.out.println("This array is empty!!!");
            return 0;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.println("array[" + i + "] = " + array[i]);
        System.out.println();
    }
}
