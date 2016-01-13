/*
ID: lucy.wi1
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ride {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        String thisLine = null;
        StringTokenizer st;
        ArrayList<char[]> codes = new ArrayList<char[]>();
        Integer fmod = null;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        // or map = new HashMap<Character, Integer> if you are using something before Java 7.
        map.put('A', 1);
        map.put('B', 2);
        map.put('C', 3);
        map.put('D', 4);
        map.put('E', 5);
        map.put('F', 6);
        map.put('G', 7);
        map.put('H', 8);
        map.put('I', 9);
        map.put('J', 10);
        map.put('K', 11);
        map.put('L', 12);
        map.put('M', 13);
        map.put('N', 14);
        map.put('O', 15);
        map.put('P', 16);
        map.put('Q', 17);
        map.put('R', 18);
        map.put('S', 19);
        map.put('T', 20);
        map.put('U', 21);
        map.put('V', 22);
        map.put('W', 23);
        map.put('X', 24);
        map.put('Y', 25);
        map.put('Z', 26);

        while ((thisLine = f.readLine()) != null) {
            char[] charArray = thisLine.toCharArray();
            codes.add(charArray);
        }

        for (int i = 0; i < codes.size(); i++) {
            int val = 1;
            char[] charA = codes.get(i);
            for (int j = 0; j < charA.length; j++) {
                char c = charA[j];
                val = val * map.get(c);
            }
            int mod = val % 47;

            if (fmod == null) {
                fmod = mod;
            } else {
                if (fmod == mod) {
                    out.println("GO");
                    out.close();
                } else {
                    out.println("STAY");
                    out.close();
                }
            }
        }
    }
}
