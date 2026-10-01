public class Subset {
    public static void main(String[] args) {
        
        int[] arr = new int[]{10,20,30,40,50};

        printSubsets(arr, 60, "", 0, 0);
    }

    public static void printSubsets(int[] arr, int target, String set, int sum, int idx){

        if(target == sum){
            System.out.println(set);
            return;
        }
        if(sum > target ){
            return;
        }

        // Decide whether to include this element, then move to the next index.
        if(idx < arr.length){
            printSubsets(arr, target, set + arr[idx] + ",", sum + arr[idx], idx+1);
            printSubsets(arr, target, set, sum, idx+1);
        }


    }
}

