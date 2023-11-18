package com.list;

import java.util.Comparator;
import java.util.Random;

public class Fraction implements UserType {
    public Fraction() {
        integerPart = 1;
        numerator = 1;
        denominator = 2;
    }

    public Fraction(final int integerPart, final int numerator, final int denominator) {
        if (isFractionValid(numerator, denominator)) {
            this.numerator = numerator;
            this.denominator = denominator;
            this.integerPart = integerPart;
        } else {
            this.integerPart = 1;
            this.numerator = 1;
            this.denominator = 2;
        }

    }

    public static boolean isFractionValid(int numerator, int denominator) {
        if (numerator >= denominator)
            return false;
        return denominator != 0;
    }

    @Override
    public String typeName() {
        return String.valueOf(this.getClass());
    }


    public static UserType create() {
        Random r = new Random();
        int randIntPart = r.nextInt(100) + 1;
        int randNum = r.nextInt(100) + 1;
        int ranDen = r.nextInt(100) + 1;
        while (!isFractionValid(randNum, ranDen)) {
            randNum = r.nextInt(100) + 1;
            ranDen = r.nextInt(100) + 1;
        }
        Fraction fraction = new Fraction(randIntPart, randNum, ranDen);
        return fraction;
    }

    //@Override
    public static UserType clone(UserType obj) {
        Fraction fraction = new Fraction();
        fraction.setDenominator(((Fraction) obj).getDenominator());
        fraction.setNumerator(((Fraction) obj).getNumerator());
        fraction.setIntegerPart(((Fraction) obj).getIntegerPart());
        return fraction;
    }


    @Override
    public UserType parseValue(String ss) {
        String[] parts = ss.split(" ");
        String[] frParts = parts[1].split("/");
        Fraction fraction = new Fraction(Integer.parseInt(parts[0]), Integer.parseInt(frParts[0]), Integer.parseInt(frParts[1]));
        return fraction;
    }

    @Override
    public Comparator<Object> getTypeComparator() {
        return new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                double fraction1 = ((double) ((Fraction) o1).numerator) / ((Fraction) o1).denominator;
                double fraction2 = ((double) ((Fraction) o2).numerator) / ((Fraction) o2).denominator;
                if (((Fraction) o1).integerPart != ((Fraction) o2).integerPart) {
                    return ((Fraction) o1).integerPart - ((Fraction) o2).integerPart;
                } else
                    return Double.compare(fraction1, fraction2);
            }
        };
    }


    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        if (isFractionValid(numerator, denominator)) {
            this.numerator = numerator;
        } else
            this.numerator = 1;
    }

    public void setDenominator(int denominator) {
        if (isFractionValid(numerator, denominator)) {
            this.denominator = denominator;
        } else
            this.denominator = 2;

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
