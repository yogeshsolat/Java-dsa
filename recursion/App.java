import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static class Records {
        String id;
    String name;
    String city;
    double amount;

    public Records(String[] cols) {
        this.id   = parseString(cols, 0);
        this.name = parseString(cols, 1);
        this.city = parseString(cols, 2);
        this.amount = parseAmount(cols, 3);
    }

    private String parseString(String[] cols, int index) {
        if (index >= cols.length) return null;
        String v = cols[index].trim();
        return v.isEmpty() ? null : v;
    }

    private double parseAmount(String[] cols, int index) {
        if (index >= cols.length) return 0.0;
        try {
            return Double.parseDouble(cols[index].trim().replace(",", ""));
        } catch (Exception e) {
            return 0.0;
        }
    }

        @Override
        public String toString() {
            return id + "|" + name + "|" + city + "|" + amount + "|";
        }
    }

    public static void main(String[] args) {

        ArrayList<Records> list = new ArrayList<>();

        String filePath = "C:\\Users\\i40024176\\Assignment\\Assignment\\Data\\data.txt";

        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            
            String line = br.readLine(); 
            System.out.println(line);
            while ((line = br.readLine()) != null) 
        {

                
           String trimmed = line.trim();

            if (trimmed.isEmpty()) {
              continue;
            }

             if (trimmed.matches("^[\\-\\|\\+\\s]+$")) {
              continue;
             }
 
            //  if (trimmed.equals("Scale factor")) {
            //   continue;
            //  }

                String[] cols = line.split("\\|", -1);
                Records rec = new Records(cols);
                list.add(rec);
            }

        } 
         catch (IOException ex) {
            ex.printStackTrace();
        }

       
        for (Records r : list) {
            System.out.println(r);
        }

        Scanner sc=new Scanner(System.in);
        System.out.println("enter date in (TU 24.02.26) format : ");
        String userInput=sc.nextLine();
        boolean flag=false;
        for(Records r:list)
        {
            
            if(r.id != null & r.id.equals(userInput)) {
               System.out.println(r); 
               flag=true;
            } 
         }

         if(flag==false){
            System.out.print("not found");
         }
}
}