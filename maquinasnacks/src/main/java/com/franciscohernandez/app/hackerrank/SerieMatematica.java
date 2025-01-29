package com.franciscohernandez.app.hackerrank;

import java.util.Scanner;

public class SerieMatematica {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        if (t < 0 || t > 500)
            in.close();

        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            if ((n >= 1 && n <= 15) && (a >= 0 && a <= 50) && (b >= 0 && b <= 50)) {
                int resultado = 0;
                int potenciaDos = 1;
                for (int j = 0; j < n; j++) {
                    resultado += potenciaDos * b;
                    System.out.print((a + resultado) + " ");
                    potenciaDos *= 2;
                }
                System.out.println();
            }
        }
        in.close();
    }
}
