
import java.util.ArrayList;
import java.util.List;

public class GetMazePaths {
    
    public static void main(String[] args) {
        
        List<String> ans = getMazePaths(1, 1, 3, 3);
        System.out.println(ans);
    }

    public static List<String> getMazePaths(int sr, int sc, int dr, int dc){

        if(sr == dr && sc == dc){
            List<String> emptylist = new ArrayList<>();
            emptylist.add("");
            return emptylist;
        }else if(sr > dr || sc > dc){
            List<String> emptylist = new ArrayList<>();
            return emptylist;
        }

        List<String> vpaths = getMazePaths(sr + 1, sc, dr, dc);
        List<String> hpaths = getMazePaths(sr, sc + 1, dr, dc);

        List<String> allPaths = new ArrayList<>();

        for(String path : vpaths){
            allPaths.add("v" + path);
        }

        for(String path : hpaths){
            allPaths.add("h" + path);
        }

        return allPaths;
    }
}
