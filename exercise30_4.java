package com.example.java22.activity13;

public class exercise30_4 {
    private static Integer summa = 0;

    public static void main(String[] args) {

        for (int i = 0; i <= 1000; i++) {
            Thread thread = new Thread() {
                public void run() {
                    synchronized (summa) {
                        summa++;
                    }
                }
            };
            thread.start();
        }
        System.out.println(summa);
    }
}
