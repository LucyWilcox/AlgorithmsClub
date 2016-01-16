/*
ID: lucy.wi1
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.Scanner;

public class beads {
    static int numBeads;
    public static void main (String [] args) throws IOException {
        Scanner scanner = new Scanner(new File("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        numBeads =  scanner.nextInt();
        String beads = scanner.next();
        String reverseBeads = new StringBuilder(beads).reverse().toString();
        int max = 0;
        for(int i = 0; i < numBeads; i++){
            char[] forwardBeads = (beads.substring(i) + beads).toCharArray();
            int forward = checkBeads(forwardBeads);
            if(forward >= numBeads){
                max = numBeads;
            }
            else {
                String beadBackSub = new StringBuilder(beads.substring(0, i)).reverse().toString();
                String allBackBeads = beadBackSub + reverseBeads;
                char[] backwardBeads = allBackBeads.substring(0, forward).toCharArray();
                int backward = checkBeads(backwardBeads);
                int total = forward + backward;
                if (total > max)
                    if( total >= numBeads)
                        max = numBeads;
                    else
                    max = total;
            }
        }

        out.println(max);
        out.close();
    }

    public static int checkBeads(char[] checkArr){
        int blue = 0;
        int red = 0;
        boolean isBlue = true;
        boolean isRed = true;

        for(int i = 0; i < numBeads && i < checkArr.length; i++){
            if(checkArr[i] == 'w'){
                if(isBlue)
                    blue ++;
                if(isRed)
                    red ++;
            }
            else if(checkArr[i] == 'b'){
                if(isBlue)
                    blue++;
                isRed = false;
            }
            else{
                if(isRed)
                    red++;
                isBlue = false;
            }
        }
        if (blue > red) {
            return blue;
        }
        else
            return red;
    }
}
