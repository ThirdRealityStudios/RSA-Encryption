package rsa;

import java.math.BigInteger;

public class PublicKey
{
    public BigInteger n, e;

    public PublicKey(BigInteger n, BigInteger e)
    {
        this.n = n;
        this.e = e;
    }
}
