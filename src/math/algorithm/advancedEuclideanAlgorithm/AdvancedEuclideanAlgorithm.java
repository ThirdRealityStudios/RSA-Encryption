package math.algorithm.advancedEuclideanAlgorithm;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class AdvancedEuclideanAlgorithm
{
    private TempResult calculateForward(TempResult source)
    {
        // Make sure e / m and e mod m is always calculated before.
        source.emDivided = source.e / source.m;
        source.emRemainer = source.e % source.m;

        // After that return the next temporary result (except for a and b which cannot be calculated yet).
        TempResult result = new TempResult(source.m, source.emRemainer);
        result.emDivided = source.m / source.emRemainer;
        result.emRemainer = source.m % source.emRemainer;

        return result;
    }

    private LinkedList<TempResult> calculateForward(long e, long m)
    {
        LinkedList<TempResult> results = new LinkedList<TempResult>();

        results.push(new TempResult(e,m));

        TempResult current = calculateForward(results.getLast());

        do
        {
            results.push(current);

            current = calculateForward(current);
        }
        while(current.emRemainer > 0);

        results.push(current);

        return results;
    }

    private long calculateBackward(LinkedList<TempResult> forwardedResults)
    {
        TempResult previous = forwardedResults.pop();
        previous.a = 0L;
        previous.b = 1L;

        long m = forwardedResults.getLast().m;

        while(forwardedResults.size() > 0)
        {
            TempResult current = forwardedResults.pop();

            current.a = previous.b;
            current.b = previous.a - (current.emDivided * previous.b);

            previous = current;
        }

        return previous.a <= 0 ? (previous.a + m) : previous.a;
    }

    // This is the RSA-related method which will return the value d.
    public long calculate_d(long e, long m)
    {
        return calculateBackward(calculateForward(e, m));
    }
}
