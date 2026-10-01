import java.util.*;

public class StairPath {
    public static void main(String[] args) {
      System.out.println(getSP(4));
      
  }
  
  public static ArrayList<String> getSP(int n){
    
    if(n == 0){
       ArrayList<String> ans = new ArrayList<>();
       ans.add("");
       return ans;
    }else if(n < 0){
       ArrayList<String> ans = new ArrayList<>();
       return ans;
    }
    
    
    // Each returned path is a suffix; prefix the step taken in this call.
    ArrayList<String> paths1 = getSP(n-1);
    ArrayList<String> paths2 = getSP(n-2);
    ArrayList<String> paths3 = getSP(n-3);
    
    ArrayList<String> myPath = new ArrayList<>();
    
    for(String path : paths1){
      myPath.add("1" + path);
    }
    
    for(String path : paths2){
      myPath.add("2" + path);
    }
    
    for(String path : paths3){
      myPath.add("3" + path);
    }
    
    return myPath;
    
  }
}
