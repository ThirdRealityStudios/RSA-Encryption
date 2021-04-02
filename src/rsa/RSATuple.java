package rsa;

import math.PrimeNumberFactory;
import math.algorithm.advancedEuclideanAlgorithm.AdvancedEuclideanAlgorithm;

import java.math.BigInteger;
import java.util.ArrayList;

public class RSATuple
{
    // Only keeps a system-relative range for the lookup of random prime numbers for p and q (will not strengthen the security!).
    private long range;

    // Two prime numbers chosen randomly.
    private long p, q;

    private long m, n;

    private PublicKey publicKey;
    private PrivateKey privateKey;

    private PrimeNumberFactory pNF;
    private AdvancedEuclideanAlgorithm aEA;

    private boolean debug;

    public RSATuple(boolean debug)
    {
        this.debug = debug;

        pNF = new PrimeNumberFactory();
        aEA = new AdvancedEuclideanAlgorithm();

        // Just creates a system-relative range for the lookup of random prime numbers for p and q (will not strengthen the security!).
        range = Integer.MAX_VALUE / (Short.MAX_VALUE * 16);

        renew();
    }

    public PublicKey getPublicKey()
    {
        return publicKey;
    }

    public PrivateKey getPrivateKey()
    {
        return privateKey;
    }

    // Renews the whole RSA tuple with randomly chosen values.
    // Can be used to establish a secure connection.
    public void renew()
    {
        //p = pNF.randPrimeNumber(range);
        //q = pNF.randPrimeNumber(range);

        p = 11;
        q = 47;

        n = p * q;
        m = (p - 1) * (q - 1);

        ArrayList<Long> exceptions = pNF.factorize(m, true);

        // 'e' must be a prime number, must be below m and may not be an element of any prime factors.
        long e = pNF.lookupPrimeNumber(exceptions, m);

        long d = aEA.calculate_d(e, m);

        publicKey = new PublicKey(n, e);
        privateKey = new PrivateKey(n, d);

        if(debug)
        {
            System.out.println("p (¹, ²) = " + p);
            System.out.println("q (¹, ²) = " + q);
            System.out.println("n ( ³  ) = " + n);
            System.out.println("m (¹, ²) = " + m);
            System.out.println("e ( ³  ) = " + e);
            System.out.println("d (¹, ⁴) = " + d);
            System.out.println();
            System.out.println("Legend: ¹ = critical; ² = usually unknown; ³ = uncritical; ⁴ = private key");
        }
    }
}
