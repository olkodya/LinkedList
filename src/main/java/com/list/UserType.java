package com.list;

import java.util.Comparator;

public interface UserType  {
    public String typeName();
    public Object create();

    public static Object clone(Object obj) {
        return null;
    }

    public Comparator<Object> getTypeComparator();
}
