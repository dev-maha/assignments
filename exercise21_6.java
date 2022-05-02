package com.example.java22.activity11;

import java.util.*;

public class exercise21_6 {
    public static void main(String[] args) {
        int num;
        Scanner scan = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();

        System.out.println("Enter a int.\n p.s. input ends when the input is 0:");

        while ((num = scan.nextInt()) != 0){
            if (!map.containsKey(num)) {
                map.put(num, 1);
            }

            else {
                int period = map.get(num);
                period++;
                map.put(num, period);
            }
        }

        int max = Collections.max(map.values());
        System.out.print("The most occurrences integers are: ");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.println();
    }
}
