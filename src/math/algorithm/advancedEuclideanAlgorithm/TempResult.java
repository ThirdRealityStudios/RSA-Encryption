package math.algorithm.advancedEuclideanAlgorithm;

public class TempResult
{
    public long e, m, emDivided, emRemainer;
    public Long a, b;

    public TempResult(long e, long m)
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
