package com.list;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class Main {

    public static void printMenu() {
        System.out.println("Choose option:");
        System.out.println("[1] Add value");
        System.out.println("[2] Add value by index");
        System.out.println("[3] Get value by index");
        System.out.println("[4] Remove value by index");
        System.out.println("[5] Get size of list");
        System.out.println("[6] Sort list");
        System.out.println("[7] Print list");
        System.out.println("[8] Serialize list to Binary File");
        System.out.println("[9] Deserialize list from Binary File");
        System.out.println("[10] Exit");
    }

    public static void menu() {
        MyList list = new MyList();
        System.out.println("Choose data type: 1 - Integer, 2 - Fraction");
        Scanner scanner = new Scanner(System.in);
        int dataType = scanner.nextInt();
        if (dataType == 1) {
            for (int i = 0; i < 10; i++) {
                list.add(MyInteger.create());
            }
        } else {
            for (int i = 0; i < 10; i++) {
                list.add(Fraction.create());
            }
        }
        MyInteger myInteger = new MyInteger();
        Fraction fraction = new Fraction();
        int index;
        if (scanner.hasNextLine()) scanner.nextLine();
        while (true) {
            printMenu();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    if (scanner.hasNextLine()) scanner.nextLine();
                    if (dataType == 1) {
                        System.out.println("Enter integer value");
                        String value = scanner.nextLine();
                        myInteger = (MyInteger) myInteger.parseValue(value);
                        list.add(myInteger);
                    } else {
                        System.out.println("Enter fraction");
                        String value = scanner.nextLine();
                        fraction = (Fraction) fraction.parseValue(value);
                        list.add(fraction);
                    }
                    break;
                case 2:
                    System.out.println("Enter index from 0 to " + (list.getSize() - 1));
                    index = scanner.nextInt();
                    if (scanner.hasNextLine()) scanner.nextLine();
                    if (dataType == 1) {
                        System.out.println("Enter integer value");
                        String value = scanner.nextLine();
                        myInteger = (MyInteger) myInteger.parseValue(value);
                        try {
                            list.add(myInteger, index);
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex);
                        }

                    } else {
                        System.out.println("Enter fraction");
                        String value = scanner.nextLine();
                        fraction = (Fraction) fraction.parseValue(value);
                        try {
                            list.add(fraction, index);
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex);
                        }
                    }
                    break;
                case 3:

                    System.out.println("Enter index from 0 to " + (list.getSize() - 1));
                    index = scanner.nextInt();
                    if (scanner.hasNextLine()) scanner.nextLine();
                    try {
                        System.out.println(list.get(index).getData());
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Enter index from 0 to " + (list.getSize() - 1));
                    index = scanner.nextInt();
                    if (scanner.hasNextLine()) scanner.nextLine();
                    try {
                        System.out.println("Removed element:" + list.remove(index));
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Size of list:" + list.getSize());
                    break;
                case 6:
                    if (dataType == 1) {
                        list.quickSort(0, list.getSize() - 1, myInteger.getTypeComparator());
                    } else {
                        list.quickSort(0, list.getSize() - 1, fraction.getTypeComparator());
                    }
                    break;
                case 7:
                    list.printList();
                    break;
                case 8:
                    try {
                        MyList.serializeToBinary(list);
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 9:
                    try {
                        list = MyList.deserializeFromBinary();
                    } catch (ClassNotFoundException | IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 10:
                    return;
                default:
                    break;
            }

        }

    }

    public static void main(String[] args) {
        menu();

    }
}