public class PFibonacci {

    public static void main(String[] args) {
        
        // printFibonacciRec(0,1,10,0);
        printFiboNormal(10);
    }

    public static void printFibonacciRec(int num1,int num2, int target, int level){

        if(target >= level){
            return;
        }

        System.out.println(num1);
        printFibonacciRec(num2, num2 + num1, target, level + 1);


    }


    public static void printFiboRec(int a, int b, int n) {
        if(n == 0) return;

        System.out.println(a);
        printFiboRec(b, a + b, n - 1);
    }


    public static void printFiboNormal(int n) {
        int num1 = 0;
        int num2 = 1;
        
        for(int i = 0 ; i <= n ; i++){

            System.out.println(num1);
            int temp = num1 + num2;
            num1 = num2;
            num2 = temp;
        }
    }
}
