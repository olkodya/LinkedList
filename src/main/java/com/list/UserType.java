package com.list;

import java.io.Serializable;
import java.util.Comparator;

public interface UserType extends Serializable {
    public String typeName();

    public static Object create() {
        return null;
    }

    public static Object clone(Object obj) {
        return null;
    }

    public Object parseValue(String ss);

    public Comparator<Object> getTypeComparator();
}
