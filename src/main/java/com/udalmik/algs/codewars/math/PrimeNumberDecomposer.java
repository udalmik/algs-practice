package com.udalmik.algs.codewars.math;

import java.util.*;

class PrimeNumberDecomposer {

    /**
     * Return value: List of all prime factors of a given number n
     */
    public static Long[] getAllPrimeFactors(long n) {
        if (n == 1 || n == 2) {
            return new Long[]{n};
        }
        return getPrimeFactors(n).toArray(new Long[]{});
    }

    /**
     * Return value: List containing two lists, first containg all prime factors without duplicates,
     * second containing the count, how often each prime factor occured.
     * Return code always contains two lists.
     * <p>
     * e.g.: getUniquePrimeFactorsWithCount(100) = {{2,5},{2,2}) // prime 2 occurs 2 times, prime 2 occurs 5 times,
     */
    public static Long[][] getUniquePrimeFactorsWithCount(long n) {

        if (n == 1) {
            return new Long[][]{{1L}, {1L}};
        }

        if (n == 2) {
            return new Long[][]{{2L}, {1L}};
        }

        if (n == 0) {
            return new Long[][]{{}, {}};
        }

        final List<Long> primeFactors = getPrimeFactors(n);
        final Map<Long, Long> factorsWithCount = new LinkedHashMap<>();

        for (Long primeFactor : primeFactors) {
            if (factorsWithCount.containsKey(primeFactor)) {
                factorsWithCount.put(primeFactor, factorsWithCount.get(primeFactor) + 1);
            } else {
                factorsWithCount.put(primeFactor, 1L);
            }
        }

        Long[][] result = new Long[2][factorsWithCount.size()];

        int i = 0;
        for (Map.Entry<Long, Long> entry : factorsWithCount.entrySet()) {
            result[0][i] = entry.getKey();
            result[1][i] = entry.getValue();
            i++;
        }

        return result;
    }

    /**
     * Return value: List containing product of same prime factors,
     * e.g.: 45 = 3*3*5 ==>  {3^2,5^1} == {9,5}
     * e.g.: getUniquePrimeFactorsWithCount(100) = {{2,5},{2,2}) // prime 2 occurs 2 times, prime 2 occurs 5 times,
     */
    public static Long[] getPrimeFactorPotencies(long n) {
        if (n == 1 || n == 2) {
            return new Long[]{n};
        }

        Long[][] primeFactorsWithCount = getUniquePrimeFactorsWithCount(n);

        Long[] result = new Long[primeFactorsWithCount[0].length];

        for (int i = 0; i < primeFactorsWithCount[0].length; i++) {
            result[i] = (long) Math.pow(primeFactorsWithCount[0][i], primeFactorsWithCount[1][i]);
        }

        return result;
    }

    private static List<Long> getPrimeFactors(long n) {

        List<Long> factors = new ArrayList<>();

        long upperBound = (long) Math.sqrt(n);

        for (long i = 2; i <= upperBound; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        return factors;

    }

    public static void main(String[] args) {
        getPrimeFactors(100L);
        getUniquePrimeFactorsWithCount(100L);
        getAllPrimeFactors(100);
        getPrimeFactorPotencies(100);
    }


}

