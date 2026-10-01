public class Subsequence {

    public static void main(String[] args) {
        printSS("abc", "");
    }

    public static void printSS(String ques, String ans) {

        if(ques.length() <= 0){
            System.out.println(ans);
            return;
        }

        // Each character creates two choices: include it or leave it out.
        char ch = ques.charAt(0);
        String rstr = ques.substring(1);

        printSS(rstr, ans+ch);
        printSS(rstr, ans);
        
    }
}
