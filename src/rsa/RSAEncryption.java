package rsa;

import java.math.BigInteger;

public class RSAEncryption
{
    public BigInteger encrypt(BigInteger symbol, PublicKey key)
    {
        return symbol.modPow(key.e, key.n);
    }

    public BigInteger decrypt(BigInteger symbol, PrivateKey key)
    {
        return symbol.modPow(key.d, key.n);
    }
}
