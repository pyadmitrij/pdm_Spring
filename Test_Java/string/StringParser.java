package com.pdm.string;

public final class  StringParser {

    public static String[] parser(String str) throws Exception {

        String[] numbers = str.split("[^0-9*/+-]");

        for (int i = 0; i < numbers.length; i++) {

            String[] res = numbers[i].split("[^0-9]");
            int[] a = new int[res.length];

            if (numbers[i].contains("*")) {
                for (int j = 0; j < a.length; j++)
                    a[j] = Integer.parseInt(res[j]);
                int mul = a[0] * a[1];
                numbers[i] = Integer.toString(mul);
            }

            if (numbers[i].contains("/")) {
                for (int j = 0; j < a.length; j++)
                    a[j] = Integer.parseInt(res[j]);
                int div = 0;
                if (a[1] == 0)
                    throw new Exception("Cannot be divided by zero!!!");
                else
                    div = a[0] / a[1];
                numbers[i] = Integer.toString(div);
            }

            if (numbers[i].contains("+")) {
                for (int j = 0; j < a.length; j++)
                    a[j] = Integer.parseInt(res[j]);
                int add = a[0] + a[1];
                numbers[i] = Integer.toString(add);
            }

            if (numbers[i].contains("-")) {
                for (int j = 0; j < a.length; j++)
                    a[j] = Integer.parseInt(res[j]);
                int mul = a[0] - a[1];
                numbers[i] = Integer.toString(mul);
            }
        }
        return numbers;
    }
}
