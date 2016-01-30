import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by lwilcox on 1/25/2016.
 */
public class baseball {
    static int numCows;
    public static void main (String [] args) throws IOException {
        Scanner scanner = new Scanner(new File("baseball.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("baseball.out")));
        numCows =  scanner.nextInt();
        ArrayList<Integer> cows = new ArrayList<Integer>();
        for(int i = 0; i < numCows; i++){
            Integer cow = scanner.nextInt();
            cows.add(cow);
        }
        Collections.sort(cows);
        Integer endCow = cows.get(numCows-1);
        System.out.println(endCow);
        ArrayList<Integer> cowsBinary = new ArrayList<Integer>(endCow);
        while(cowsBinary.size() < endCow) cowsBinary.add(0);
        for(int i = 0; i < numCows; i++){
            Integer cowPostion = cows.get(i);
            System.out.println(cowPostion);
            cowsBinary.add(cowPostion, 1);
        }

        System.out.println(cowsBinary);
        for(int i = 0; i < cowsBinary.size(); i++){
            if(cowsBinary.get(i) == 1){
                
            }
        }
        //out.println(max);
        out.close();
    }

}
