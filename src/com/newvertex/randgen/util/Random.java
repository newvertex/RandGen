package com.newvertex.randgen.util;

import java.util.ArrayList;

public class Random {

    private int start;
    private int end;

    public Random() {
        this(0, 1000);
    }

    public Random(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int randomClass() {
        return new java.util.Random().nextInt(end - start) + start + 1;
    }

    public ArrayList<Integer> randomClass(Integer seed, int number) {
        ArrayList<Integer> result = new ArrayList<>();
        java.util.Random rnd = new java.util.Random(seed);

        for (int i = 0; i < number; i++) {
            result.add(rnd.nextInt(end - start) + start + 1);
        }

        return result;
    }

    public ArrayList<Integer> middleSquare(Integer seed, int number) {
        ArrayList<Integer> result = null;

        while (true) {
            result = new ArrayList<>();
            int i = 0;
            while (i < number) {

                Integer n = seed.toString().length();
                Integer squre = (seed * seed);

                String strSquare = squre.toString();

                if (strSquare.length() == ((2 * n) - 1)) {
                    strSquare = "0" + strSquare;
                }

                String substring = "";
                try {
                    if ((n % 2) == 0) {
                        substring = strSquare.substring((n / 2), (strSquare.length() - (n / 2)));
                        substring = "0." + substring;
                        seed = Integer.parseInt(substring.substring(2));
                        i++;
                        result.add(seed % (end - start) + start + 1);
                    } else {
                        seed = Integer.parseInt(strSquare) + 1;
                    }
                } catch (Exception ex) {
                    result.clear();
                    seed += 1234;
                }
            }

            if (result.size() >= number) {
                break;
            }
            seed += 1234;
        }

        return result;
    }
}
