package com.udalmik.algs.interviewbit.math;

import java.util.*;

/**
 * https://www.interviewbit.com/problems/prime-sum/
 */
public class PrimeSum {


    public ArrayList<Integer> primesum(int number) {

        Set<Integer> primes = sieve(number);

        Integer first = Integer.MAX_VALUE;
        Integer second = Integer.MAX_VALUE;

        for (Integer prime : primes) {
            int diff = number - prime;
            if (primes.contains(diff)) {
                int firstCandidate = Math.min(prime, diff);
                int secondCandidate = Math.max(prime, diff);
                if (firstCandidate < first) {
                    first = firstCandidate;
                    second = secondCandidate;
                }
            }
        }

        return new ArrayList<>(Arrays.asList(first, second));
    }

    public Set<Integer> sieve(int n) {

        if (n == 1) return new HashSet<>(Collections.singletonList(1));
        if (n == 2) return new HashSet<>(Arrays.asList(1, 2));
        if (n == 3) return new HashSet<>(Arrays.asList(1, 2, 3));

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

        Set<Integer> res = new HashSet<>();

        for (int i = 2; i <= n; i++) {
            if (sieve[i]) {
                res.add(i);
            }
        }

        return res;

    }
}
