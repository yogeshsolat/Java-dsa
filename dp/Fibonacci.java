
public class Fibonacci{

    public static void main(String[] args) {

        int n = 10;
        int[] qb = new int[n + 1];
        int ans  = getFibo(n, qb);

        System.out.println(ans);
        
    }

    public static int getFibo(int n, int[] qb){

        if(n == 0 || n == 1){
            return n;
        }

        // Reuse a Fibonacci value that an earlier call already computed.
        if(qb[n] != 0){
            return qb[n];
        }

        int fib1 = getFibo(n - 1, qb);
        int fib2 = getFibo(n - 2, qb);

        int fibn = fib1 + fib2;

        qb[n] = fibn;

        return fibn;
    }
}
