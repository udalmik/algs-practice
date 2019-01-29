package com.udalmik.algs.interviewbit.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sieve {

    public ArrayList<Integer> sieve(int n) {

        if (n == 1) return new ArrayList<>(Collections.singletonList(1));
        if (n == 2) return new ArrayList<>(Arrays.asList(1, 2));
        if (n == 3) return new ArrayList<>(Arrays.asList(1, 2, 3));

        boolean[] sieve = new boolean[n + 1];

        for (int i = 0; i < sieve.length; i++) {
            sieve[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            if (sieve[i]) {
                for (int j = 2; j * i <= n; j++) {
                    sieve[j * i] = false;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (sieve[i]) {
                res.add(i);
            }
        }

        return res;

    }

}
