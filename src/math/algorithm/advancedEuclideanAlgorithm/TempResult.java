package math.algorithm.advancedEuclideanAlgorithm;

import java.math.BigInteger;

public class TempResult
{
    public BigInteger e, m, emDivided, emRemainer;
    public BigInteger a, b;

    public TempResult(BigInteger e, BigInteger m)
    {
        this.e = e;
        this.m = m;
        this.emDivided = emDivided;
        this.emRemainer = emRemainer;
    }

    @Override
    public String toString()
    {
        return "(TempResult | ID: " + hashCode() + "):\ne = " + e + "\nm = " + m + "\ne / m = " + emDivided + "\ne mod m = " + emRemainer + "\na = " + a + "\nb = " + b;
    }
}
