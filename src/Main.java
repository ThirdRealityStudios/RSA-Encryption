
import math.algorithm.advancedEuclideanAlgorithm.AdvancedEuclideanAlgorithm;
import rsa.RSAEncryption;
import rsa.RSATuple;

import java.math.BigInteger;

public class Main
{
    public static void main(String[] args)
    {
        AdvancedEuclideanAlgorithm aEA = new AdvancedEuclideanAlgorithm();

        RSATuple rsa = new RSATuple(true);
        RSAEncryption encryption = new RSAEncryption();

        BigInteger symbol = BigInteger.valueOf('L');

        BigInteger encrypted = encryption.encrypt(symbol, rsa.getPublicKey());
        System.out.println("Encrypted '" + symbol + "' to '" + encrypted + "'");

        BigInteger decrypted = encryption.decrypt(encrypted, rsa.getPrivateKey());
        System.out.println("Decrypted " + encrypted + " to '" + decrypted + "'");
    }
}