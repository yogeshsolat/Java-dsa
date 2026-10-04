
import java.util.ArrayList;
import java.util.List;

public class GetKeypadCombination {

    public static void main(String[] args) {
       List<String> ans = getKpc("567");
       System.out.println(ans.size());
       System.out.println(ans);
    }

    public static String[] arr = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static List<String> getKpc(String str){

        if(str.length() == 0){
            List<String> emptyList = new ArrayList<>();
            emptyList.add("");
            return emptyList;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);

        List<String> combinations =  getKpc(ros);

        String alphabets = arr[ch - '0'];

        List<String> mlist =  new ArrayList<>();

        for (String combination : combinations) {
            
            for(int i = 0; i < alphabets.length(); i++){
                char c = alphabets.charAt(i);
                mlist.add(c + combination);
            }
        }

        return mlist;

    }
    
}



