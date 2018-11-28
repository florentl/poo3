package com.example.libquest;

import java.math.BigDecimal;


public class Test {


    public static void main(String args[]) {
        System.out.println(fuelPrice(196, 28.4));
    }


    public static double fuelPrice(int litres, double pricePerLiter) {
        double pricePerLiterWithDiscount = pricePerLiter;
        for (int i = 2; i <= 10; i += 2) {
            if (litres >= i) {
                pricePerLiterWithDiscount -= 0.05;
            }
        }
        BigDecimal bdResult = new BigDecimal( (litres * pricePerLiterWithDiscount) ).setScale( 2, BigDecimal.ROUND_HALF_DOWN );
        return bdResult.doubleValue();

    }

}
