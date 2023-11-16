package com.list;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
      // LinkedList<Integer> list = new LinkedList<>();
        MyList list = new MyList();
       list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(11);
        list.add(6);
        list.add(11);
        list.add(4);
        list.add(5);
        list.add(11);
        list.add(3);
        list.add(2);
        list.add(11);

        list.add(11);
        list.add(4);
        list.add(5);

        System.out.println(list.getSize());

        list.printList();
        //list.serializeToXML();

          list.quickSort(0, list.getSize() - 1);
          list.printList();
          MyList.serializeToBinary(list);
        MyList list1;
        list1 = MyList.deserializeFromBinary();
        System.out.println("after deserialization:");
        list1.printList();
        // CallBackInt obj;
        // obj = ((a)->{System.out.println();};
       // System.out.println(list.get(3).getData());
//        list.printList();
        ArrayList<Integer> arrayList = new ArrayList<>();
        list.forEach(System.out::println);
       // CallBack callBack = s->System.out.println(s);;
        list.forEach(System.out::println);
        Fraction fraction = new Fraction();
        System.out.println(fraction);

        Fraction fraction1 = (Fraction) Fraction.clone(fraction);
        System.out.println(fraction1);
        Comparator<Object> comparator = fraction1.getTypeComparator();
        fraction1.setDenominator(5);
        //fraction1.setIntegerPart(10);
        System.out.println(fraction1);
        System.out.println(comparator.compare(fraction1, fraction));
    }
}