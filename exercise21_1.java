package com.example.java22.activity11;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Arrays;

public class exercise21_1 {
    public static void main(String[] args) {
        Set<String> first = new LinkedHashSet<>(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
        Set<String> second = new LinkedHashSet<>(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));

        //birigu
        Set<String> union = new LinkedHashSet<>(first);
        union.addAll(second);
        System.out.println("union: " + union);

        //aiyrmashylyk
        Set<String> difference = new LinkedHashSet<>(first);
        difference.removeAll(second);
        System.out.println("difference: " + difference);

        //kiylisu
        Set<String> intersection = new LinkedHashSet<>();
        for (String e: second) {
            if (first.contains(e))
                intersection.add(e);
        }
        System.out.println("intersection: " + intersection);
    }
}
