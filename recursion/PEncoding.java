public class PEncoding {
    
    public static void main(String[] args) {
        printEncodings("103", "");
    }

    static Character arr[] = new Character[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static void printEncodings(String digits, String ans){

        if(digits.length() == 0){
            System.out.println(ans);
            return;
        }

        int num1 = Character.getNumericValue(digits.charAt(0));

        // A leading zero cannot form a one-digit letter encoding.
        if( num1 != 0 && num1 < 9 && digits.length() >= 1){
            printEncodings(digits.substring(1), ans+ arr[num1 - 1]);
        }

        if(digits.length() >= 2 ){
            int num2 = Integer.parseInt(digits.substring(0, 2));
            if(num2 >= 10 && num2 <= 26){
                printEncodings(digits.substring(2), ans+ arr[num2 - 1]);
            }
        }

    }
}

