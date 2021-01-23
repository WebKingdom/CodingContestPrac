package edu.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class GoogleLucky12015 {

    private static class Pair<String, Integer> {
        String website;
        int ranking;

        Pair(String w, int r) {
            website = w;
            ranking = r;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();

        for (int i = 1; i <= numTestCases; i++) {
            ArrayList<Pair> al = new ArrayList<>();
            Pair<String, Integer> p = new Pair<>(scan.next(), scan.nextInt());
            al.add(p);

            for (int j = 0; j < 9; j++) {
                p = new Pair<>(scan.next(), scan.nextInt());

                if (p.ranking > al.get(0).ranking) {
                    al.clear();
                    al.add(p);
                } else if (p.ranking == al.get(0).ranking) {
                    al.add(p);
                }
            }

            System.out.println("Case #" + i + ":");
            for (int j = 0; j < al.size(); j++) {
                System.out.println(al.get(j).website);
            }
        }
    }
}
