
import java.util.ArrayList;
import java.util.List;

public class GetStairsPath {
    public static void main(String[] args) {
        List<String> ans = getSP(3);
        System.out.println(ans);
    }

    public static List<String> getSP(int n){

        if(n == 0){
            List<String> elist = new ArrayList<>();
            elist.add("");
            return elist;
        }else if(n < 0){
            return new ArrayList<>(); 
        }

        List<String> path1 = getSP(n-1);
        List<String> path2 = getSP(n-2);
        List<String> path3 = getSP(n-3);

        List<String> mlist = new ArrayList<>();

        for(String path : path1){
            mlist.add("1" + path);
        }

        for(String path : path2){
            mlist.add("2" + path);
        }

        for(String path : path3){
            mlist.add("3" + path);
        }


        return mlist;
        
    }
}
