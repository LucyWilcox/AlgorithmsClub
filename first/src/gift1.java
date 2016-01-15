/*
ID: lucy.wi1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class gift1 {
    public static void main (String [] args) throws IOException {
        Scanner scanner = new Scanner(new File("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        int numPeople =  scanner.nextInt();
        String[] peopleOut = new String[numPeople];

        HashMap people = new HashMap();

        for(int i = 0; i < numPeople; i++){
            String name = scanner.next();
            people.put(name, 0);
            peopleOut[i] = name;
        }

        for(int i = 0; i < numPeople; i++){
            String name = scanner.next();
            int giftTotalSize = scanner.nextInt();
            int giftRecipNum = scanner.nextInt();
            int giftSize = 0;
            int giftRemainer = 0;

            if (giftRecipNum != 0) {
                giftSize = giftTotalSize / giftRecipNum;
                giftRemainer = giftTotalSize % giftRecipNum;
            }

            int currMoney = Integer.parseInt(people.get(name).toString());
            currMoney = currMoney - giftTotalSize + giftRemainer;
            people.put(name, currMoney);

            for(int j = 0; j < giftRecipNum; j++){
                String giftRecip = scanner.next();
                currMoney = Integer.parseInt(people.get(giftRecip).toString());
                currMoney += giftSize;
                people.put(giftRecip, currMoney);
            }
        }
        for(int i = 0; i < numPeople; i++){
            String name = peopleOut[i];
            int endMoney = Integer.parseInt(people.get(name).toString());
            out.println(name + " " + endMoney);
        }
        out.close();
    }
}
