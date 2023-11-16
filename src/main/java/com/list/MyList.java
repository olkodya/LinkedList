package com.list;

import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.Comparator;

public class MyList implements Serializable {

    public void add(Object ob) {
        Node cur = head;
        if (head == null) {
            head = new Node(null, ob);
            size++;
            return;
        }
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }
        Node node = new Node(null, ob);
        size++;
        cur.setNext(node);
    }

    public Node get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index " + index);
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }
        return cur;
    }

    public void add(Object ob, int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index " + index);
        }
        Node cur = head;
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = cur;
            cur = cur.getNext();
        }
        Node node = new Node(null, ob);
        if (prev == cur) {
            head = node;
            node.setNext(cur);
            size++;
            return;
        }
        size++;
        prev.setNext(node);
        node.setNext(cur);
    }


    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index " + index);
        }
        Node cur = head;
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = cur;
            cur = cur.getNext();
        }
        if (cur == prev)
            head = head.getNext();
        Object ob = cur.getData();
        prev.setNext(cur.getNext());
        size--;
        return ob;
    }

    public int getSize() {
        return size;
    }


    void swap(Node a, Node aPrev, Node b, Node bPrev) {
        if (a.getNext() == b) {
            a.setNext(b.getNext());
            b.setNext(a);
            if (aPrev != null)
                aPrev.setNext(b);
            else head = b;
        } else {
            Node tmp = a.getNext();
            a.setNext(b.getNext());
            b.setNext(tmp);
//            if (aPrev != null) {
//                Node tmp1 = aPrev.getNext();
//                aPrev.setNext(bPrev.getNext());
//                if (bPrev != null) {
//                    bPrev.setNext(tmp1);
//                }
//            } else head = b;
            if(aPrev!=null)
                aPrev.setNext(b);
            else
                head = b;
            if(bPrev!=null)
                bPrev.setNext(a);

        }

    }


    int partition(int start, int end, Comparator comparator) {
        Node pivot = get(end);
        Node prev, pPrev, pivotPrev;
        if (end - 1 < 0)
            pivotPrev = null;
        else
            pivotPrev = get(end - 1);
        if (start - 1 < 0)
            pPrev = null;
        else
            pPrev = get(start - 1);
        Node cur = get(start);
        int pIndex = start;
        Node p = get(pIndex);
        if (start - 1 < 0)
            prev = null;
        else
            prev = get(start - 1);
        // if (pivot.getData() instanceof Integer) {
        while (cur != pivot) {
            if (comparator.compare(cur.getData(), pivot.getData()) <= 0) {
//                if ((Integer) cur.getData() <= (Integer) pivot.getData()) {
                swap(p, pPrev, cur, prev);
                if (cur == pivotPrev)
                    pivotPrev = p;
                Node tmp = p;
                pPrev = cur;
                p = cur.getNext();
                pIndex++;
                cur = tmp.getNext();
                prev = tmp;
            } else {
                prev = cur;
                cur = cur.getNext();
            }
        }
        swap(p, pPrev, pivot, pivotPrev);
        // }
        return pIndex;
    }


    public void quickSort(int start, int end, Comparator comparator) {
        if (start >= end)
            return;
        int pivot = partition(start, end, comparator);
        quickSort(start, pivot - 1, comparator);
        quickSort(pivot + 1, end, comparator);
    }


    public void printList() {
        Node cur = head;
        if (size == 0){
            System.out.println("List is empty");
            return;
        }
        while (cur != null) {
            System.out.print(cur.getData() + " ");
            cur = cur.getNext();
        }
        System.out.println();
    }

    public void forEach(CallBack callBackInt) {
        Node cur = head;
        while (cur != null) {
            callBackInt.toDo(cur.getData());
            cur = cur.getNext();
        }
    }


    public static void serializeToBinary(MyList list) throws IOException {
        File file = new File("temp.out");
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.flush();
        oos.close();
    }

    public static MyList deserializeFromBinary() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        return (MyList) oin.readObject();
    }


    @Nullable
    private Node head = null;


    private int size = 0;
}
