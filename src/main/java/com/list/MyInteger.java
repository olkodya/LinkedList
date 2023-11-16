package com.list;

import java.util.Comparator;
import java.util.Random;

public class MyInteger implements UserType{
    @Override
    public String typeName() {
        return String.valueOf(this.getClass());
    }

    public MyInteger(Integer value) {
        this.value = value;
    }

    public MyInteger() {

    }

    public static Object create() {
        Random r = new Random();
        int randValue = r.nextInt(100) + 1;
        MyInteger myInteger = new MyInteger(randValue);
        return myInteger;
    }

    public static Object clone(Object obj) {
        MyInteger myInteger = new MyInteger();
        myInteger.value = ((MyInteger)obj).value;
        return myInteger;
    }


    @Override
    public Object parseValue(String ss) {
        return new MyInteger(Integer.parseInt(ss));
    }

    @Override
    public Comparator<Object> getTypeComparator() {
        return new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((MyInteger) o1).value - ((MyInteger) o2).value;
            }
        };
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    private Integer value;
}
