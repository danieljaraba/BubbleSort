import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private final Scanner sc;

    public Main(){
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main main = new Main();

        int n = main.sc.nextInt();
        main.sc.nextLine();

        ArrayList<String> cases = main.readCases(n);
        main.showSort(cases);
        main.sc.close();
    }

    public ArrayList<String> readCases(int n){
        ArrayList<String> cases = new ArrayList<>();
        for(int i = 0; i<n; i++){
            cases.add(sc.nextLine());
        }
        return cases;
    }

    public void showSort(ArrayList<String> cases){
        double changes;
        double iterations;
        double prom;
        String sortedCase;
        String[] splittedArray;
        double[] parsedArray;
        double vault;
        for(int i = 0; i<cases.size(); i++){
            changes = 0;
            iterations = 0;
            sortedCase = "";
            splittedArray = cases.get(i).split(" ");
            parsedArray = new double[splittedArray.length];
            for(int b = 0; b<splittedArray.length; b++){
                parsedArray[b] = Double.parseDouble(splittedArray[b]);
            }
            for(int b = 0; b<parsedArray.length; b++){
                iterations++;
                for(int c = 0; c<parsedArray.length-1; c++){
                    if(parsedArray[c]>parsedArray[c+1]){
                        vault = parsedArray[c+1];
                        parsedArray[c+1] = parsedArray[c];
                        parsedArray[c] = vault;
                        changes++;
                    }
                }
            }
            for(int b = 0; b<parsedArray.length; b++){
                if(b == 0){
                    sortedCase += parsedArray[b];
                } else{
                    sortedCase += " " + parsedArray[b];
                }
            }
            if(iterations != 0){
                prom = (float)(changes/(iterations-1));
                prom = Math.floor(prom*100)/100;
            } else{
                prom = 0;
            }
            System.out.println(prom + "-" + sortedCase);
        }

    }
}
