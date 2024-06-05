package org.example;

import org.example.Problema1.AlgoritmoClasico.SumaArregloParalelo;
import org.example.Problema1.AlgoritmoClasico.SumaArregloSequencial;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("Problema 1");
        System.out.println();

        Random random = new Random();
        random.setSeed(1234);

        int[] numeros = new int[1000000000];

        for (int i = 0; i < 1000000000; i++) {
            numeros[i] = random.nextInt(100000 + 1);
        }

        long startTime = System.currentTimeMillis();
        System.out.println(SumaArregloSequencial.sumaSequencial(numeros));
        long endTime = System.currentTimeMillis();

        System.out.println("Sequential Time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        System.out.println(SumaArregloParalelo.sumaParalelo(numeros, 4));
        endTime = System.currentTimeMillis();

        System.out.println("Paralel Time: " + (endTime - startTime));

        System.out.println();

    }
}