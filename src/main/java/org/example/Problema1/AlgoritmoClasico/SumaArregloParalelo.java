package org.example.Problema1.AlgoritmoClasico;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class SumaArregloParalelo{

    public static int sumaParalelo(int[] numeros, int task){
        int length = numeros.length;
        int cantidadNumeros = length/task;

        int suma = 0;

        List<SumaTask> splits = new ArrayList<>();
        for (int i = 1; i <= task; i++){

            int left = cantidadNumeros * (i-1);
            int right = cantidadNumeros * (i);
            if (i == task){
                right = length;
            }

            SumaTask split = new SumaTask(numeros, left, right);
            split.fork();
            splits.add(split);
        }
        for (SumaTask split: splits){
            split.join();
            suma += split.suma;
        }
        return suma;
    }

    private static class SumaTask extends RecursiveTask<Integer> {

        private int[] numeros;
        private int left;
        private int right;
        private int suma;

        public SumaTask(int[] numeros, int left, int right) {
            this.numeros = numeros;
            this.left = left;
            this.right = right;
            this.suma = 0;
        }

        @Override
        protected Integer compute() {
            for (int i = left; i < right; i++) {
                suma += numeros[i];
            }
            return suma;
        }
    }
}
