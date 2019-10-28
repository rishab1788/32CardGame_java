package CardsLibrary;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int a[] = new int[n];
            for (int j = 0; j < n; j++) {
                a[i] = scan.nextInt();
            }
            int max = 0;
            for (int j = 0; j < n - 1; j++) {
                if (max < (a[j] - a[j + 1])) {
                    max = Math.abs(a[j] - a[j + 1]);
                }
            }
            System.out.println(max);
        }
    }
}

