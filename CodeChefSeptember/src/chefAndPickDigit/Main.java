package chefAndPickDigit;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Rasal
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ChefAndPickDigit solver = new ChefAndPickDigit();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ChefAndPickDigit {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String a = in.next();

            ArrayList<Character> c = new ArrayList<>();
            HashMap<Character, Integer> map = new HashMap<>();
            int i = 0;
            while (i < a.length()) {
                char d = a.charAt(i);
                if (map.containsKey(d)) {
                    map.put(d, map.get(d) + 1);
                } else {
                    map.put(d, 1);
                }
                i++;
            }
          //  out.println("iterated");
            if (map.containsKey('6') && map.containsKey('5')) {
                c.add('A');
            }
            if (map.containsKey('6') && map.get('6') >= 2) {
                c.add('B');
            }
            if (map.containsKey('6') && map.containsKey('7')) {
                c.add('C');
            }
            if (map.containsKey('6') && map.containsKey('8')) {
                c.add('D');
            }
            if (map.containsKey('6') && map.containsKey('9')) {
                c.add('E');
            }
            if (map.containsKey('7') && map.containsKey('0')) {
                c.add('F');
            }
            if (map.containsKey('7') && map.containsKey('1')) {
                c.add('G');
            }
            if (map.containsKey('7') && map.containsKey('2')) {
                c.add('H');
            }
            if (map.containsKey('7') && map.containsKey('3')) {
                c.add('I');
            }
            if (map.containsKey('7') && map.containsKey('4')) {
                c.add('J');
            }
            if (map.containsKey('7') && map.containsKey('5')) {
                c.add('K');
            }
            if (map.containsKey('7') && map.containsKey('6')) {
                c.add('L');
            }
            if (map.containsKey('7') && map.get('7') >= 2) {
                c.add('M');
            }
            if (map.containsKey('7') && map.containsKey('8')) {
                c.add('N');
            }
            if (map.containsKey('7') && map.containsKey('9')) {
                c.add('O');
            }
            if (map.containsKey('8') && map.containsKey('0')) {
                c.add('P');
            }
            if (map.containsKey('8') && map.containsKey('1')) {
                c.add('Q');
            }
            if (map.containsKey('8') && map.containsKey('2')) {
                c.add('R');
            }
            if (map.containsKey('8') && map.containsKey('3')) {
                c.add('S');
            }
            if (map.containsKey('8') && map.containsKey('4')) {
                c.add('T');
            }
            if (map.containsKey('8') && map.containsKey('5')) {
                c.add('U');
            }
            if (map.containsKey('8') && map.containsKey('6')) {
                c.add('V');
            }
            if (map.containsKey('8') && map.containsKey('7')) {
                c.add('W');
            }
            if (map.containsKey('8') && map.get('8') >= 2) {
                c.add('X');
            }
            if (map.containsKey('8') && map.containsKey('9')) {
                c.add('Y');
            }
            if (map.containsKey('9') && map.containsKey('0')) {
                c.add('Z');
            }
            //  Collections.sort(c);
            for (int k = 0; k < c.size(); k++) {
                out.print(c.get(k));
            }
            out.println();
        }

    }
}

