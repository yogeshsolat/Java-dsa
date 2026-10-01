public class StairPathDP{

    public static void main(String[] args){

        int n = 10;
        int memoPath = stairPathMemo(n, new int[n + 1]);
        System.out.println("memoPath : "+  memoPath);

        int tabuPath = stairPathTabu(n);
        System.out.println("tabuPath : "+  tabuPath);
    }

    public static int stairPathMemo(int n, int[] qb){

        if(n == 0){
            return 1;
        }

        if(n < 0){
            return 0;
        }

        // The memo table avoids solving the same remaining stair count again.
        if(qb[n] > 0){
            return qb[n];
        }

        int p1 = stairPathMemo(n - 1, qb);
        int p2 = stairPathMemo(n - 2, qb);
        int p3 = stairPathMemo(n - 3, qb);

        int tp = p1 + p2 + p3;

        qb[n] = tp;

        return tp;
    }

    public static int stairPathTabu(int n){

        int dp[] = new int[n + 1];

        // Build upward from the base: there is one way to stand at step zero.
        dp[0] = 1;
        for(int i = 1; i <= n; i++){

            if(i == 1){
                dp[i] = dp[i - 1];
            }else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }else{
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]; 
            }

        }

        return dp[n];

    }
}

