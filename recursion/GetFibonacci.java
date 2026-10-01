public class GetFibonacci {
    
    public static void main(String[] args) {
        
        System.out.println(getFibonacci(10));
    }

    public static int getFibonacci(int n) {

        // if(n == 0) return 0;
        // if(n == 1) return 1;

        // The two smallest Fibonacci values stop the recursion.
        if(n == 0 || n == 1){
            return n;
        }
        
        int fib1 = getFibonacci(n - 1);
        int fib2 = getFibonacci(n - 2);

        int fibn = fib1 + fib2;

        return fibn;
    }
}

