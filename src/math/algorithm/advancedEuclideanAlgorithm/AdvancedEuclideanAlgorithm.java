package math.algorithm.advancedEuclideanAlgorithm;

import sun.awt.image.ImageWatched;

import java.math.BigInteger;
import java.util.LinkedList;

public class AdvancedEuclideanAlgorithm
{
    private TempResult calculateForward(TempResult source)
    {
        // Make sure e / m and e mod m is always calculated before.
        source.emDivided = source.e.divide(source.m);
        source.emRemainer = source.e.mod(source.m);

        // After that return the next temporary result (except for a and b which cannot be calculated yet).
        TempResult result = new TempResult(source.m, source.emRemainer);

        result.emDivided = source.m.divide(source.emRemainer);
        result.emRemainer = source.m.mod(source.emRemainer);

        return result;
    }

    private LinkedList<TempResult> calculateForward(BigInteger e, BigInteger m)
    {
        LinkedList<TempResult> results = new LinkedList<TempResult>();

        results.push(new TempResult(e,m));

        TempResult current = calculateForward(results.getLast());

        do
        {
            results.push(current);

            current = calculateForward(current);
        }
        while(current.emRemainer.compareTo(BigInteger.ZERO) > 0);

        results.push(current);

        return results;
    }

    private BigInteger calculateBackward(LinkedList<TempResult> forwardedResults)
    {
        TempResult previous = forwardedResults.pop();
        previous.a = BigInteger.ZERO;
        previous.b = BigInteger.ONE;

        BigInteger m = forwardedResults.getLast().m;

        while(forwardedResults.size() > 0)
        {
            TempResult current = forwardedResults.pop();

            current.a = previous.b;
            current.b = previous.a.subtract(current.emDivided.multiply(previous.b));

            previous = current;
        }

        return previous.a.compareTo(BigInteger.ZERO) <= 0 ? (previous.a.add(m)) : previous.a;
    }

    // This is the RSA-related method which will return the value d.
    public BigInteger calculate_d(BigInteger e, BigInteger m)
    {
        return calculateBackward(calculateForward(e, m));
    }
}
