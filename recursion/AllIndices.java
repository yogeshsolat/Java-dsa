import java.util.Arrays;

public class AllIndices {
    public static void main(String[] args) {

      int[] arr = new int[] {10,20,80,70,40,50,80};
      int[] idxs = allIndices(arr,80,0,0);
      System.out.println(Arrays.toString(idxs));
        
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf){

        if(idx == arr.length){
            return new int[fsf];
        }

        if(arr[idx] == x){
           int[] ans = allIndices(arr, x, idx+1, fsf+1);
           ans[fsf] = idx;
           return ans;
        }else{
           int[] ans = allIndices(arr, x, idx+1, fsf);
           return ans;
        }

    }
}
