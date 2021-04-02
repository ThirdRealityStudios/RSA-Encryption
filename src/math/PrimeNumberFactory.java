package math;

import java.util.ArrayList;

public class PrimeNumberFactory
{
    public boolean isPrimeNumber(long number)
    {
        if(number <= 1)
        {
            return false;
        }

        boolean isPrimeNumber = true;

        for(long i = 2; i < number; i++)
        {
            if((number % i) == 0)
            {
                isPrimeNumber = false;
            }
        }

        return isPrimeNumber;
    }

    public long getPrimeNumber(long index)
    {
        index++;

        long primeNumberCounter = 0L;

        long number = 2L;

        while(true)
        {
            if(isPrimeNumber(number))
            {
                primeNumberCounter++;

                if(primeNumberCounter == index)
                {
                    return number;
                }
            }

            number++;
        }
    }

    public long randPrimeNumber(long max)
    {
        long randomIndex = (long) (Math.random() * max);

        return getPrimeNumber(randomIndex);
    }

    private long mul(ArrayList<Long> factors)
    {
        long product = 1L;

        for(long l : factors)
        {
            product *= l;
        }

        return product;
    }

    // This will factorize the value of 'm' so it is made up of prime numbers only or by itself (see online for "prime factorization").
    public ArrayList<Long> factorize(long m, boolean ignoreDoubleFactors)
    {
        ArrayList<Long> factors = new ArrayList<>();

        long factorMatch = 0L;

        int primeNumberIndex = 0;

        while(factorMatch != m)
        {
            long primeNumber = getPrimeNumber(primeNumberIndex);

            factorMatch = mul(factors) * primeNumber;

            long mod = m % factorMatch;

            if(factorMatch > m)
            {
                factors.clear();

                if(m > 1)
                {
                    factors.add(m);
                }

                return factors;
            }

            if((mod > 0))
            {
                primeNumberIndex++;
            }
            else
            {
                factors.add(primeNumber);
            }
        }

        ArrayList<Long> factorsNoDoubles = new ArrayList<Long>();

        if(ignoreDoubleFactors)
        {
            for(long l : factors)
            {
                if(!factorsNoDoubles.contains(l))
                {
                    factorsNoDoubles.add(l);
                }
            }

            factors = factorsNoDoubles;
        }

        return factors;
    }

    public long lookupPrimeNumber(ArrayList<Long> exceptions, long max)
    {
        for(long i = 0; i < max; i++)
        {
            long primeNumber = getPrimeNumber(i);

            if(!exceptions.contains(primeNumber))
            {
                return primeNumber;
            }
        }

        // Will never happen but Java requires this..
        return 0L;
    }
}
