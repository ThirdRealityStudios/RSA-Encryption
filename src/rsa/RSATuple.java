package rsa;

import math.PrimeNumberFactory;
import math.algorithm.advancedEuclideanAlgorithm.AdvancedEuclideanAlgorithm;

import java.math.BigInteger;
import java.util.ArrayList;

public class RSATuple
{
    // Two prime numbers chosen randomly.
    private BigInteger p, q;

    private BigInteger n, m;

    private PublicKey publicKey;
    private PrivateKey privateKey;

    private PrimeNumberFactory pNF;
    private AdvancedEuclideanAlgorithm aEA;

    private int bitLength;

    private boolean debug;

    public RSATuple(int bitLength, boolean debug)
    {
        this.bitLength = bitLength;

        this.debug = debug;

        pNF = new PrimeNumberFactory();
        aEA = new AdvancedEuclideanAlgorithm();

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
        p = pNF.randPrimeNumber(bitLength);
        q = pNF.randPrimeNumber(bitLength);

        n = p.multiply(q);
        m = p.subtract(BigInteger.valueOf(1L)).multiply(q.subtract(BigInteger.valueOf(1)));

        if(debug)
            System.out.println("[RSATuple]: Starting prime factorization (exceptions)..");

        ArrayList<BigInteger> exceptions = pNF.factorize(m, true);

        if(debug)
            System.out.println("[RSATuple]: Starting lookup for a random prime number (e)..");

        // 'e' must be a prime number, must be below m and may not be an element of any prime factors.
        BigInteger e = pNF.lookupPrimeNumber(exceptions, m);

        if(debug)
            System.out.println("[RSATuple]: Starting calculation (d)..");

        BigInteger d = aEA.calculate_d(e, m);

        if(debug)
            System.out.println("[RSATuple]: Starting creation of keys..");

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
