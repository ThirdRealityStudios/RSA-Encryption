package rsa;

import java.math.BigInteger;

public class PrivateKey
{
    public BigInteger n, d;

    public PrivateKey(BigInteger n, BigInteger d)
    {
        this.n = n;
        this.d = d;
    }
}