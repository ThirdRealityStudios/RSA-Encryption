package math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class PrimeNumberFactory
{
    public boolean isPrimeNumber(BigInteger number)
    {
        if(number.compareTo(BigInteger.ONE) < 0 || number.equals(BigInteger.ONE))
        {
            return false;
        }

        boolean isPrimeNumber = true;

        for(BigInteger i = BigInteger.valueOf(2); i.compareTo(number) < 0; i = i.add(BigInteger.ONE))
        {
            if(number.mod(i).equals(BigInteger.ZERO))
            {
                isPrimeNumber = false;
            }
        }

        return isPrimeNumber;
    }

    public BigInteger getPrimeNumber(BigInteger index)
    {
        index = index.add(BigInteger.ONE);

        BigInteger primeNumberCounter = BigInteger.ZERO;

        BigInteger number = BigInteger.valueOf(2L);

        while(true)
        {
            if(isPrimeNumber(number))
            {
                primeNumberCounter = primeNumberCounter.add(BigInteger.ONE);

                if(primeNumberCounter.equals(index))
                {
                    return number;
                }
            }

            number = number.add(BigInteger.ONE);
        }
    }

    public BigInteger randPrimeNumber(int bitLength)
    {
        BigInteger rand = BigInteger.probablePrime(bitLength, new Random((long) (Math.random() * Long.MAX_VALUE)));



        return rand;
    }

    private BigInteger mul(ArrayList<BigInteger> factors)
    {
        BigInteger product = BigInteger.ONE;

        for(BigInteger bI : factors)
        {
            product = product.multiply(bI);
        }

        return product;
    }

    // This will factorize the value of 'm' so it is made up of prime numbers only or by itself (see online for "prime factorization").
    public ArrayList<BigInteger> factorize(BigInteger m, boolean ignoreDoubleFactors)
    {
        ArrayList<BigInteger> factors = new ArrayList<>();

        BigInteger factorMatch = BigInteger.ZERO;

        BigInteger primeNumberIndex = BigInteger.ZERO;

        while(!factorMatch.equals(m))
        {
            BigInteger primeNumber = getPrimeNumber(primeNumberIndex);

            factorMatch = mul(factors).multiply(primeNumber);

            BigInteger mod = m.mod(factorMatch);

            if(factorMatch.compareTo(m) > 0)
            {
                factors.clear();

                if(m.compareTo(BigInteger.ONE) > 0)
                {
                    factors.add(m);
                }

                return factors;
            }

            if((mod.compareTo(BigInteger.ZERO) > 0))
            {
                primeNumberIndex = primeNumberIndex.add(BigInteger.ONE);
            }
            else
            {
                factors.add(primeNumber);
            }
        }

        ArrayList<BigInteger> factorsNoDoubles = new ArrayList<BigInteger>();

        if(ignoreDoubleFactors)
        {
            for(BigInteger bI : factors)
            {
                if(!factorsNoDoubles.contains(bI))
                {
                    factorsNoDoubles.add(bI);
                }
            }

            factors = factorsNoDoubles;
        }

        return factors;
    }

    public BigInteger lookupPrimeNumber(ArrayList<BigInteger> exceptions, BigInteger max)
    {
        for(BigInteger i = BigInteger.ZERO; i.compareTo(max) < 0; i = i.add(BigInteger.ONE))
        {
            BigInteger primeNumber = getPrimeNumber(i);

            if(!exceptions.contains(primeNumber))
            {
                return primeNumber;
            }
        }

        // Will never happen but Java requires this..
        return BigInteger.ZERO;
    }
}
