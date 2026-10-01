public class PPermutation {
    public static void main(String[] args) {
        
        print_permutations("abc", "");
    }

    // public static void print_permutations(String str, String ans){

    //     if(str.length() == 0){
    //         System.out.println(ans);
    //         return;
    //     }

    //     for(int i = 0; i < str.length(); i++){
    //         char ch = str.charAt(i);
    //         String rstr ="";

    //         for(int j = 0; j < str.length(); j++){
    //             if(str.charAt(j) != ch){
    //                 rstr+= str.charAt(j);
    //             }
    //         }

    //         print_permutations(rstr, ans+ch);
    //     }
    // }

    public static void print_permutations(String str, String ans){

        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        // Fix one character here, then permute the remaining string.
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String leftSs =  str.substring(0,i);
            String rightSs = str.substring(i+1);

            
            print_permutations(leftSs + rightSs, ans+ch);
        }
    }
}

