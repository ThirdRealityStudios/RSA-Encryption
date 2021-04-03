
import math.algorithm.advancedEuclideanAlgorithm.AdvancedEuclideanAlgorithm;
import rsa.RSAEncryption;
import rsa.RSATuple;

import java.math.BigInteger;

public class Main
{
    public static void main(String[] args)
    {
        RSATuple rsa = new RSATuple(12, true);
        RSAEncryption encryption = new RSAEncryption();

        BigInteger symbol = BigInteger.valueOf(515L);

        System.out.println("Starting encryption..");

        BigInteger encrypted = encryption.encrypt(symbol, rsa.getPublicKey());
        System.out.println("Encrypted '" + symbol + "' to '" + encrypted + "'");

        BigInteger decrypted = encryption.decrypt(encrypted, rsa.getPrivateKey());
        System.out.println("Decrypted " + encrypted + " to '" + decrypted + "'");
    }
}