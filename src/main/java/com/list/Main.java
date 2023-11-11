package com.list;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
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
        list.add(10);
        list.add(5);
        list.add(11);

       // list.printList();
        //System.out.println(list.get(-1));
       // list.add(10, 0);
        //list.add(1, 0);
//        list.add(1, 0);
//        list.add(1, 0);

        list.add(5, 0);
        list.add(3, 0);
        list.add(4, 0);
        System.out.println(list.getSize());

        list.printList();
        list.serializeToXML();
//        System.out.println(list.remove(1));
//        System.out.println(list.remove(1));
//        System.out.println(list.remove(1));
//        System.out.println(list.remove(0));
//        list.remove(1);
//        list.remove(1);
//        list.remove(1);
//        list.printList();
          list.quickSort(0, list.getSize() - 1);
          list.printList();
        System.out.println(list.get(3).getData());
//        list.printList();
    }
}