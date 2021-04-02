package rsa;

import java.math.BigInteger;

public class RSAEncryption
{
    public BigInteger encrypt(BigInteger symbol, PublicKey key)
    {
        return symbol.modPow(BigInteger.valueOf(key.e), BigInteger.valueOf(key.n));
    }

    public BigInteger decrypt(BigInteger symbol, PrivateKey key)
    {
        return symbol.modPow(BigInteger.valueOf(key.d), BigInteger.valueOf(key.n));
    }
}
