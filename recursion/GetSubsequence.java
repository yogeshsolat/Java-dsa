import java.util.ArrayList;

class GetSubsequence{

    public static void main(String[] args) {

        ArrayList<String> res = gss("abc");
        System.out.println(res);
        
    }

    public static ArrayList<String> gss(String str){

        if(str.length() == 0 ){
            ArrayList<String> emptyList =  new ArrayList<>();
            emptyList.add("");
            return emptyList;
        }

        char ch = str.charAt(0);
        String rstr = str.substring(1);

        ArrayList<String> ss = gss(rstr);

        ArrayList<String> mss =  new ArrayList<>();

        for(String s : ss){
            mss.add("_" + s);
            mss.add(ch + s);
        }

        // for(String s : ss){
        //     String newStr =  ch + s;
        //     mss.add(newStr);
        // }

        return mss;
    }
}