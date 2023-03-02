import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
public class Permutations {
    public static void main(String args[]) {
        ArrayList<Integer> a = new ArrayList<Integer>();

        int n = 52;
        int r = 5;

        int desiredOutcome = 1;         //Desired binomial
        double successProbability = .5; //Chance of Success
        int add = 4;                    //Additional probabilities
        boolean inverse = false;        //Inverse?

        int trials = 5;                 //Number of trials simulated
        double p = .50;

        //System.out.println(geometricDistribution(trials, p, 0, false));
        System.out.println("The combination of " + n + " and " + r + " is " + combination(n, r));
        System.out.println("The permutation of " + n + " and " + r + " is " + permutation(n, r));
        System.out.printf("P(%d) =  %.3f%%\n", desiredOutcome, 100 * binomialDistribution(trials, desiredOutcome, successProbability));
        System.out.printf("Inversed?: %b; P(%d) * %d =  %.3f%%\n", inverse, desiredOutcome, add, 100 * binomialDistribution(trials, desiredOutcome, successProbability, add, inverse));
        System.out.printf("P(X = %d) =  %.3f%%\n", desiredOutcome, 100 * geometricDistribution(trials, p, 0, false));
    }

    public static BigInteger combination(int N, int R) {
        BigInteger r = BigInteger.valueOf(R);
        BigInteger n = BigInteger.valueOf(N);

        return (factorial(n).divide((factorial(r).multiply(factorial(n.subtract(r))))));
    }

    public static BigInteger permutation(int N, int R) {
        BigInteger r = BigInteger.valueOf(R);
        BigInteger n = BigInteger.valueOf(N);

        return (factorial(n).divide(factorial(n.subtract(r))));
    }

    public static BigInteger factorial(BigInteger x) {
        BigInteger y = BigInteger.valueOf(1);   // y = 1
        for (int i = 0; i < x.intValue() - 1; i++)
            y = y.multiply(x.subtract(BigInteger.valueOf(i)));
        return y;
    }

    public static double binomialDistribution(int n, int y, double p) {
        return (combination(n, y).doubleValue() * Math.pow(p, y) * Math.pow((1 - p), n - y));
    }

    public static double binomialDistribution(int n, int y, double p, int x, boolean inversed) {

        double combinedProb = 0;
        for (int i = 0; i < x + 1; i++) {
            combinedProb += combination(n, y + i).doubleValue() * Math.pow(p, y + i) * Math.pow((1 - p), n - (y + i));
            //System.out.println(n +"C"+ (y+i) + " times " + (p) +" to the "+ (y+i) + " times " + (1-p) +" to the "+ (n-(y+i)));
            //System.out.println(i+y+1 + ": combined prob: " + combination(n,y+i).doubleValue()*Math.pow(p,y+i)*Math.pow((1-p), n-(y+i)));
        }

        if (inversed)
            combinedProb = (1 - combinedProb);
        return (combinedProb);
    }

    public static double geometricDistribution(int y, double p, int x, boolean inversed)
    {
        double combinedProb = 0;

        combinedProb = Math.pow((1-p),(y))*(p);
        return combinedProb;
    }


}
