package com.pdm.pascal;

public class TrianglePascal {

    public static void searchRow(long[] arr, int n) {

        int i, j;
        for (i = 0; i <= n; i++)
            arr[i] = 0;
        arr[0] = 1;

        for (j = 0; j <= n; j++)
            for (i = j; i >= 1; i--)
                arr[i] = arr[i - 1] + arr[i];
    }


    public static void output(long[] arr, int n) {

        for (int i = 0; i <= n; i++)
            System.out.print(arr[i] + " ");
    }

}
