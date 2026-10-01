public class KeypadCombination{

    public static void main(String[] args) {

        printKPC("237", "");
        
    }


    public static String[] arr = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void printKPC(String ques, String ans){

        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }

        // Try each letter for this digit before processing the remaining digits.
        char ch = ques.charAt(0);
        String roq = ques.substring(1);

        String str = arr[ch - '0'];

        for(int i = 0; i < str.length() ; i++){
            printKPC(roq, ans + str.charAt(i));
        }

        
    }
}
