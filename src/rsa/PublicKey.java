package rsa;

import java.math.BigInteger;

public class PublicKey
{
    public long n, e;

    public PublicKey(long n, long e)
    {
        this.n = n;
        this.e = e;
    }
}
