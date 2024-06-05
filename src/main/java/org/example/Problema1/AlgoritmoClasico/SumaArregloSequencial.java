package org.example.Problema1.AlgoritmoClasico;

public class SumaArregloSequencial {

    public static int sumaSequencial(int[] numeros){
        int sum = 0;
        for (int numero : numeros) {
            sum += numero;
        }
        return sum;
    }

}
