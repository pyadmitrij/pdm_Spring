package com.pdm.pascal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        long[] arr = new long[1000];
        System.out.println("Enter row triangle pascal: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        TrianglePascal.searchRow(arr, n);
        TrianglePascal.output(arr, n);

    }
}
