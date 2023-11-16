package com.list;

import java.util.Comparator;

public class Fraction implements UserType{
    public Fraction() {
        integerPart = 1;
        numerator = 1;
        denominator = 2;
    }

    @Override
    public String typeName() {
        return String.valueOf(this.getClass());
    }

    @Override
    public Object create() {
        Fraction fraction = new Fraction();
        return new Fraction();

    }

    //@Override
    public static Object clone(Object obj) {
        Fraction fraction = new Fraction();
        fraction.setDenominator(((Fraction)obj).getDenominator());
        fraction.setNumerator(((Fraction)obj).getNumerator());
        fraction.setIntegerPart(((Fraction)obj).getIntegerPart());
        return fraction;
    }

    @Override
    public Comparator<Object> getTypeComparator() {
        return new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                double fraction1 = ((double) ((Fraction)o1).numerator)/((Fraction)o1).denominator ;
                double fraction2 = ((double) ((Fraction)o2).numerator)/((Fraction)o2).denominator ;
                if(((Fraction)o1).integerPart != ((Fraction)o2).integerPart) {
                    System.out.println();
                    return ((Fraction) o1).integerPart - ((Fraction) o2).integerPart;
                }
                else
                    return Double.compare(fraction1, fraction2);
            }
        };
    }


    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public void setIntegerPart(int integerPart) {
        this.integerPart = integerPart;
    }

    public int getDenominator() {
        return denominator;
    }

    public int getIntegerPart() {
        return integerPart;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                integerPart + " " +
                numerator + "/" +
                denominator + "}";
    }

    private int numerator;
    private int denominator;
    private int integerPart;
}
