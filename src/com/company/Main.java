package com.company;

import anotations.FrutoSeco;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {

        BolsitaMarcaA bolsitaMarcaA = new BolsitaMarcaA();
        int caloriasTotalesA = contarCaloriasTotalesFrutosSecos(bolsitaMarcaA);
        System.out.println("Calorias totales de los frutos secos de una bolsita de la marca 'A': " + caloriasTotalesA);

    }

    private static int contarCaloriasTotalesFrutosSecos(final Object bolsita) {
        Class<?> claseBolsita = bolsita.getClass();

        int caloriasTotales = 0;

        final Field[] variables = claseBolsita.getDeclaredFields();

        for (final Field variable : variables){

            final Annotation anotacionObtenida = variable.getAnnotation(FrutoSeco.class);

            if (anotacionObtenida != null && anotacionObtenida instanceof FrutoSeco) {
                final FrutoSeco anotacionFrutoSeco = (FrutoSeco) anotacionObtenida;

                int calorias = anotacionFrutoSeco.calorias();

                int cantidad = 0;
                try {
                    variable.setAccessible(true);
                    cantidad = variable.getInt(bolsita);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }

                String nombreFrutoSeco = variable.getName();

                System.out.println("	-Hay " + cantidad + " de " + nombreFrutoSeco + ", y cada una tiene " + calorias + " calorías");

                caloriasTotales += (cantidad * calorias);
            }

        }

        return caloriasTotales;
    }


}
