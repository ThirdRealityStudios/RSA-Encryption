package rsa;

import java.math.BigInteger;

public class PrivateKey
{
    public long n, d;

    public PrivateKey(long n, long d)
    {
        this.n = n;
        this.d = d;
    }
}